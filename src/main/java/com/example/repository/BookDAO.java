package com.example.repository;

//JDBC -> MyBatis(MVC) -> Spring+MyBatis -> Hibernate -> Spring Data JPA
import com.example.entity.BookDTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection getConnection() {
        String driveClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/book";
        String user = "root";
        String password = "password";
        try {
            Class.forName(driveClassName);
            conn = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> list = new ArrayList<>();
        String SQL = "select * from book order by title desc";
        conn = getConnection();
        try {
            rs = conn.prepareStatement(SQL).executeQuery();
            while (rs.next()){
                int num = rs.getInt("num");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String author = rs.getString("author");
                int page = rs.getInt("page");
                BookDTO dto = new BookDTO(num,title,price,author,page);
                list.add(dto);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
