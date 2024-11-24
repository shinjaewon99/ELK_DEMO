package com.demo.elk.controller;

import com.demo.elk.domain.MemberDocument;
import com.demo.elk.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Void> save(@RequestBody final MemberDocument member) {
        memberService.save(member);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDocument> findById(@PathVariable final Long id) {
        return memberService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
