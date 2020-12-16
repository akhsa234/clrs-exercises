package com.bahar.blog.repository;

import com.bahar.blog.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    void deleteById(Long id);
    Person findPersonById(Long id);

    Person findNameById(Long id);
    @Query(value = "SELECT firstName,lastName FROM Person pr WHERE pr.id = :id",nativeQuery = true)
    Person findNameAndLastNameById(@Param("id")Long id);
}
