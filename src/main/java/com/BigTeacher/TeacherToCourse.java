package com.BigTeacher;

public class TeacherToCourse {
	private int teacherToCourseId;
	private int professorId;
	private int courseId;
	
	public TeacherToCourse() {}
	
	public TeacherToCourse(int teacherToCourseId, int professorId, int courseId) {
	    this.teacherToCourseId = teacherToCourseId;
	    this.professorId = professorId;
	    this.courseId = courseId;
	}
	
	public int getTeacherToCourseId() {
	    return teacherToCourseId;
	}
	
	public void setTeacherToCourseId(int teacherToCourseId) {
	    this.teacherToCourseId = teacherToCourseId;
	}
	
	public int getProfessorId() {
	    return professorId;
	}
	
	public void setProfessorId(int professorId) {
	    this.professorId = professorId;
	}
	
	public int getCourseId() {
	    return courseId;
	}
	
	public void setCourseId(int courseId) {
	    this.courseId = courseId;
	}
}