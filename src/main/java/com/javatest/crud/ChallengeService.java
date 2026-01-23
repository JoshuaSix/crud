package com.javatest.crud;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

    private ChallengeRepository challengeRepository;

    public ChallengeService( ChallengeRepository challengeRepository){
        this.challengeRepository = challengeRepository;
    }
    private Long nextid;


//    public ChallengeService(){}


    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public Challenge getChallengeByMonth(String month){
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge
                .orElse(null);
    }

    public Challenge getChallenegByAge(int age) {
        Optional<Challenge> challenge = challengeRepository.findByAge(age);
        return challenge.orElse(null);
    }


    public boolean addAllChallenges(Challenge challenge){
        challengeRepository.save(challenge);
        return true;
        }


    public boolean updateChallenge(Long id, Challenge updateChallenge) {
       Optional<Challenge> challenge = challengeRepository.findById(id);
       if(challenge.isPresent()) {
           Challenge challengeToUpdate = challenge.get();
           challengeToUpdate.setMonth(updateChallenge.getMonth());
           challengeToUpdate.setAge(updateChallenge.getAge());
           challengeToUpdate.setDescription(updateChallenge.getDescription());
           challengeToUpdate.setId(updateChallenge.getId());
           challengeRepository.save(challengeToUpdate);
           return true;
       }
       return false;
    }

    public boolean deleteChallengeById(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }





}






