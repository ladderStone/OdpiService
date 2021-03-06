package com.ls.dataMod.model.interviweefeedback;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Interviwee_Feedback")
public class InterviweeFeedback {

	@Id
	private UUID id;
	
	@Column(name="rating", nullable=false)
	@NotNull
	private Integer rating;
	
	@Column(name="feedback", nullable=false)
	@NotNull
	String feedback;
	
	public InterviweeFeedback() {
		super();
	}

	public InterviweeFeedback(UUID id, @NotNull Integer rating, @NotNull String feedback) {
		super();
		this.id = id;
		this.rating = rating;
		this.feedback = feedback;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
