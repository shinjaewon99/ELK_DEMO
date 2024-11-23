package com.demo.elk.controller;

import com.demo.elk.domain.Member;
import com.demo.elk.domain.MemberDocument;
import com.demo.elk.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class EsController {
    private final MemberServiceImpl memberService;

    @Autowired
    public EsController(final MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody final MemberDocument member) {
        memberService.save(member);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable final Long id) {
        return memberService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
