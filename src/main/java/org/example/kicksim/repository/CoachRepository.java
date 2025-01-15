package org.example.kicksim.repository;

import org.example.kicksim.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    // Find coaches by first name
    List<Coach> findByFirstName(String firstName);

    // Find coaches by last name
    List<Coach> findByLastName(String lastName);

    // Find coaches by first and last name
    List<Coach> findByFirstNameAndLastName(String firstName, String lastName);
}
