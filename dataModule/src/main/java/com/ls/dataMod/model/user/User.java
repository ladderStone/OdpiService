package com.ls.dataMod.model.user;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize; 

import com.ls.dataMod.model.skill.Skills;
import com.ls.dataMod.models.mapping.UserSkill;

@Entity
@Table(name="USER")
public class User{

	//@JsonDeserialize(using = IdToUUIDDeserializer.class)
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private UUID id;
 
	@NotEmpty
    @Column(name="User_Name", unique = true,nullable=false)
    private String userName;
	
	@NotEmpty
    @Column(name="Password", nullable=false)
    private String password;
         
	@NotEmpty
    @Column(name="Email", unique = true,nullable=false)
    private String email;
    
    @NotEmpty
    @Column(name="Contact_Number", unique = true,nullable=false)
    private String contactNumber;
    
    @NotNull
    @Column(name="Create_User")
    private Instant createDate; 
    
    @NotNull
    @Column(name="Update_User")
    private Instant updateDate;
    
    @NotNull
    @Column(name="Dob")
    private Instant dob;
    
    @NotEmpty
    @Column(name="First_Name", unique = true,nullable=false)
    private String firstName;
    
    @NotEmpty
    @Column(name="Last_Name", unique = true,nullable=false)
    private String lastName;
    
    
    
    @Column(name="User_Experience")
    private Integer experience;
 
    /*@NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();*/
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "USER_SKILL",
    		joinColumns = {@JoinColumn(name="USER_ID") },
    		inverseJoinColumns = { @JoinColumn(name = "SKILL_ID") }	)
    private Set<Skills> listSkill = new HashSet<>();
    
    
    
    
    
    
    
    public User() {
	}
 
    public User(UUID id, String userName, String password, String email, String contactNumber,
			@NotNull Instant createDate, @NotNull Instant updateDate, @NotNull Instant dob, String firstName,
			String lastName, Integer experience) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
	}
    
    public User(User user) {
		this.email = user.email;
		this.userName = user.userName;
		this.id = user.id;
		this.password = user.password;
		//this.userProfiles = user.userProfiles;
		this.contactNumber = user.contactNumber;
		this.createDate = user.createDate;
		this.updateDate = user.updateDate;
		this.experience = user.experience;
		this.dob = user.dob;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
	}

	public UUID getId() {
        return id;
    }
 
    public void setId(UUID id) {
        this.id = id;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
 
    public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public Instant getUpdateDate() {
		return updateDate ;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Instant getDob() {
		return dob;
	}

	public void setDob(Instant dob) {
		this.dob = dob;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", dob=" + dob + ", firstName=" + firstName + ", lastName=" + lastName + ", experience=" + experience
				+ "]";
	}
     
    
}
