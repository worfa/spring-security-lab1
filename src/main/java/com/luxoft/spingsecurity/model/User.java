package com.luxoft.spingsecurity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@SequenceGenerator(
    name = "user_seq_gen",
    sequenceName = "user_seq",
    initialValue = 3010
)
@Entity
@Data
public class User {

    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "user_seq_gen")
    @Id
    private long id;

    private String login;

    private String password;

    @ElementCollection
    private List<String> roles;

    @JoinTable(name = "user_company")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Company> companies;
}
