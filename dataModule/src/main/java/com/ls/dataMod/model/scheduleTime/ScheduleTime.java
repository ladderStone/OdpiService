package com.ls.dataMod.model.scheduleTime;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Schedule_Time")
public class ScheduleTime{
	
	@Id
    private UUID id;

	@NotEmpty
	@Column(name = "Interviewee_Id", nullable=false)
    private UUID intervieweeId;
	
	@NotEmpty
	@Column(name = "Interviwer_Id", nullable=false)
    private UUID interviwerId;
	
	@NotEmpty
	@Column(name = "Date", nullable=false)
	private Date date;
	
	@NotEmpty
	@Column(name = "Time", nullable=false)
	private Time time;

	public ScheduleTime() {
		super();
	}

	

	public ScheduleTime(UUID id, UUID intervieweeId, UUID interviwerId, Date date, Time time) {
		super();
		this.id = id;
		this.intervieweeId = intervieweeId;
		this.interviwerId = interviwerId;
		this.date = date;
		this.time = time;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getIntervieweeId() {
		return intervieweeId;
	}

	public void setIntervieweeId(UUID intervieweeId) {
		this.intervieweeId = intervieweeId;
	}

	public UUID getInterviwerId() {
		return interviwerId;
	}

	public void setInterviwerId(UUID interviwerId) {
		this.interviwerId = interviwerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
