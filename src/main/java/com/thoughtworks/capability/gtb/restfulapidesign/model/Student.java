package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @NotNull(message = "Need student id")
    private int id;
    @NotNull(message = "Need student name")
    private String name;
    @NotNull(message = "Need student gender")
    private Gender gender;
    @NotNull(message = "Need some note")
    private String note;
}
