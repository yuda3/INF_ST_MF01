package com.example.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

}
