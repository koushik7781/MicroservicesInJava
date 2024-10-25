package com.org.institution.collegeInfo.entity;

import java.util.Set;

import com.org.institution.collegeInfo.model.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class CollegeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="collegeId")
	private int cid;
	
	@Column(name="stream")
	private String cstream;
	


	public CollegeEntity(int cid, String cstream) {
		
		this.cid = cid;
		this.cstream = cstream;
	}

	public CollegeEntity() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCstream() {
		return cstream;
	}

	public void setCstream(String cstream) {
		this.cstream = cstream;
	}
	
	
	
	
	
	
	
	
	

}
