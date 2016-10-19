package com.anthony.dsfileserver.filestruct;

/**
 * Created by Anthony on 2016/10/19.
 */
public class DataNode {
    protected DirNode parent = null;
    protected String name;

    public DataNode() {

    }

    public DataNode getParent() {
        return parent;
    }

    protected void setParent(DirNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
