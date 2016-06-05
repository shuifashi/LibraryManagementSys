package mail;
import java.util.*;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.LMS.ssh.daoImpl.BookDaoImpl;
import com.LMS.ssh.daoImpl.registerMailDaoImpl;

public class registerNoticeManager {
	private static final long PERIOD_DAY = 2*60*1000;
	private BookDaoImpl bookDao;
	private registerMailDaoImpl registerMail;
	public registerNoticeManager(ServletContextEvent event) {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()); 
		bookDao = (BookDaoImpl)context.getBean("bookDao"); 
		registerMail = (registerMailDaoImpl)context.getBean("registerMailDao");
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	  
		Date date=calendar.getTime(); //第一次执行定时任务的时间
	  
		/*//如果第一次执行定时任务的时间 小于 当前的时间
		//此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。循环执行的周期则以当前时间为准
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
		}*/
		calendar.setTime(new Date());
		date = calendar.getTime();
		Timer timer = new Timer();
	  
		NoticeRegisterTask task = new NoticeRegisterTask(bookDao);
		//安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task,date,PERIOD_DAY);
		
		Timer timer2 = new Timer();
		NoticeRegisterTask task2 = new NoticeRegisterTask(bookDao);
		timer2.schedule(task2, this.addMin(date,1), PERIOD_DAY);
	 	}


	 	// 增加或减少天数
	  	public Date addDay(Date date, int num) {
	  		Calendar startDT = Calendar.getInstance();
	  		startDT.setTime(date);
	  		startDT.add(Calendar.DAY_OF_MONTH, num);
	  		return startDT.getTime();
	  	}
	  	public Date addMin(Date date, int num) {
	  		Calendar startDT = Calendar.getInstance();
	  		startDT.setTime(date);
	  		startDT.add(Calendar.MINUTE, num);
	  		return startDT.getTime();
	  	}
}
