package com.example.musical_instrument.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category_table")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(name = "category_seq_gen", sequenceName = "category_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "category_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer categoy_id; // Typo in field name. Should be `category_id`.

    private String category_name;
}
