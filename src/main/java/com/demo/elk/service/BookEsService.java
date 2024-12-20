package com.demo.elk.service;

import com.demo.elk.domain.BookDocument;
import com.demo.elk.repository.elastic.BookEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookEsService {
    private final BookEsRepository bookRepository;

    @Transactional(readOnly = true)
    public List<BookDocument> searchByEsKeyWord(final String keyword) {
        return bookRepository.findByBookNameContaining(keyword);
    }

}
