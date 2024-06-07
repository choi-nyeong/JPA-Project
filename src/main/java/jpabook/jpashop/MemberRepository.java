package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//repostitory가 뭐냐, DAO라고 생각하면 됨
@Repository // spring이 제공하는 기본타입, 컴포넌트 스캔의 대상이 돼서 자동으로 스프링 빈에 등록이 됨
public class MemberRepository {

    // Entity manager가 있어야함. 얘를 이용한 모든 데이터 변경은 항상 트랜잭션 안에서 이뤄져야함.안그럼 오류
    // 스프링부트를 쓰면 모든게 스프링 컨테이너 위에서 동작 함.
    // 스프링부트에서 이 어노테이션쓰면 자동으로 엔터티매니저 생성코드 작성된겨
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 여기서 멤버 전체를 return할 수도 있지만 설계자 맘임. 이 사람은 id만 전달함

    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
