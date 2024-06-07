package com.example.repository;

import com.example.entity.BookDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookDAOMyBatis {

    public List<BookDTO> bookList() {
        try (SqlSession session = MyBatisUtil.openSession()){
            return session.selectList("bookList");
        }
    }
}
