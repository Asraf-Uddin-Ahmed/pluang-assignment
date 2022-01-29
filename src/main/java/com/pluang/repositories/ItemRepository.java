package com.pluang.repositories;

import com.pluang.entities.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {
    Item findByNumber(double number);
}
