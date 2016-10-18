package com.anthony;

import com.anthony.dsfileserver.control.DSFileController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");

        DSFileController controller = ctx.getBean(DSFileController.class);
        String[] paths = new String[]{"C:\\", "D:\\", "E:\\", "F:\\", "G:\\"};

        controller.getStart(paths);

    }

}
