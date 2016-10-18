package com.anthony.files.initializer;

import java.io.File;
import java.util.*;

/**
 * Created by Anthony on 2016/10/16.
 */
public abstract class ScanFileSystem implements Runnable {

    protected static List<File> queue = Collections.synchronizedList(new LinkedList());
    protected static Map<String, HashSet<String>> fileMap = new HashMap<>();

    public Map<String, HashSet<String>> getFileMap() {
        return fileMap;
    }

    protected abstract Map<String, HashSet<String>> TraversalDir();

    final static public void setPath(String[] paths) {
        for (int i = 0; i != paths.length; ++i)
            queue.add(0, new File(paths[i]));
    }

}
