package com.org.institution.StudentInfo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="rollno")
	private int sid;
	
	@Column(name="name")
	private String sname;
	
	@Column(name="age")
	private int sage;
	
	@Column(name="collegeid")
    private int cid;
	
	
	
	public StudentEntity() {}

	public StudentEntity(int sid, String sname, int sage, int cid ) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.cid= cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}
	
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "StudentEntity [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
	}
	
	
	
	
	
	
	

}
