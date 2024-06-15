package com.example.repository;

import com.example.entity.CustomerDTO;
import org.apache.ibatis.session.SqlSession;

public class LoginDAOMyBatis {

    public CustomerDTO login(CustomerDTO dto){
        try(SqlSession session = MyBatisUtil.openSession()){
            return session.selectOne("login", dto);
        }

    }
}
