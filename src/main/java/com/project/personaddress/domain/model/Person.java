package com.project.personaddress.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person extends AbstractModel {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDateTime birth;

    @OneToMany(mappedBy = "person")
    private List<Address> adress;
}
