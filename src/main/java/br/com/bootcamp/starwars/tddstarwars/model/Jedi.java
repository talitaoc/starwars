package br.com.bootcamp.starwars.tddstarwars.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table
public class Jedi {

    private int id;
    private String name;
    private int strenght;
    private int version;

}
