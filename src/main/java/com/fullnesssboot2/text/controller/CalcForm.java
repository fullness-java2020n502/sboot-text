package com.fullnesssboot2.text.controller;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CalcForm implements Serializable {
    @Min(0)
    @Max(100)
    @NotNull
    private Integer value1;
    @Min(0)
    @Max(100)
    @NotNull
    private Integer value2;
}
