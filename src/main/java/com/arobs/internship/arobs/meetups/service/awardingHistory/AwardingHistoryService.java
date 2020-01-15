package com.arobs.internship.arobs.meetups.service.awardingHistory;

import com.arobs.internship.arobs.meetups.entity.AwardingHistory;
import org.springframework.stereotype.Service;

@Service
public interface AwardingHistoryService {

    public void awardUserFromTopOfLeaderboard(int prizeId);
}
