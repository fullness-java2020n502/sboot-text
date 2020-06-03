package com.fullnesssboot2.text.controller;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ValueForm implements Serializable {
    private Integer intValue;
    private String stringValue;
    private Date dateValue;
}
