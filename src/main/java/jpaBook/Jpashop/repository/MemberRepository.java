package jpaBook.Jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpaBook.Jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) { // 트랜잭션이 커밋이 되는 시점에 db반영
        em.persist(member);
    }
    // 단건 조회
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    // 전체 조회
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();// jpql을 직접 작성해야한다.
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
