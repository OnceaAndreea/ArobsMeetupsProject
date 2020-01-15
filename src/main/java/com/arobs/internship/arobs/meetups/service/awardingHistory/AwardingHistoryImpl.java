package com.arobs.internship.arobs.meetups.service.awardingHistory;

import com.arobs.internship.arobs.meetups.entity.AwardingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AwardingHistoryImpl implements AwardingHistoryService{

    @Autowired
    AwardingHistoryObject awardingHistoryObject;

    @Override
    @Transactional
    public void awardUserFromTopOfLeaderboard(int prizeId) {
        awardingHistoryObject.awardUserFromTopOfLeaderBoard(prizeId);
    }
}
