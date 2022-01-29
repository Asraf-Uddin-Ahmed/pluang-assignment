package com.pluang.dtos.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
public class NumberSearchResponse {
    private String result;
    private Long firstInsertDateTime;
    private Long lastSearchDateTime;
    private int searchCount;
}
