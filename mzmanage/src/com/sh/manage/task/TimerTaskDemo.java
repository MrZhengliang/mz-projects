/**
 * 
 */
package com.sh.manage.task;

import java.util.Calendar;
import java.util.TimerTask;

import javax.servlet.ServletContext;

/**
 * java定时器示例
 * 
 * @author fuzl
 * 
 */
public class TimerTaskDemo extends TimerTask{
	private static final int C_SCHEDULE_HOUR = 0;
	private static boolean isRunning = false;
	private ServletContext context = null;

	public TimerTaskDemo(ServletContext context) {
		this.context = context;
	}

	public void run() {
		Calendar cal = Calendar.getInstance();
		if (!isRunning) {
			if (C_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY)) {
				isRunning = true;
				context.log("开始执行指定任务");

				// TODO 添加自定义的详细任务，以下只是示例
				int i = 0;
				while (i++ < 10) {
					context.log("已完成任务的" + i + "/" + 10);
				}
				isRunning = false;
				context.log("指定任务执行结束");
			}
		} else {
			context.log("上一次任务执行还未结束");
		}
	}
}
