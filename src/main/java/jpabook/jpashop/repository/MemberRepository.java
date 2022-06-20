package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        //persist 영속성 context에 객체를 넣음 (Member entity)
        em.persist(member);
    }

    public Member findOne(Long id) {
        //단건 조회 할시
        return em.find(Member.class, id); // type, pk(primary key)
    }

    public List<Member> findAll(){
        //inline 합치기 option + command + n
        return em.createQuery("select m from Member m", Member.class) //jpql from의 대상이 테이블이 아닌 Entity
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name) //parameter 바인딩 해서 특정 이름만 찾아오기
                .getResultList();
    }


}
