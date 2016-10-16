package com.anthony;

import com.anthony.common.DSFileManager;
import com.anthony.files.BuildFilesHashMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class App {

//    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");
        DSFileManager dsf = ctx.getBean(DSFileManager.class);
        dsf.start("G:\\TestDir");


//        logger.info("ssssss");
//        logger.error("1123123123");
        ArrayList<String> a = new ArrayList<>();
        a.add("G:\\");
        a.add("C:\\");
        a.add("D:\\");
        a.add("E:\\");
        a.add("F:\\");

        BuildFilesHashMap b = ctx.getBean(BuildFilesHashMap.class);

        long start = System.currentTimeMillis();
        Map m = b.TraversalDir("G:\\DEV");
        long end = System.currentTimeMillis();
        long ss = 0;
        for (Object o : m.keySet()
                ) {
            String sss = (String) o;

            ss = ss + ((List) m.get(sss)).size();
        }
        System.out.println(ss);
        System.out.println((end - start) / 1000);

    }


}
