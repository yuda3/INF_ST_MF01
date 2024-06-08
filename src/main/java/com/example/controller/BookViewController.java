package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookViewController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp){
        int num = Integer.parseInt(req.getParameter("num"));
        BookDAOMyBatis dao = new BookDAOMyBatis();
        BookDTO book = dao.bookView(num);
        req.setAttribute("book", book);
        //req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
        return "view";
    }
}
