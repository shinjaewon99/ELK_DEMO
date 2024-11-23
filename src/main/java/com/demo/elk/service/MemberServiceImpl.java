package com.demo.elk.service;

import com.demo.elk.domain.MemberDocument;
import com.demo.elk.repository.elastic.ElasticSearchMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl {
    private final ElasticSearchMemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(final ElasticSearchMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(final MemberDocument member) {
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Optional<MemberDocument> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
