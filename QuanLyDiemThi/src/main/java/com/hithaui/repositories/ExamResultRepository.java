package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.ExamResult;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Integer>{

}
