package com.org.institution.collegeInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.institution.collegeInfo.entity.CollegeEntity;
import com.org.institution.collegeInfo.model.College;
import com.org.institution.collegeInfo.repo.CollegeRepo;

@Service
public class CollegeService {
	
	@Autowired
	CollegeRepo collegeRepo;
	
	public List<College> getCollegeDetails(){
		
		ArrayList<College> collegeList= new ArrayList<>();
	
		
		List<CollegeEntity> allEntity = collegeRepo.findAll();
		for (CollegeEntity collegeEntity : allEntity) {
			College s= new College(collegeEntity.getCid(),collegeEntity.getCstream());
			collegeList.add(s);
		}
		
		return collegeList;
		
		
	}

	public int createCollege(College college) {
		int i = 0;
		CollegeEntity entity = new CollegeEntity(college.getCid(), college.getCstream());
		if (entity != null) {
			collegeRepo.save(entity);
			i = 1;
		}
		return i;
	}

	public String getStream(int cid) {
		CollegeEntity collegeEntity=collegeRepo.findByCid(cid);
		return collegeEntity.getCstream();
	}

}
