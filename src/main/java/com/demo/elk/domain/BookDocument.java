package com.demo.elk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "books")
public class BookDocument {
    @Id
    private String id;

    @Column(name = "bk_nm")
    private String bookName;

    @Column(name = "aut_nm")
    private String authorName;

    @Column(name = "pblshr")
    private String pblshr;


    @Builder
    public BookDocument(String id, String bookName, String authorName, String pblshr) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.pblshr = pblshr;
    }
}
