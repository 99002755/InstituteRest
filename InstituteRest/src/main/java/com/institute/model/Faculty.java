package com.institute.model;

public class Faculty {
String name;
Integer facultyexp;


public Faculty(String name, Integer facultyexp) {
	super();
	this.name = name;
	this.facultyexp = facultyexp;
}
public String getFacultyname() {
	return name;
}
public void setFacultyname(String facultyname) {
	this.name = facultyname;
}
public Integer getFacultyexp() {
	return facultyexp;
}
public void setFacultyexp(Integer facultyexp) {
	this.facultyexp = facultyexp;
}
@Override
public String toString() {
	return "Faculty [facultyname=" + name + ", facultyexp=" + facultyexp + "]";
}
public Faculty() {
	super();
	// TODO Auto-generated constructor stub
}

}
