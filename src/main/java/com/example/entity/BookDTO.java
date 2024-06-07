package com.example.entity;
//Lombok API

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long num;
    private String title;
    private int price;
    private String author;
    private int page;
}
