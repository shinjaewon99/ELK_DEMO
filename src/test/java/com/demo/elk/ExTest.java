package com.demo.elk;

import com.demo.elk.domain.Book;
import com.demo.elk.domain.BookDocument;
import com.demo.elk.service.BookEsService;
import com.demo.elk.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class ExTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookEsService bookEsService;

    @Test
    void testCompareJpaAndEsSearch() {
        String keyword = "안녕"; // 검색할 키워드

        // JPA 조회 시간 측정
        long jpaStartTime = System.currentTimeMillis();
        List<Book> jpaResults = bookService.searchByJpaKeyWord(keyword);
        long jpaEndTime = System.currentTimeMillis();

        System.out.println("JPA 조회 결과 크기: " + jpaResults.size());
        System.out.println("JPA 조회 시간: " + (jpaEndTime - jpaStartTime) + "ms");

        // Elasticsearch 조회 시간 측정
        long esStartTime = System.currentTimeMillis();
        List<BookDocument> esResults = bookEsService.searchByEsKeyWord(keyword);
        long esEndTime = System.currentTimeMillis();

        System.out.println("Elasticsearch 조회 결과 크기: " + esResults.size());
        System.out.println("Elasticsearch 조회 시간: " + (esEndTime - esStartTime) + "ms");
    }
}
