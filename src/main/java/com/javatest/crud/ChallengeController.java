package com.javatest.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService ;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getChallenges(){
        return challengeService.getAllChallenges();
    }



    @GetMapping("/challenges/month")
    public Challenge getChallengesbyMonth(String month){
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if(challenge != null){
            return challenge;
        }else {
            return null;
        }
//        return challengeService.getAllChallenges();
    }

//    @GetMapping("/challenges")
//    public List<Challenge> getChallengesbyAge(int age){
//        Challenge challenge = challengeService.getChallenegByAge(age);
//        if(challenge.getAge(age) > 21){
//            return Challenge;
//        }else {
//            return null;
//        }
////        return challengeService.getAllChallenges();
//    }

    @PostMapping("/challenges")
    public String addChallenges(@RequestBody Challenge challenge){
       boolean challengeAdded = challengeService.addAllChallenges(challenge);
        if(challengeAdded){
            return "Challenge added successfully!";
        }else {
            return "challenge not added successfully!!";
        }
    }



}
