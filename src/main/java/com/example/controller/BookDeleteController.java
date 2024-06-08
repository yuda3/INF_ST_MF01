package com.example.controller;

import com.example.repository.BookDAOMyBatis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookDeleteController implements Controller{

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp){
        int num = Integer.parseInt(req.getParameter("num"));
        BookDAOMyBatis  dao = new BookDAOMyBatis();
        dao.bookDelete(num);
        return "redirect:/list.do";
    }

}

