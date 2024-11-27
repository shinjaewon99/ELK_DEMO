package com.demo.elk.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
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

    @Builder
    public Book(final String bookName, final String authorName, final String pblshr) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pblshr = pblshr;
    }
}
