package com.demo.elk.repository.elastic;

import com.demo.elk.domain.MemberDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElasticSearchMemberRepository extends ElasticsearchRepository<MemberDocument, Long> {

    Optional<MemberDocument> findById(Long memberId);

}
