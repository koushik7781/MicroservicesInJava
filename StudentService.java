package com.org.institution.StudentInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.institution.StudentInfo.entity.StudentEntity;
import com.org.institution.StudentInfo.model.Student;
import com.org.institution.StudentInfo.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;
	
	public List<Student> getStudentDetails(){
		
		ArrayList<Student> studentList= new ArrayList<>();
	
		
		List<StudentEntity> allEntity = studentRepo.findAll();
		for (StudentEntity studentEntity : allEntity) {
			Student s= new Student(studentEntity.getSid(),studentEntity.getSname(),studentEntity.getSage(), studentEntity.getCid());
			studentList.add(s);
		}
		
		return studentList;
		
		
	}

	public int createStudent(Student student) {
		int i = 0;
		StudentEntity entity = new StudentEntity(student.getSid(), student.getSname(), student.getSage(), student.getCid());
		if (entity != null) {
			studentRepo.save(entity);
			i = 1;
		}
		return i;
	}
	
	public String updateStudent(int id, String name, int sage, int collegeId) {
		String updatedId= "N";
		StudentEntity student = studentRepo.findBySid(id);
		if (student != null) {
			student.setSname(name);
			student.setCid(collegeId);
			student.setSage(sage);
			studentRepo.save(student);
			updatedId="Y";
		}
		return updatedId;
	}

	public List<Student> getStudentDetailsByCid(int cid) {
		 List<StudentEntity> allEntities = studentRepo.findByCid(cid);
	        List<Student> studentList = new ArrayList<>();

	        for (StudentEntity studentEntity : allEntities) {
	            Student s = new Student(
	                studentEntity.getSid(),
	                studentEntity.getSname(),
	                studentEntity.getSage(),
	                studentEntity.getCid()
	            );
	            studentList.add(s);
	        }

	        return studentList;
	}

}
