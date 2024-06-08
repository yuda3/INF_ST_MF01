package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookRegisterGetController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp){
        return "register";
    }
}

