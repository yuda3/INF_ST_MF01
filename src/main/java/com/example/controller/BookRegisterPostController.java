package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAOMyBatis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookRegisterPostController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setCharacterEncoding("utf-8");
            String title = req.getParameter("title");
            String reqPrice = req.getParameter("price");
            String author = req.getParameter("author");
            String reqPage = req.getParameter("page");
            if(title == null || title.trim().isEmpty()|| author==null||author.trim().isEmpty()) {
                System.out.println("check your Input");
                //resp.sendRedirect("/MF01/error?msg=1");
                return "redirect:/error?msg=1";

            }
            int price;
            int page;
            try {
                price = Integer.parseInt(reqPrice);
                page = Integer.parseInt(reqPage);
            }catch(NumberFormatException e){
                System.out.println("Check your parameters");
                //resp.sendRedirect("/MF01/error?msg=2");
                return "redirect:/error?msg=2";
            }
            if(price <= 0 || page <= 0) {
                System.out.println("Check your parameters");
                //resp.sendRedirect("/MF01/error?msg=3");
                return "redirect:/error?msg=3";
            }

            BookDTO dto = new BookDTO(null,title,price,author,page);
            BookDAOMyBatis dao = new BookDAOMyBatis();
            int cnt = dao.bookInsert(dto);
            if(cnt>0){
                //resp.sendRedirect("/MF01/list");
                return "redirect:/list.do";
            }else{
                System.out.println("Register fail");
            }

        }catch(Exception e){
            e.printStackTrace();
            //resp.sendRedirect("/MF01/error");
            return "redirect:/error?msg=0";
        }
    return null;
    }
}

