package mail;

import java.util.TimerTask;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NFDFlightDataTimerTask extends TimerTask {


	 private static Logger log = Logger.getLogger(NFDFlightDataTimerTask.class.toString());

	 public void sendEmail() {
	    	mailSender mail = new mailSender("727032989@qq.com","123","test");
	    	mail.run();
	    }
	 @Override
	  public void run() {
	   try {
	    //在这里写你要执行的内容
		  sendEmail();
	   } catch (Exception e) {
	    log.info("-------------解析信息发生异常--------------");
	   }
	  }
	 }




