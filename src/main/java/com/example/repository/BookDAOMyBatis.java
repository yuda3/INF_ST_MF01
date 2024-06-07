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

    public int bookDelete(int id) {
        try (SqlSession session = MyBatisUtil.openSession()){
            int cnt = session.delete("bookDelete", id);
            session.commit();
            return cnt;
        }
    }
    public int bookInsert(BookDTO bookDTO) {
        try(SqlSession session = MyBatisUtil.openSession()){
            int cnt = session.insert("bookInsert", bookDTO);
            session.commit();
            return cnt;
        }
    }
}
