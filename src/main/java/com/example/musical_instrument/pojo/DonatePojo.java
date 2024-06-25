package com.example.musical_instrument.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonatePojo {

    private Integer donate_id;
    private Integer instrument_id;
    private Integer user_id;
}
