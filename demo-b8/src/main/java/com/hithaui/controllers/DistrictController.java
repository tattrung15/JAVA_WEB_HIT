package com.hithaui.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dto.DistrictDTO;
import com.hithaui.exceptions.DuplicateException;
import com.hithaui.models.District;
import com.hithaui.models.Province;
import com.hithaui.repositories.DistrictRepository;
import com.hithaui.repositories.ProvinceRepository;
import com.hithaui.utils.ConvertObject;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class DistrictController {

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@GetMapping
	public ResponseEntity<?> getAllDistricts() {
		List<District> districts = districtRepository.findAll();
		return ResponseEntity.status(200).body(districts);
	}

	@PostMapping
	public ResponseEntity<?> createNewDistrict(@RequestBody DistrictDTO districtDTO) {
		District oldDistrict = districtRepository.findByCode(districtDTO.getCode());
		if (oldDistrict != null) {
			throw new DuplicateException("District has ready exists");
		}
		District district = ConvertObject.fromDistrictDTOToDistrictDAO(districtDTO);

		Province province = provinceRepository.findByCode(districtDTO.getParentCode());

		district.setPath(districtDTO.getName() + ", " + province.getName());
		district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());
		district.setCode(districtDTO.getCode());
		district.setParentCode(province.getCode());
		district.setProvince(province);
		District newDistrict = districtRepository.save(district);

		return ResponseEntity.status(201).body(newDistrict);
	}

	@Transactional
	@PostMapping("/district-collection")
	public ResponseEntity<?> createDistricts(@RequestBody List<DistrictDTO> districtDTOs) {
		List<District> districts = new LinkedList<District>();

		for (int i = 0; i < districtDTOs.size(); i++) {
			District oldDistrict = districtRepository.findByCode(districtDTOs.get(i).getCode());
			if (oldDistrict != null) {
				throw new DuplicateException("District has ready exists");
			}
			District district = ConvertObject.fromDistrictDTOToDistrictDAO(districtDTOs.get(i));

			Province province = provinceRepository.findByCode(districtDTOs.get(i).getParentCode());

			district.setPath(districtDTOs.get(i).getName() + ", " + province.getName());
			district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());
			district.setCode(districtDTOs.get(i).getCode());
			district.setParentCode(province.getCode());
			district.setProvince(province);
			District newDistrict = districtRepository.save(district);
			districts.add(newDistrict);
		}

		return ResponseEntity.status(201).body(districts);
	}
}
