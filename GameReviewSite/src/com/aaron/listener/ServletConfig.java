package com.aaron.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.aaron.service.AbstractService;

/**
 * @author aaron
 * 
 *         Application Lifecycle Listener implementation class ServletConfig
 */
@WebListener
public class ServletConfig implements ServletContextListener {
	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		AbstractService.close();
	}
}
