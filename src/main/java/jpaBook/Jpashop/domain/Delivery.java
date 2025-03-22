package jpaBook.Jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address; // Address라는 값 객체를 자기 테이블 안에 칼럼으로 포함

    @Enumerated(EnumType.STRING) // O
    private DeliveryStatus status; // READY, COMP
}
