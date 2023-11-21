package com.demo.person.hobby;

import com.demo.person.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {

    @Query("SELECT h FROM Hobby h WHERE h.name = ?1")
    Optional<Hobby> findHobbyBy(String hobby);
}
