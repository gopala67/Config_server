package com.gopala.courseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopala.courseapp.entity.Coursedetails;
@Repository
public interface Courserepository extends JpaRepository<Coursedetails, Long> {

}
