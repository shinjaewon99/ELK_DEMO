package com.demo.elk.repository.jpa;

import com.demo.elk.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

    List<Book> findByBookNameContaining(String keyword);
}
