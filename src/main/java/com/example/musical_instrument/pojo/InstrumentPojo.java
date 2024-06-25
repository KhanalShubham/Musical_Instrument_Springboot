package com.example.musical_instrument.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InstrumentPojo {
    private Integer instrument_id;
    private String instrument_name;
    private String instrument_price;
    private Integer category_id;
    private Integer user_id;



}
