package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;


    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 웬만하면 String이 좋다
    private DeliveryStatus status; //READY, COMP
}
