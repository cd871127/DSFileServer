package com.anthony.common.config;

import java.util.Map;

/**
 * Created by Anthony on 2016/10/16.
 */

public abstract class AbstractDSFileConfig implements DSFileConfig {
    protected Map<String, String> configMap = null;

    public AbstractDSFileConfig() {
        buildConfigMap();
    }

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    protected abstract void buildConfigMap();
}
