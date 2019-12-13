package com.arobs.internship.arobs.meetups.service;

import com.arobs.internship.arobs.meetups.repository.ProposalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalObject {

    @Autowired
    ProposalRepo proposalRepo;


}
