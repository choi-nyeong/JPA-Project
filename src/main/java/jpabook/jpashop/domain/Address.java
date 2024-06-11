package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable // 어딘가에 임베드되어 쓰일 수 있다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
