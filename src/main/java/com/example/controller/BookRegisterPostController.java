package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//http://localhost:8081/MF01/registerPost
@WebServlet("/registerPost")
public class BookRegisterPostController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            req.setCharacterEncoding("utf-8");
            String title = req.getParameter("title");
            String reqPrice = req.getParameter("price");
            String author = req.getParameter("author");
            String reqPage = req.getParameter("page");
            if(title == null || title.trim().isEmpty()|| author==null||author.trim().isEmpty()) {
                System.out.println("check your Input");
                resp.sendRedirect("/MF01/error");
                return;

            }
            int price = 0;
            int page = 0;
            try {
                price = Integer.parseInt(reqPrice);
                page = Integer.parseInt(reqPage);
            }catch(NumberFormatException e){
                    System.out.println("Check your parameters");
                    resp.sendRedirect("/MF01/error");
                    return;
            }
            if(price <= 0 || page <= 0) {
                System.out.println("Check your parameters");
                resp.sendRedirect("/MF01/error");
                return;
            }

            BookDTO dto = new BookDTO(null,title,price,author,page);
            BookDAOMyBatis dao = new BookDAOMyBatis();
            int cnt = dao.bookInsert(dto);
            if(cnt>0){
                resp.sendRedirect("/MF01/list");
            }else{
                System.out.println("Register fail");
            }

        }catch(Exception e){
            e.printStackTrace();
            resp.sendRedirect("/MF01/error");
        }

    }
}

