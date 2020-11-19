package com.institute.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.exceptions.InstituteNotFoundException;
import com.institute.model.Institute;
import com.institute.service.InstituteService;

@RestController
@RequestMapping("/institute-api")
public class InstituteController {
	@Autowired
	InstituteService instituteService;

	@PostMapping("/institute")
	Institute addInstitute(@RequestBody Institute institute) {
		return instituteService.addInstitute(institute);
	}

	@GetMapping("/institute")
	List<Institute> getAllInstitute() {
		return instituteService.getAllInstitute();
	}

	@DeleteMapping("/institute/delete-one/{instituteid}")
	boolean deleteInstitute(@PathVariable("instituteid") Integer Instituteid) throws InstituteNotFoundException {
		return instituteService.deleteInstituteById(Instituteid);
	}

	@GetMapping("/institute/get-one/{instituteid}")
	Institute getStudentById(@PathVariable("instituteid") Integer instituteid) throws InstituteNotFoundException {
		return instituteService.getInstituteById(instituteid);
	}

	@GetMapping("/institute/institutestate/{institutestate}")
	List<Institute> getInstituteByState(@PathVariable("institutestate") String institutestate)
			throws InstituteNotFoundException {
		return instituteService.getInstituteByState(institutestate);
	}

	@GetMapping("/institute/year/{year}")
	List<Institute> getInstituteByYear(@PathVariable("year") Integer year) throws InstituteNotFoundException {
		return instituteService.findInstituteByYear(year);
	}

	@GetMapping("/institute/facultyname/{facultyname}")
	List<Institute> getInstituteByFacultyName(@PathVariable("facultyname") String facultyname)
			throws InstituteNotFoundException {
		return instituteService.getInstituteByFacultyName(facultyname);
	}

	@GetMapping("/institute/yearinstitutestate/{year}/{institutestate}")
	public ResponseEntity<List<Institute>> findByYearAndInstitutestate(@PathVariable("year") Integer year,
			@PathVariable("institutestate") String institutestate) {
		List<Institute> instituteList = instituteService.findByYearAndInstitutestate(year, institutestate);
		return ResponseEntity.ok(instituteList);
	}
}
