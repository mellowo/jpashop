package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //junit 실행 할떄 스프링이랑 엮어서 실행
@SpringBootTest  // spring boot를 띄운 상태에서 테스트 하고 싶을 떄
@Transactional   //test에서 transactional 에너테이션 붙이면 transaction을 걸고, 끝나면 롤백 Test케이스가 아닌경우에서는 롤벡 되지 않음
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        em.flush();
        Assertions.assertThat(member).isEqualTo(memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public  void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2);


        //then
        fail("예외가 발생해야한다");

    }

}