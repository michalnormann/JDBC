package com.sda.db;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cat {
    private int id;
    private String name;
    private int birthYear;
    private String colour;
}
