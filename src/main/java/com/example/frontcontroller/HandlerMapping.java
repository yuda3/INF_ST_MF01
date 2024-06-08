package com.example.frontcontroller;

import com.example.controller.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class HandlerMapping {

    private final HashMap<String, Controller> mappings;

    public HandlerMapping() {
        mappings = new HashMap<>();
        try {
            loadMappingFromExternalSource();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadMappingFromExternalSource() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("mappingConfig.properties");
        if (inputStream == null) {
            throw new RuntimeException("Unable to load mapping config file");
        }

        Properties properties = new Properties();
        properties.load(inputStream);
        for (String key : properties.stringPropertyNames()){
            String className = properties.getProperty(key);
            Class<?> clazz = Class.forName(className);
            Controller controller = (Controller) clazz.getDeclaredConstructor().newInstance();
            mappings.put(key, controller);
        }
        inputStream.close();
    }
    public Controller getController(String key) {
        return mappings.get(key);
    }
}
