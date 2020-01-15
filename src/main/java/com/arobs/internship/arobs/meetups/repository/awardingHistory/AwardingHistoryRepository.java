package com.arobs.internship.arobs.meetups.repository.awardingHistory;

import com.arobs.internship.arobs.meetups.entity.AwardingHistory;
import org.springframework.stereotype.Repository;


public interface AwardingHistoryRepository {

    public void addAwardingHistory(AwardingHistory awardingHistory);
}
