package com.demo.elk.repository.jdbc;

import com.demo.elk.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Repository

public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void saveAll(List<Book> books) {
        String sql = "INSERT INTO BOOK (bk_nm, aut_nm, pblshr) VALUES (?, ?, ?)";

        jdbcTemplate.batchUpdate(sql,
                books,
                books.size(),
                (PreparedStatement ps, Book book) -> {
                    ps.setString(1, book.getBookName());
                    ps.setString(2, book.getAuthorName());
                    ps.setString(3, book.getPblshr());
                });
    }
}
