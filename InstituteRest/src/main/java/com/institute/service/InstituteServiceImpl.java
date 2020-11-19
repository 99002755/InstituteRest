package com.institute.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.dao.InstituteRepository;
import com.institute.exceptions.InstituteNotFoundException;
import com.institute.model.Institute;
@Service
public class InstituteServiceImpl implements InstituteService {
	@Autowired
	InstituteRepository instituteRepository;
	
	@Override
	public Institute getInstituteById(Integer instituteid) throws InstituteNotFoundException {
		return instituteRepository.findById(instituteid)
				.orElseThrow(()->new InstituteNotFoundException("Institute with specified id not found"));
	}

	@Override
	public Institute addInstitute(Institute institute) {
		Institute newinstitute=instituteRepository.save(institute);
		return newinstitute;
	}

	@Override
	public Boolean deleteInstituteById(Integer id) throws InstituteNotFoundException {
		instituteRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Institute> getAllInstitute() {
		return instituteRepository.findAll();
	}

	@Override
	public List<Institute> getInstituteByFacultyName(String facultyname) throws InstituteNotFoundException {
		return instituteRepository.findByFacultyName(facultyname);
	}

	@Override
	public List<Institute> getInstituteByState(String institutestate) throws InstituteNotFoundException {
	 return instituteRepository.findByInstitutestate(institutestate);
	}

	@Override
	public List<Institute> findInstituteByYear(Integer year) throws InstituteNotFoundException {
		return instituteRepository.findByYear(year);
	}
	
	@Override
	public Institute updateInstitute(Institute institute) {
		return instituteRepository.save(institute);
	}

		@Override
	public List<Institute> findByYearAndInstitutestate(Integer year,String institutestate) {
		return instituteRepository.findByYearAndInstitutestate(year, institutestate);
	}

}
