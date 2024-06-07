package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.RequestDispatcher;
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
        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String author = req.getParameter("author");
        int page = Integer.parseInt(req.getParameter("page"));
        BookDTO dto = new BookDTO(null,title,price,author,page);

        BookDAOMyBatis dao = new BookDAOMyBatis();
        int cnt = dao.bookInsert(dto);
        if(cnt>0){
            resp.sendRedirect("/MF01/list");
        }else{
            System.out.println("Fails");
        }

    }
}

