package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//http://localhost:8081/MF01/list
@WebServlet("/list")
public class BookListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        BookDAO dao = new BookDAO();
        List<BookDTO> list = dao.getAllBooks();
        //binding
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req,resp);

    }
}

