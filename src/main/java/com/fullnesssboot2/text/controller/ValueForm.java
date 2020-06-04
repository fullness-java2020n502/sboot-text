package com.fullnesssboot2.text.controller;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class ValueForm implements Serializable {
    @Max(10)
    private Integer intValue;
    @NotBlank
    private String stringValue;
    @Future
    private Date dateValue;
}
