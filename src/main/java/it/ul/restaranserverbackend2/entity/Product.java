package it.ul.restaranserverbackend2.entity;

import it.ul.restaranserverbackend2.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product extends AbsNameEntity {
    @Column(nullable = false, name = "product_price")
    private Double price;

    @Column(nullable = false, name = "product_img")
    private UUID img;

    @ManyToOne(optional = false)
    private Category category;

    @Column(nullable = false, name = "product_description", length = 99999)
    private String description;
//    @ManyToOne(optional = false)
//    private Order order;
}
