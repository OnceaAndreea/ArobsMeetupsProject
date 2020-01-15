package com.arobs.internship.arobs.meetups.service.prize;

import com.arobs.internship.arobs.meetups.entity.Prize;
import org.springframework.stereotype.Service;

@Service
public interface PrizeService {

    public void addPrize(String description, String value);


}
