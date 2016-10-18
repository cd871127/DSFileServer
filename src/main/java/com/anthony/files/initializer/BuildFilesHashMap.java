package com.anthony.files.initializer;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Anthony on 2016/10/16.
 */

@Component
public class BuildFilesHashMap extends ScanFileSystem {

    @Override
    protected Map<String, HashSet<String>> TraversalDir() {
        File file;
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

    private synchronized void addFileToMap(File file) {
        String fileName = file.getName();
        HashSet<String> fileSet = fileMap.get(fileName);

        if (null == fileSet) {
            fileSet = new HashSet<>();
            fileMap.put(fileName, fileSet);
        }
        fileSet.add(file.getAbsolutePath());
    }

    @Override
    public void run() {
        fileMap = TraversalDir();
    }

}
