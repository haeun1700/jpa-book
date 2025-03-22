package jpaBook.Jpashop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 관계형 DB는 상속이 없어 전략을 사용한다. (-> 싱글테이블 전략 사용)
@DiscriminatorColumn(name="dtype")
@Getter
@Setter
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
