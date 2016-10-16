package com.anthony;

import com.anthony.common.DSFileManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/config/core/applicationContext.xml");
        DSFileManager dsf = ctx.getBean(DSFileManager.class);
        dsf.start("G:\\TestDir");
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("sssss");
    }


}
