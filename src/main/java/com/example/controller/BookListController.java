package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class BookListController implements Controller{ //POJO

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp){
        BookDAOMyBatis dao = new BookDAOMyBatis();
        List<BookDTO> list = dao.bookList();
        //binding
        req.setAttribute("list", list);
        //        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        //        rd.forward(req,resp);

        return "list";

    }
}

