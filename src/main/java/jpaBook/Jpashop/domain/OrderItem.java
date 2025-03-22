package jpaBook.Jpashop.domain;

import jakarta.persistence.*;
import jpaBook.Jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count;
}
