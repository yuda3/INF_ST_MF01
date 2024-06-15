package com.example.controller;

import com.example.entity.CustomerDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //ID PASSWORD
        String customer_id = req.getParameter("customer_id");
        String password = req.getParameter("password");

        //CustomerDTO
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomer_id(customer_id);
        dto.setPassword(password);


        return "";
    }
}
