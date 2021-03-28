package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.models.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer>{
	Province findByCode(Integer code);
}
