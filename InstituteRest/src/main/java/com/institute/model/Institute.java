package com.institute.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="instituterest")
@TypeAlias("Institute")
public class Institute {
	@Id
	Integer instituteid;
	 String institutename;
	Integer year;
    String institutestate;
	 Faculty faculty;
	 
	 
	public Institute(Integer instituteid, String institutename, Integer year, String institutestate, Faculty faculty) {
		super();
		this.instituteid = instituteid;
		this.institutename = institutename;
		this.year = year;
		this.institutestate = institutestate;
		this.faculty = faculty;
	}


	public Integer getInstituteid() {
		return instituteid;
	}


	public void setInstituteid(Integer instituteid) {
		this.instituteid = instituteid;
	}


	public String getInstitutename() {
		return institutename;
	}


	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getInstitutestate() {
		return institutestate;
	}


	public void setInstitutestate(String institutestate) {
		this.institutestate = institutestate;
	}


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Institute [instituteid=" + instituteid + ", institutename=" + institutename + ", year=" + year
				+ ", institutestate=" + institutestate + ", faculty=" + faculty + "]";
	}
	

}
