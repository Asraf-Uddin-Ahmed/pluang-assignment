package com.pluang.dtos;

import com.pluang.datastructure.Node;
import org.springframework.stereotype.Component;

@Component
public class NumberSearchMapper {

    public NumberSearchResponse getNullNumberSearchResponse() {
        return NumberSearchResponse.builder()
                .result("false")
                .build();
    }

    public NumberSearchResponse getNumberSearchResponse(Node node) {
        return NumberSearchResponse.builder()
                .result("true")
                .firstInsertDateTime(node.getInsertionTime())
                .lastSearchDateTime(node.getLastSearchTime())
                .searchCount(node.getSearchCount())
                .build();
    }

}
