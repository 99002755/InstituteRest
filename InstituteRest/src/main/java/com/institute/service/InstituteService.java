package com.institute.service;
import java.util.List;

import com.institute.exceptions.InstituteNotFoundException;
import com.institute.model.Institute;

public interface InstituteService {
	Institute getInstituteById(Integer instituteid)throws InstituteNotFoundException ;
	Institute addInstitute(Institute institute);
	Institute updateInstitute(Institute institute);
	Boolean deleteInstituteById(Integer id)throws InstituteNotFoundException ;
	
	List<Institute> getAllInstitute();
	List<Institute> getInstituteByFacultyName(String facultyname)throws InstituteNotFoundException ;
	List<Institute> getInstituteByState(String institutestate)throws InstituteNotFoundException ;
	List<Institute> findInstituteByYear(Integer year)throws InstituteNotFoundException ;
	List<Institute> findByYearAndInstitutestate(Integer year,String institutestate);
}