package com.demo.elk.repository.jdbc;

import com.demo.elk.domain.Book;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);


    @Transactional
    public void saveAll(List<Book> bookEntities) {
        String sql = "INSERT INTO book (bk_nm, aut_nm, pblshr) VALUES (?, ?, ?)";

        jdbcTemplate.batchUpdate(sql,
                bookEntities,
                100,
                (PreparedStatement ps, Book book) -> {
                    ps.setString(1, book.getBookName());
                    ps.setString(2, book.getAuthorName());
                    ps.setString(3, book.getPblshr());
                });
        logger.info("Successfully saved {} books", bookEntities.size());
    }
}
