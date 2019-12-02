package com.project.personaddress.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends AbstractModel {

    @NotBlank
    private String city;

    @NotBlank
    private String distrcit;

    @NotBlank
    private String street;

    @NotNull
    private Integer number;

    @NotBlank
    private String complemnt;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
