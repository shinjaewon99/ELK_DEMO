package com.demo.elk.controller;

import com.demo.elk.domain.Book;
import com.demo.elk.service.BookEsService;
import com.demo.elk.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EsController {
    private final BookService bookService;
    private final BookEsService bookEsService;

    @GetMapping("/jpa/api")
    public List<Book> search(@RequestBody SearchRequest searchRequest) {
        return bookService.searchByJpaKeyWord(searchRequest.getKeyword());
    }

    @GetMapping("/es/api")
    public List<Book> searchEs(@RequestBody SearchRequest searchRequest) {
        return bookEsService.searchByEsKeyWord(searchRequest.getKeyword());
    }

    // DTO 클래스
    public static class SearchRequest {
        private String keyword;

        // getter, setter
        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
    }
}
