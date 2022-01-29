package com.pluang.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
public class NumberSearchResponse {
    private String result;
    private Date firstInsertDateTime;
    private Date lastSearchDateTime;
    private int searchCount;
}
