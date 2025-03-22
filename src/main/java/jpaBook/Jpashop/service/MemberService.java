package jpaBook.Jpashop.service;

import jpaBook.Jpashop.domain.Member;
import jpaBook.Jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // jakara말고 springframework인 트랜젝션 사용

import java.util.List;

@Service
@Transactional(readOnly = true)// lazy나 등등 이런게 가능, 트랜젝션 안에서 변경해야됨.
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    // 회원 가입
    @Transactional // 따로 설정한 것에 우선순위를 갖기 때문에  false를 가짐
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
    // 회원 전체 조회
    public List<Member> getMember() {
        return memberRepository.findAll();
    }

    // 단건 조회
    public Member findById(Long id){
        return memberRepository.findOne(id);
    }
}
