/**
 * 
 */
package com.sh.manage.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sh.manage.task.TimerTaskDemo;

/**
 * 
 * servlet监听器，监听定时任务
 * @author fuzl
 *
 */
public class TimerTaskListener implements ServletContextListener {

	private Timer timer = null;
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("定时器销毁");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		event.getServletContext().log("定时器已启动"); 
		timer.schedule(new TimerTaskDemo(event.getServletContext()), 0, 60*60*1000);
		
		event.getServletContext().log("已经添加任务调度表");
	}

}
