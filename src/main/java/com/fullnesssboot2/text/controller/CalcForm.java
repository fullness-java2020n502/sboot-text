package com.fullnesssboot2.text.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class CalcForm implements Serializable {
    private Integer value1;
    private Integer value2;
}
