package com.thoughtworks.capability.gtb.restfulapidesign.expection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

    private String message;
}

