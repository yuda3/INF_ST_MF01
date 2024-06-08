package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//http://localhost:8081/MF01/registerPost
@WebServlet("/updatePost")
public class BookUpdatePostController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try {
            req.setCharacterEncoding("utf-8");
            String reqNum = req.getParameter("num");
            String title = req.getParameter("title");
            String reqPrice = req.getParameter("price");
            String author = req.getParameter("author");
            String reqPage = req.getParameter("page");
            if(title == null || title.trim().isEmpty()|| author==null||author.trim().isEmpty()) {
                System.out.println("check your Input");
                resp.sendRedirect("/MF01/error?msg=1");
                return;

            }
            int price;
            int page;
            Long num = null;
            try {
                price = Integer.parseInt(reqPrice);
                page = Integer.parseInt(reqPage);
                num = Long.parseLong(reqNum);
            }catch(NumberFormatException e){
                    System.out.println("Check your parameters");
                    resp.sendRedirect("/MF01/error?msg=2");
                    return;
            }
            if(price <= 0 || page <= 0) {
                System.out.println("Check your parameters");
                resp.sendRedirect("/MF01/error?msg=3");
                return;
            }

            BookDTO dto = new BookDTO(num,title,price,author,page);
            BookDAOMyBatis dao = new BookDAOMyBatis();
            int cnt = dao.bookUpdate(dto);
            if(cnt>0){
                resp.sendRedirect("/MF01/view?num="+num);
            }else{
                System.out.println("Update fail");
            }

        }catch(Exception e){
            e.printStackTrace();
            resp.sendRedirect("/MF01/error?msg=0");
        }

    }
}

