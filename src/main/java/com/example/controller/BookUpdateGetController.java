package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/updateGet")
public class BookUpdateGetController extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        BookDAOMyBatis dao = new BookDAOMyBatis();
        BookDTO book = dao.bookView(num);

        req.setAttribute("book", book);
        req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, res);

    }
}
