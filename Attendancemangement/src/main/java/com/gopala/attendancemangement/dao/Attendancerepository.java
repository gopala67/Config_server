package com.gopala.attendancemangement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopala.attendancemangement.entity.Attendanceentity;

public interface Attendancerepository  extends JpaRepository<Attendanceentity, Long>{

}
