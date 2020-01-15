package com.arobs.internship.arobs.meetups.service.awardingHistory;

import com.arobs.internship.arobs.meetups.entity.AwardingHistory;
import com.arobs.internship.arobs.meetups.entity.Prize;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.awardingHistory.AwardingHistoryRepository;
import com.arobs.internship.arobs.meetups.repository.prize.PrizeRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AwardingHistoryObject {

    @Autowired
    AwardingHistoryRepository awardingHistoryRepository;

    @Autowired
    UserRepositoryFactory userRepositoryFactory;

    @Autowired
    PrizeRepository prizeRepository;

    public void awardUserFromTopOfLeaderBoard(int prizeId){

        UserRepository userRepository=userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);

        List<User> users=userRepository.getAllUsers();
        Collections.sort(users);

        User awardedUser=users.get(0);
        Prize prize=prizeRepository.getPrizeById(prizeId);

        AwardingHistory awardingHistory=new AwardingHistory(awardedUser,prize,awardedUser.getPoints());
        awardingHistoryRepository.addAwardingHistory(awardingHistory);

        for(int i=0;i<users.size();i++)
            users.get(i).resetPoints();

    }
}
