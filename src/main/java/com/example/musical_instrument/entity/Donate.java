package com.example.musical_instrument.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="donate_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Donate {
    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer donate_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_id", referencedColumnName = "instrument_id",
            foreignKey = @ForeignKey(name="pk_id_fk_instrument_id")) // Updated referencedColumnName to match the primary key field name.
    private Instrument instrument;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "pk_id_fk_user_id"))
    private User user;
}

