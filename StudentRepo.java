package com.org.institution.StudentInfo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.institution.StudentInfo.entity.StudentEntity;
import com.org.institution.StudentInfo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long>{
	
	StudentEntity findBySid(int sid);
	
	 List<StudentEntity> findByCid(int cid);
}
