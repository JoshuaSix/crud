package com.javatest.crud;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ChallengeService {

    private Challenge challenge;

    public ChallengeService( Challenge challenge){
        this.challenge = challenge;
    }

    private List<Challenge> challenges = new ArrayList<>();
    private int nextid;

    public ChallengeService(){
    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public Challenge getChallengeByMonth(String month){
        for(Challenge challenge: challenges){
            if(challenge.getMonth().equals(month)){
                return challenge;
            }
        }
        return null;
    };

    public boolean addAllChallenges(Challenge challenge){
        if(challenge != null){
        challenge.setId(nextid++);
        challenges.add(challenge);
        return true;
        } else {
            return false;
        }
    }

    public Challenge getChallenegByAge(int age) {
        return challenge;
    }
}
