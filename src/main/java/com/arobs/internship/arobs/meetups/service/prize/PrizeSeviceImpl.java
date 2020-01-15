package com.arobs.internship.arobs.meetups.service.prize;

import com.arobs.internship.arobs.meetups.entity.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PrizeSeviceImpl implements PrizeService {

    @Autowired
    PrizeObject prizeObject;

    @Override
    @Transactional
    public void addPrize(String description, String value) {
        prizeObject.addPrize(description,value);
    }
}
