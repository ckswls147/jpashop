package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // test가 끝나면 rol lback
    @Rollback(false)
    public void testMember() throws Exception {

        //given
        Member member = new Member();
        member.setUsername("memberA");
        //when
        Long saveId = memberRepository.save(member);

        //then
        Member findmember = memberRepository.find(saveId);
        assertThat(findmember.getId()).isEqualTo(member.getId());
        assertThat(findmember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findmember).isEqualTo(member);
    }
}