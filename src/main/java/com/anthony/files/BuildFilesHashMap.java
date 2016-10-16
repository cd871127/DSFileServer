package com.anthony.files;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Anthony on 2016/10/16.
 */
@Component
public class BuildFilesHashMap implements BuildFilesData {
    public Map<String, LinkedList<String>> getFileMap() {
        return fileMap;
    }

    private Map<String, LinkedList<String>> fileMap = new HashMap<>();

    public Map<String, LinkedList<String>> TraversalDir(String path) {
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(path));
        do {
            File file = queue.remove();
            addFileToMap(file);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (null != files) {
                    for (int i = 0; i != files.length; ++i) {
                        queue.add(files[i]);
                    }
                }
            }
        } while (!queue.isEmpty());
        return fileMap;
    }

    private void addFileToMap(File file) {
        String fileName = file.getName();
        LinkedList<String> fileList = fileMap.get(fileName);
        if (null == fileList) {
            fileList = new LinkedList<String>();
            fileMap.put(fileName, fileList);
        }
        fileList.add(file.getAbsolutePath());
    }


//    private void TraversalDir(String path)
//    {
//        File file=new File(path);
//        addFiletoMap(file);
//        File[] files;
//        if(file.isDirectory())
//        {
//            files=file.listFiles();
//            if(files!=null) {
//                for (File f : files) {
//                    TraversalDir(f.getAbsoluteFile().toString());
//                }
//            }
//        }
//
//    }


}
