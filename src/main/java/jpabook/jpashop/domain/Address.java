package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable // 내장 타입 = 어디든 내장 o
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { // 함부로 생성 x
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
