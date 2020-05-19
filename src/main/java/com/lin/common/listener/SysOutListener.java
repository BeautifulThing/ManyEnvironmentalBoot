package com.lin.common.listener;

import lombok.extern.slf4j.Slf4j;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4JServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class SysOutListener extends SysOutOverSLF4JServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("Listener: contextDestroyed");
    }
}
