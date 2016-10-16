package com.anthony.common;

import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Anthony on 2016/10/16.
 */
@Component
public class DSFileManager {
    public void start(String path) {
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
    }
}
