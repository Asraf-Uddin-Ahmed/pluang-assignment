package com.pluang.controllers;

import com.pluang.datastructure.ItemData;
import com.pluang.dtos.NumberSearchMapper;
import com.pluang.dtos.NumberSearchResponse;
import com.pluang.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
class NumberController {

    private final NumberService numberService;
    private final NumberSearchMapper numberSearchMapper;

    @Autowired
    public NumberController(NumberService numberService, NumberSearchMapper numberSearchMapper) {
        this.numberService = numberService;
        this.numberSearchMapper = numberSearchMapper;
    }

    @GetMapping("/{item}")
    public NumberSearchResponse getOrAddNumber(@PathVariable double item) {
        ItemData itemData = numberService.getItem(item);
        if (itemData == null) {
            numberService.insert(item);
            return numberSearchMapper.getNullNumberSearchResponse();
        }
        numberService.increaseSearchCount(itemData);
        NumberSearchResponse response = numberSearchMapper.getNumberSearchResponse(itemData);
        numberService.updateLastSearchTime(itemData);
        return response;
    }

}