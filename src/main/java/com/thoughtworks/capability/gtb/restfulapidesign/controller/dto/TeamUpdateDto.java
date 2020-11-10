package com.thoughtworks.capability.gtb.restfulapidesign.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamUpdateDto {
    private int id;
    private String name;
}
