package com.anthony.common.config;

import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Anthony on 2016/10/16.
 */
@Component
public class DSFileProperties extends AbstractDSFileConfig {


    @Override
    protected void buildConfigMap() {
        InputStream in = null;
        Properties properties = new Properties();
        try {
            in = new BufferedInputStream(new FileInputStream("./src/main/config/config.properties"));
            if (null != in) {
                properties.load(in);
                Enumeration pNames = properties.propertyNames();
                configMap = new HashMap<>();
                while (pNames.hasMoreElements()) {
                    String key = pNames.nextElement().toString();
                    configMap.put(key, properties.getProperty(key));
                }
            } else
                configMap = null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
