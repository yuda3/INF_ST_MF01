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
import java.util.List;


//http://localhost:8081/MF01/delete?num=?
@WebServlet("/delete")
public class BookDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int num = Integer.parseInt(req.getParameter("num"));
        BookDAOMyBatis  dao = new BookDAOMyBatis();
        int cnt = dao.bookDelete(num);
        if(cnt > 0){
            resp.sendRedirect("/MF01/list");
        }else{
            System.out.println("SomeThing is Wrong");
        }
    }
}

