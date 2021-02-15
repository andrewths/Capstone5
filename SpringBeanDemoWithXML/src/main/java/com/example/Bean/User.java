package com.example.Bean;

public class User {
	private String name;
	private String skill;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkill() {
		System.out.println("Skill is : " +  skill);
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
		
	}
}
