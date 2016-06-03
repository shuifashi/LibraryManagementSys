package mail;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NFDFlightDataTaskListener implements ServletContextListener {
	  
	  public void contextInitialized(ServletContextEvent event) {
		  new timeManager();
	  }

	 public void contextDestroyed(ServletContextEvent event) {
	  }


	}

