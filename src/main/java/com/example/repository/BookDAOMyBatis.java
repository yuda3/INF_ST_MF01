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

    public void bookDelete(int id) {
        try (SqlSession session = MyBatisUtil.openSession()){
            session.delete("bookDelete", id);
            session.commit();
        }
    }
    public int bookInsert(BookDTO bookDTO) {
        try(SqlSession session = MyBatisUtil.openSession()){
            int cnt = session.insert("bookInsert", bookDTO);
            session.commit();
            return cnt;
        }
    }

    public BookDTO bookView(int num) {
        try(SqlSession session = MyBatisUtil.openSession()){
            return session.selectOne("bookView", num);
        }

    }

    public int bookUpdate(BookDTO dto) {
        try(SqlSession session = MyBatisUtil.openSession()){
            int cnt = session.insert("bookUpdate", dto);
            session.commit();
            return cnt;
        }
    }
}
