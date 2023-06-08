package it.ul.restaranserverbackend2.entity;

import it.ul.restaranserverbackend2.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category extends AbsNameEntity {
}
