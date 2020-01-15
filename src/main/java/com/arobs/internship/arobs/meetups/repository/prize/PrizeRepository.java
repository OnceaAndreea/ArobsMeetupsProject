package com.arobs.internship.arobs.meetups.repository.prize;

import com.arobs.internship.arobs.meetups.entity.Prize;

public interface PrizeRepository {

    public void addPrize(Prize prize);

    public Prize getPrizeById(int prizeId);
}
