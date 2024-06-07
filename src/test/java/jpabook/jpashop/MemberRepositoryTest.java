package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest // springboot로 테스트할 때 넣기
public class MemberRepositoryTest {

    // autowired로 memberrepository injection
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // 이게 테스트케이스에 있으면 테스트가 끝난 다음에
    // 바로 롤백을 해버림. 반복적인 테스트를 위해서. 이걸 없애고싶을 때
    @Rollback(false) // 이거 하고 실행하면 들어가짐
    public void testMember() throws Exception {

        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then - 검증하는 라인, assertions는 springtest가 가지고 있는 라이브러리 assertj에 있음
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); // 같은 클래스 내에서 조회한것과 저장한 것을 비교하면 같다고 뜸
    }

}
