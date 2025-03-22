package jpaBook.Jpashop.service;

import jakarta.persistence.EntityManager;
import jpaBook.Jpashop.domain.Member;
import jpaBook.Jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) // junit4에서만 사용, junit5버전에서 사용안해도 가능
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Kim");
        // when
        Long saveId = memberService.join(member);
        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() {
        //given

        // when

        //then
    }

}