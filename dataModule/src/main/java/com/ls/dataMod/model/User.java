package com.ls.dataMod.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
 

@Entity
@Table(name="APP_USER")
public class User implements Serializable{
//  @NotEmpty
//  @Column(name="SSO_ID", unique=true, nullable=false)
//  private String ssoId;
	
	/*@NotEmpty
  @Column(name="FIRST_NAME", nullable=false)
  private String firstName;

  @NotEmpty
  @Column(name="LAST_NAME", nullable=false)
  private String lastName;*/
	 public User() {
		 
	 }
	
    public User(User user) {
		this.email = user.email;
		this.userName = user.userName;
		this.id = user.id;
		this.password = user.password;
		this.userProfiles = user.userProfiles;
		this.contactNumber = user.contactNumber;
		this.createDate = user.createDate;
		this.updateDate = user.updateDate;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
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
    
    //@NotEmpty
   // @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Create_User", nullable=false)
    private Instant createDate; 
    
    //@NotEmpty
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name="Update_User", nullable=false)
    private Instant updateDate;
 
    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
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
 
    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }
 
    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
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
		return updateDate;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
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
 
    /*
     * DO-NOT-INCLUDE passwords in toString function.
     * It is done here just for convenience purpose.
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + userName + ", password=" + password
                + ", firstName=" + userName + ", lastName=" + userName
                + ", email=" + email + ", contactNum=" + contactNumber+ "]";
    }
 
 
     
}