package it.ul.restaranserverbackend2.entity;

import it.ul.restaranserverbackend2.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class District extends AbsNameEntity {
    @ManyToOne
    private Region region;
}
