package com.anthony.dsfileserver.control;

import com.anthony.dsfileserver.config.DSFileConfig;
import com.anthony.dsfileserver.initializer.FileSystemScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Anthony on 2016/10/18.
 */
@Component
public class DSFileController {
    @Autowired
    private DSFileConfig config;

    @Autowired
    private FileSystemScanner fileSystemScanner;

    public int getThreadCount() {
        return threadCount;
    }

    private int threadCount = 1;

    public boolean isCentralServer() {
        return centralServer;
    }

    private boolean centralServer = false;

    public void init() {
        if (null != config.getConfigMap().get("threadCount"))
            threadCount = Integer.valueOf(config.getConfigMap().get("threadCount"));
        if (null != config.getConfigMap().get("centralServer")) {
            centralServer = true ? false : "1".equals(config.getConfigMap().get("centralServer"));
        }
    }

    public DSFileController() {

    }

    public void getStart(String[] paths) {
        init();

        FileSystemScanner.setPath(paths);
        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i != threadCount; ++i) {
            Thread t = new Thread(fileSystemScanner);
            threadList.add(t);
            t.start();
        }
        for (int i = 0; i != threadCount; ++i) {
            try {
                threadList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("build done");
        while (true) {

        }
    }
}
