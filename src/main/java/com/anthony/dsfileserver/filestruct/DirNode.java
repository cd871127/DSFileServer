package com.anthony.dsfileserver.filestruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 2016/10/19.
 */
public class DirNode extends DataNode {
    private Map<String, DataNode> childs = new HashMap<>();

    public void addChild(DataNode child) {
        child.setParent(this);
        childs.put(child.getName(), child);
    }

    public DataNode getChild(String childName) {
        return childs.get(childName);
    }
}
