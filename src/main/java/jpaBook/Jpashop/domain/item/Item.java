package jpaBook.Jpashop.domain.item;

import jakarta.persistence.*;
import jpaBook.Jpashop.domain.Category;
import jpaBook.Jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==//
    /**
    * stock 재고 증가
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     * stock 재고 감소
     */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0){
            throw new NotEnoughStockException("재고가 부족해요");
        }
        this.stockQuantity = restStock;

    }
}
