package jpaBook.Jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "mameber_id")
    private Long id;

    private String name;

    private Address address;

    @OneToMany(mappedBy = "member") // 매핑된 거울일 뿐
    private List<Order> orders = new ArrayList<>();
}
