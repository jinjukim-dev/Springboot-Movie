package org.study.member;


//session 정보 유지
public class AuthInfo {
	
	private String id;
	private String name;
	
	public AuthInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}