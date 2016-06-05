package mail;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class registerTaskListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		new registerNoticeManager(event);
	}
	public void contextDestroyed(ServletContextEvent event) {}
}
