package com.example.frontcontroller;

import com.example.controller.BookDeleteController;
import com.example.controller.BookListController;

import javax.servlet.RequestDispatcher;
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

        switch (command) {
            case "/list.do" -> {
                BookListController controller = new BookListController();
                String nextView = controller.requestHandler(req, resp);
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
                rd.forward(req, resp);
            }
            case "/delete.do" -> {
                BookDeleteController controller = new BookDeleteController();
                String nextView = controller.requestHandler(req, resp);
                resp.sendRedirect("/MF01/" + nextView.split(":/")[1]);
            }
            case "/update.do" -> {
            }
        }
    }
}
