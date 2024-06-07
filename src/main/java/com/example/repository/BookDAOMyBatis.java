package com.example.repository;

import com.example.entity.BookDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BookDAOMyBatis {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<BookDTO> bookList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<BookDTO> list = sqlSession.selectList("bookList");
        sqlSession.close();
        return list;

    }
}
