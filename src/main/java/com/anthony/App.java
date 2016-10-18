package com.anthony;

import com.anthony.files.initializer.BuildFilesHashMap;

import java.io.File;


public class App {

//    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");
//        DSFileManager dsf = ctx.getBean(DSFileManager.class);
//        dsf.start("G:\\TestDir");
//        List<File> queue = Collections.synchronizedList(new LinkedList());
//        queue.add(new File("C:\\"));
//        queue.add(new File("D:\\"));
//        queue.add(new File("E:\\"));
//        queue.add(new File("F:\\"));
//        queue.add(new File("G:\\"));
//        System.out.println(queue.size()-1);
//        System.out.println(queue.remove(queue.size()-1));
        rr();

    }

    public static void rr() {
        BuildFilesHashMap.queue.add(0, new File("C:\\"));
        BuildFilesHashMap.queue.add(0, new File("D:\\"));
        BuildFilesHashMap.queue.add(0, new File("E:\\"));
        BuildFilesHashMap.queue.add(0, new File("F:\\"));
        BuildFilesHashMap.queue.add(0, new File("G:\\"));
        long start = System.currentTimeMillis();
        BuildFilesHashMap m1 = new BuildFilesHashMap();
//        BuildFilesHashMap m2=new BuildFilesHashMap();
//        BuildFilesHashMap m3=new BuildFilesHashMap();
//        BuildFilesHashMap m4=new BuildFilesHashMap();
//        BuildFilesHashMap m5=new BuildFilesHashMap();
//        int i=0;
//        ArrayList<Thread> list=new ArrayList<>();
//        while(i!=5)
//        {
//            if(BuildFilesHashMap.queue.isEmpty())
//                continue;
//
//            Thread b=new Thread(m1);
//            b.start();
//            list.add(b);
//            ++i;
//        }
        Thread b1 = new Thread(m1);
        Thread b2 = new Thread(m1);
        Thread b3 = new Thread(m1);
        Thread b4 = new Thread(m1);
        Thread b5 = new Thread(m1);
//        Thread b6=new Thread(m1);
//        Thread b7=new Thread(m1);
//        Thread b8=new Thread(m1);
        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();
//        b6.start();
//        b7.start();
//        b8.start();
        try {
//            for(int j=0;j!=list.size();++j)
//                list.get(j).join();
            b1.join();
            b2.join();
            b3.join();
            b4.join();
            b5.join();
//            b6.join();
//            b7.join();
//            b8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((double) (end - start) / 1000 + "s");
        System.out.println(m1.getFileMap().size());
//        System.out.println(m2.getFileMap().size());
//        System.out.println(m3.getFileMap().size());
//        System.out.println(m4.getFileMap().size());
//        System.out.println(m5.getFileMap().size());

    }


}
