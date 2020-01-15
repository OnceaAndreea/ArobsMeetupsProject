package com.arobs.internship.arobs.meetups.service.prize;


import com.arobs.internship.arobs.meetups.entity.Prize;
import com.arobs.internship.arobs.meetups.repository.prize.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrizeObject {

    @Autowired
    PrizeRepository prizeRepository;

    public void addPrize(String description, String value){
        Prize prize=new Prize(description,value);
        prizeRepository.addPrize(prize);
    }
}
