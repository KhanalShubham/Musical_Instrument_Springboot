package com.example.musical_instrument.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instrument_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {

    @Id
    @SequenceGenerator(name = "instrument_seq_gen", sequenceName = "instrument_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "instrument_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer instrument_id;

    @Column(name ="Instrument_name", nullable = false)
    private String instrument_name;

    @Column(name = "Instrument_price", nullable = false)
    private String instrument_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "categoy_id",
            foreignKey = @ForeignKey(name = "pk_id_fk_category_id"))
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "pk_id_fk_user_id"))
    private User user;
}
