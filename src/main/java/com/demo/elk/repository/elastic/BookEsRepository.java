package com.demo.elk.repository.elastic;

import com.demo.elk.domain.Book;
import com.demo.elk.domain.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookEsRepository extends ElasticsearchRepository<BookDocument, Long> {

    List<BookDocument> findByBookNameContaining(String keyword);
}