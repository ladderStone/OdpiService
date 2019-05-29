package com.ls.dataMod.model.skill;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.ls.dataMod.models.mapping.UserSkill;

@Entity
@Table(name="Skills")
public class Skills{

	private static final long serialVersionUID = 1L;
	
	@Id
	private UUID skillId;
	
	@NotEmpty
	@Column(name="Skill_Name", unique = true, nullable = false)
	private String skillName;
	
	
	

	public Skills() {
		super();
	}

	public Skills(UUID skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public UUID getSkillId() {
		return skillId;
	}

	public void setSkillId(UUID skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
}
