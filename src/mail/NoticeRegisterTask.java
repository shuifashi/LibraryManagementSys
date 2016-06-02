package mail;
import com.LMS.ssh.beans.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.sql.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NoticeRegisterTask extends TimerTask {
	private static Logger log = Logger.getLogger(NoticeRegisterTask.class.toString());
	public void sendEmail() {
		Connection con;
		Statement sql; 
		ResultSet rs;
		ArrayList<registerMail> list = new ArrayList<registerMail>();
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf8","root","root");
			sql=con.createStatement();
			String statement= "select * from registermail";
			System.out.println(statement);
			rs = sql.executeQuery(statement);
			while(rs.next()) {
				int userid = rs.getInt(1);
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
			con.close();
		}catch(SQLException exp){
			System.out.println(exp);
		}
		/*if(!list.isEmpty()) {
			System.out.println(list.size());
			mailSender mail = new mailSender(list);
			mail.run();
		}*/
	    }
	 @Override
	public void run() {
		 try {
			 sendEmail();
		 } catch (Exception e) {
			 log.info("-------------解析信息发生异常--------------");
		 }
	 }
}
