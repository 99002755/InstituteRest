package com.institute.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.institute.model.Institute;
@Repository
public interface InstituteRepository extends MongoRepository<Institute, Integer> {
	List<Institute> findByFacultyName(String facultyname);
	List<Institute> findByInstitutestate(String institutestate);
	@Query("{'year':{$gt:?0}}")
	List<Institute> findByYear(Integer year);
	List<Institute> findByYearAndInstitutestate(Integer year,String institutestate);
}
