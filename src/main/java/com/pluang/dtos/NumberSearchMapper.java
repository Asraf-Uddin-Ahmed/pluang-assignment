package com.pluang.dtos;

import com.pluang.datastructure.ItemData;
import org.springframework.stereotype.Component;

@Component
public class NumberSearchMapper {

    public NumberSearchResponse getNullNumberSearchResponse() {
        return NumberSearchResponse.builder()
                .result("false")
                .build();
    }

    public NumberSearchResponse getNumberSearchResponse(ItemData itemData) {
        return NumberSearchResponse.builder()
                .result("true")
                .firstInsertDateTime(itemData.getInsertionTime())
                .lastSearchDateTime(itemData.getLastSearchTime())
                .searchCount(itemData.getSearchCount())
                .build();
    }

}
