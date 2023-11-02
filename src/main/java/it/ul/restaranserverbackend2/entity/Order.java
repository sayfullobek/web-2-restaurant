package it.ul.restaranserverbackend2.entity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Order {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @Column(nullable = false)
    private String Adres;
    private boolean isActive;
    @ManyToOne
    private User user;

}

