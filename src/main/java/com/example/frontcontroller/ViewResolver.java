package com.example.frontcontroller;

public class ViewResolver {
    private static final String VIEWS_DIRECTORY="WEB-INF/views/";
    private static final String VIEWS_EXTENSION=".jsp";

    public static String makeView(String viewName){
        if(viewName == null || viewName.trim().isEmpty()){
            throw new IllegalArgumentException("viewName cannot be null or empty");
        }
        return VIEWS_DIRECTORY+viewName+VIEWS_EXTENSION;
    }
}
