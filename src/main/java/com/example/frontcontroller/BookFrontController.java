package com.example.frontcontroller;

import com.example.controller.BookDeleteController;
import com.example.controller.BookListController;
import com.example.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class BookFrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();
        String cPath = req.getContextPath();
        String command = reqPath.substring(cPath.length());
        Controller controller;
        String nextView = null;
        switch (command) {
            case "/list.do" -> {
                controller = new BookListController();
                nextView = controller.requestHandler(req, resp);
            }
            case "/delete.do" -> {
                controller = new BookDeleteController();
                nextView = controller.requestHandler(req, resp);
            }
            case "/update.do" -> {

            }
        }
        //NextViewによってforward, redirectに分岐
        navigate(req, resp, nextView);
    }

    private void navigate(HttpServletRequest req, HttpServletResponse resp,String nextView) throws ServletException, IOException {
        if(nextView != null){
            if(!nextView.contains(":/")){
                //forward
                req.getRequestDispatcher(ViewResolver.makeView(nextView)).forward(req,resp);
            }else{
                //redirect
                resp.sendRedirect(nextView.split(":/")[1]);
            }
        }
    }
}
