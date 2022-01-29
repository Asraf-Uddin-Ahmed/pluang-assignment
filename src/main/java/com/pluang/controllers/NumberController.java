package com.pluang.controllers;

import com.pluang.data.ItemData;
import com.pluang.dtos.mapper.NumberSearchMapper;
import com.pluang.dtos.response.NumberSearchResponse;
import com.pluang.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
class NumberController {

    private final NumberService numberServiceAvl;
    private final NumberService numberServiceDb;
    private final NumberSearchMapper numberSearchMapper;

    @Autowired
    public NumberController(NumberService numberServiceAvl, NumberService numberServiceDb, NumberSearchMapper numberSearchMapper) {
        this.numberServiceAvl = numberServiceAvl;
        this.numberServiceDb = numberServiceDb;
        this.numberSearchMapper = numberSearchMapper;
    }

    private NumberSearchResponse getOrAddNumber(double item, NumberService numberService) {
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

    @GetMapping("/{item}")
    public NumberSearchResponse getOrAddNumber(@PathVariable double item) {
        return this.getOrAddNumber(item, numberServiceAvl);
    }

    @GetMapping("/{item}/persist")
    public NumberSearchResponse getOrAddPersistedNumber(@PathVariable double item) {
        return this.getOrAddNumber(item, numberServiceDb);
    }

}