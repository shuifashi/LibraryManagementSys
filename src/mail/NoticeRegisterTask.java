package mail;
import com.LMS.ssh.beans.*;
import com.LMS.ssh.beans.registerMail;

import java.util.*;
import java.util.Date;
import java.util.logging.Logger;
import java.sql.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.LMS.ssh.daoImpl.*;
public class NoticeRegisterTask extends TimerTask {
	private static Logger log = Logger.getLogger(NoticeRegisterTask.class.toString());
	private BookDaoImpl bookDao;
	public NoticeRegisterTask(BookDaoImpl bookDao) {
		this.bookDao = bookDao;
	}
	public synchronized void sendEmail() {
		Connection con;
		Statement sql; 
		ResultSet rs;
		ArrayList<registerMail> list = new ArrayList<registerMail>();
		if(bookDao != null) {
			Book book = (Book)bookDao.getObject("from Book as b where b.bookName like '%浪潮%'");
			System.out.println(book.getAuthor());
		} else {
			System.out.println("bookDao is null");
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf8","root","root");
			sql=con.createStatement();
			String statement= "select * from registermail";
			System.out.println(statement);
			rs = sql.executeQuery(statement);
			if(rs != null) {
				while(rs.next()) {
					String userid = rs.getString(1);
					String email = rs.getString(2);
					String username = rs.getString(3);
					registerMail rM = new registerMail(userid,username,email);
					list.add(rM);
					System.out.println(userid);
					System.out.println(username);
					System.out.println(email);
				}
				sql=con.createStatement();
				statement= "DELETE FROM registermail";
				sql.executeUpdate(statement);
			}
			con.close();
		}catch(SQLException exp){
			System.out.println(exp);
		}
		if(!list.isEmpty()) {
			System.out.println(list.size());
			mailSender mail = new mailSender(list);
			mail.run();
		}
	    }
	 @Override
	public void run() {
		 try {
			Date day = new Date();
			System.out.println(day.toString());
			System.out.println("begin");
			sendEmail();
			System.out.println("end");
		 } catch (Exception e) {
			 log.info("-------------解析信息发生异常--------------");
			 System.out.println(e);
		 }
	 }
}
