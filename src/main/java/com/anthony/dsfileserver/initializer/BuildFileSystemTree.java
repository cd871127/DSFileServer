package com.anthony.dsfileserver.initializer;

import com.anthony.dsfileserver.filestruct.DataNode;
import com.anthony.dsfileserver.filestruct.DirNode;
import com.anthony.dsfileserver.filestruct.FileNode;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by Anthony on 2016/10/19.
 */
@Component
public class BuildFileSystemTree {
    private DirNode root = null;

    public void init(String[] paths) {
        root = new DirNode();
        root.setName("\\");
        for (int i = 0; i != paths.length; ++i) {
            DataNode child;
            File file = new File(paths[i]);
            if (file.isDirectory())
                child = new DirNode();
            else
                child = new FileNode();
            child.setName(paths[i]);
            root.addChild(child);
        }
    }

//    private build()
//    {
//
//    }

    public void showTree() {
        if (null == root) {
            System.out.println("null tree");
            return;
        }
        System.out.println(root.getChild("D:\\"));


    }
}
