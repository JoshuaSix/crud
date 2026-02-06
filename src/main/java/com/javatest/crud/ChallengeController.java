package com.javatest.crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:5173")
public class ChallengeController {

    private ChallengeService challengeService ;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getChallenges(){
        return challengeService.getAllChallenges();
    }



    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallengesbyMonth(@PathVariable  String month){
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if(challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge){
       boolean challengeAdded = challengeService.addAllChallenges(challenge);
        if(challengeAdded){
            return new ResponseEntity<>("Challenge added successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("challenge not added successfully!!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallengeById(@PathVariable Long id,@RequestBody Challenge updateChallenge){

        boolean isChallengeUpdated = challengeService.updateChallenge(id, updateChallenge);
        if(isChallengeUpdated){
            return new ResponseEntity<>("Challenge updated successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("challenge not updated successfully!!", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallengeById(@PathVariable Long id){

        boolean isChallengeDelete = challengeService.deleteChallengeById(id);
        if(isChallengeDelete){
            return new ResponseEntity<>("Challenge deleted successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("challenge not deleted successfully!!", HttpStatus.NOT_FOUND);
        }
    }





}
