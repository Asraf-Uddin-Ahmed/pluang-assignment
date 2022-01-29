package com.pluang.dtos;

import com.pluang.datastructure.ItemData;
import com.pluang.utils.DateUtil;
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
                .firstInsertDateTime(DateUtil.getEpochIfExists(itemData.getInsertionTime()))
                .lastSearchDateTime(DateUtil.getEpochIfExists(itemData.getLastSearchTime()))
                .searchCount(itemData.getSearchCount())
                .build();
    }

}
