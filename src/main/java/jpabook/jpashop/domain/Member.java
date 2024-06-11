package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 임베디드 내장 타입을 포함했다라는 어노테이션으로 맵핑
    // 임베더블이랑 임베디드 둘 중 하나만 있어도 되긴 함 근데 둘 다 함
    private Address address;

    @OneToMany
    private List<Order> orders = new ArrayList<>();

}
