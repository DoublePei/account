package com.anneng.net.model.vo;

import lombok.Data;

@Data
public class AggParams {

    private Integer page;
    private Integer size;
    private String sortProperties;
    private String sortDirection;
    private String startTime;
    private String endTime;
    private String company;
}
