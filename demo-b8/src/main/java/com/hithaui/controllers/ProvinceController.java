package com.hithaui.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.ProvinceDTO;
import com.hithaui.exceptions.DuplicateException;
import com.hithaui.models.Province;
import com.hithaui.repositories.ProvinceRepository;
import com.hithaui.utils.ConvertObject;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class ProvinceController {

	@Autowired
	private ProvinceRepository provinceRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllProvinces(){
		List<Province> provinces = provinceRepository.findAll(Sort.by("code"));
		return ResponseEntity.status(200).body(provinces);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> getProvinceByCode(@PathVariable("code") Integer code){
		Province province = provinceRepository.findByCode(code);
		return ResponseEntity.status(200).body(province);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewProvince(@RequestBody ProvinceDTO provinceDTO){
		Province oldProvince = provinceRepository.findByCode(provinceDTO.getCode());
		if(oldProvince != null) {
			throw new DuplicateException("Province has ready exists");
		}
		Province province = ConvertObject.fromProvinceDTOToProvinceDAO(provinceDTO);
		Province newProvince = provinceRepository.save(province);
		return ResponseEntity.status(201).body(newProvince);
	}
	
	@Transactional
	@PostMapping("/province-collection")
	public ResponseEntity<?> createNewProvince(@RequestBody List<ProvinceDTO> listProvinceDTOs){
		List<Province> provinceDAOs = new LinkedList<Province>();
		
		for (int i = 0; i < listProvinceDTOs.size(); i++) {
			Province province = new Province();
			province = ConvertObject.fromProvinceDTOToProvinceDAO(listProvinceDTOs.get(i));
			provinceDAOs.add(province);
		}
		
		List<Province> newProvinces = provinceRepository.saveAll(provinceDAOs);
		
		return ResponseEntity.status(201).body(newProvinces);
	}
	
	@GetMapping("/{code}/districts")
	public ResponseEntity<?> getDistrictByProvince(@PathVariable("code") Integer code){
		Province province = provinceRepository.findByCode(code);
		return ResponseEntity.status(200).body(province.getDistricts());
	}
}
