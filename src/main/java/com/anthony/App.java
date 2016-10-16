package com.anthony;

import com.anthony.common.DSFileManager;
import com.anthony.common.config.DSFileConfig;
import com.anthony.common.config.DSFileProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/config/core/applicationContext.xml");
        DSFileManager dsf = ctx.getBean(DSFileManager.class);
        dsf.start("G:\\TestDir");
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.info("ssssss");
        System.out.println(System.getProperty("user.dir"));
        DSFileConfig d = ctx.getBean(DSFileProperties.class);
        System.out.println(d.getConfigMap().size());
    }


}
