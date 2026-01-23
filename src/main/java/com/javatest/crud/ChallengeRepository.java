package com.javatest.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    Optional<Challenge> findByAge(int age);

    Optional<Challenge> findByMonthIgnoreCase(String month);
}
