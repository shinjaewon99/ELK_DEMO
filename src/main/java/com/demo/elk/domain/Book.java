package com.demo.elk.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity

@AllArgsConstructor(access = AccessLevel.PRIVATE)

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bk_nm")
    private String bookName;

    @Column(name = "aut_nm")
    private String authorName;

    @Column(name = "pblshr")
    private String pblshr;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(final String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    public String getPblshr() {
        return pblshr;
    }

    public void setPblshr(final String pblshr) {
        this.pblshr = pblshr;
    }

    @Builder
    public Book(final String bookName, final String authorName, final String pblshr) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pblshr = pblshr;
    }
}
