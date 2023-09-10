package com.boot.aatral.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuManager {

	@Id
	private String empid;
	private String rrDate;
	private String projectName;
	private String division;
	private String resourceStartDate;
	private String requestorName;
	private String designation;
	private String contactNumber;
	private String email;
	private String experienceLevel;
	private String jobDescription;
	private String ctcOfferDetails;
	private String workLocation;

}