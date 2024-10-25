package com.org.institution.collegeInfo.model;

public class College {
	private int cid;
	private String cstream;
	
	public College(int cid, String cstream) {
		super();
		this.cid = cid;
		this.cstream = cstream;
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
