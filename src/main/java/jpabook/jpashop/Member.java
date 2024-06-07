package jpabook.jpashop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {

    @Id // 식별자를 id로 맵핑해주고
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성되게끔
    private Long id;
    private String username;

}
