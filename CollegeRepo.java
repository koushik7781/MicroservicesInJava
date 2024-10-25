package com.org.institution.collegeInfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.institution.collegeInfo.entity.CollegeEntity;

@Repository
public interface CollegeRepo extends JpaRepository<CollegeEntity, Long>{
	CollegeEntity findByCid(int cid);
}
