package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.models.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{
	District findByCode(Integer code);
}
