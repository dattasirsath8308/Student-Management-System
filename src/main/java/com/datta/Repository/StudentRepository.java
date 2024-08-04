package com.datta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datta.entity.Student;

// <Student, Long>   type of JPA Entity Student & type of Primary Key 													
// Here we dont need to add @Repositoy annotation bcoz JPARepository internally simpleJPARepository class implementation of JPA & JPArepostory provide default Transaction all this methods  
public interface StudentRepository extends JpaRepository<Student, Long>{

}
