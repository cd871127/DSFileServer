package com.anthony.dsfileserver.filestruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 2016/10/19.
 */
public class FileNode {
    private Map<String, FileNode> childs = new HashMap<>();
    private FileNode parent = null;
    private String name;

}
