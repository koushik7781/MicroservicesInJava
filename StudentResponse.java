package com.org.institution.collegeInfo.model;

import java.util.List;

public class StudentResponse {
    private String label;
    private List<Student> students;
    private int totalStudentsCount;

    // Constructor
    public StudentResponse(String label, List<Student> students, int totalStudentsCount) {
        this.label = label;
        this.students = students;
        this.totalStudentsCount=totalStudentsCount;
    }

    // Getters and setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    

    public int getTotalStudentsCount() {
		return totalStudentsCount;
	}

	public void setTotalStudentsCount(int totalStudentsCount) {
		this.totalStudentsCount = totalStudentsCount;
	}

	@Override
    public String toString() {
        return "StudentResponse{" +
                "label='" + label + '\'' +
                ", students=" + students +
                '}';
    }
}

