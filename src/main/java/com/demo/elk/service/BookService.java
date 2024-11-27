package com.demo.elk.service;

import com.demo.elk.domain.Book;
import com.demo.elk.repository.jpa.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookJpaRepository bookRepository;

    @Transactional(readOnly = true)
    public List<Book> searchByJpaKeyWord(final String keyword) {
        return bookRepository.findByBookNameContaining(keyword);
    }

    @Transactional
    public Optional<Book> findById(final Long id) {
        return bookRepository.findById(id);
    }
}
