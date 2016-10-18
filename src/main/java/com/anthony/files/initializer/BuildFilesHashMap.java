package com.anthony.files.initializer;

import java.io.File;
import java.util.*;

/**
 * Created by Anthony on 2016/10/16.
 */

public class BuildFilesHashMap implements Runnable, BuildFilesData {
    public Map<String, LinkedList<String>> getFileMap() {
        return fileMap;
    }

    public static List<File> queue = Collections.synchronizedList(new LinkedList());
    private Map<String, LinkedList<String>> fileMap = new HashMap<>();

    private String path;

    public BuildFilesHashMap() {
        super();
    }

    public Map<String, LinkedList<String>> TraversalDir() {

//        queue.add(new File(path));
        File file = null;
        do {
            synchronized (queue) {
                file = queue.remove(queue.size() - 1);
            }
            addFileToMap(file);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (null != files) {
                    for (int i = 0; i != files.length; ++i) {
                        queue.add(0, files[i]);
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
            fileList = new LinkedList<>();
            fileMap.put(fileName, fileList);
        }
        fileList.add(file.getAbsolutePath());
    }

    @Override
    public void run() {
        fileMap = TraversalDir();
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
