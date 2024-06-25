package com.example.musical_instrument.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)

    @Column(name="user_id")
    private Integer user_id;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "user_email", nullable = false)
    private String user_email;

    @Column(name ="user_password", nullable = false)
    private String user_password;

    @Column(name ="user_contact", nullable = false)
    private String user_contact;

    @Column(name = "user_role", nullable = false)
    private String user_role;
}
