package com.bridgelabz.greetings.greetingsapp.repository;

import com.bridgelabz.greetings.greetingsapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting,Long> {
}
