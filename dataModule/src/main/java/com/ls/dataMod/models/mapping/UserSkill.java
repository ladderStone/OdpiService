package com.ls.dataMod.models.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ls.dataMod.model.skill.Skills;
import com.ls.dataMod.model.user.User;

//@Entity
//@Table(name = "User_Skill")
public class UserSkill {/*

	//@EmbeddedId
	//private UserSkillId id;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	//@MapsId("userId")
	@JoinColumn
	private User user;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	//@MapsId("skillId")
	@JoinColumn
	private Skills skill;
	
	@Column(name = "Experience")
	private double experience;

	public UserSkill() {
		super();
	}

	public UserSkill(User user, Skills skill) {
		super();
		this.user = user;
		this.skill = skill;
		//this.id = new UserSkillId(user.getId(), skill.getSkillId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSkill other = (UserSkill) obj;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
	
	
*/}
