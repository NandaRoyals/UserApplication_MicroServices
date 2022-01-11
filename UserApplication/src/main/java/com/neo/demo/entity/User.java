package com.neo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
@Entity
@Table(name="user")
//@Document(collection = "UserInfo")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int UserId;

	@NotBlank(message = "Please enter name")
	@Size(min = 4, message = "Name should be atleast 4 characters")
	private String firstName;

	@NotBlank(message = "Please enter name")
	@Size(min = 4, message = "Name should be atleast 4 characters")
	private String lastName;

	@NotBlank(message = "Please enter Date of Birth in dd-mm-yyyy ")
	@JsonFormat(pattern = "dd-mm-yyyy", shape = Shape.STRING)
	private String dateofBirth;

	@NotBlank(message = "Please enter Date of Joining in dd-mm-yyyy")
	@JsonFormat(pattern = "dd-mm-yyyy", shape = Shape.STRING)
	private String dateOfJoining;

	@Email(message = "Please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotBlank(message = "Please enter Email")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Please enter Adress")
	private String adress;

	@NotBlank(message = "Please enter Pincode")
	@Pattern(regexp = "^([0-9]{4}|[0-9]{6})$")
	private String pincode;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
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

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateofBirth="
				+ dateofBirth + ", dateOfJoining=" + dateOfJoining + ", email=" + email + ", adress=" + adress
				+ ", pincode=" + pincode + ", deleted=" + deleted + "]";
	}

	public User(int userId,
			@NotBlank(message = "Please enter name") @Size(min = 4, message = "Name should be atleast 4 characters") String firstName,
			@NotBlank(message = "Please enter name") @Size(min = 4, message = "Name should be atleast 4 characters") String lastName,
			@NotBlank(message = "Please enter Date of Birth in dd-mm-yyyy ") String dateofBirth,
			@NotBlank(message = "Please enter Date of Joining in dd-mm-yyyy") String dateOfJoining,
			@Email(message = "Please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}") @NotBlank(message = "Please enter Email") String email,
			@NotBlank(message = "Please enter Adress") String adress,
			@NotBlank(message = "Please enter Pincode") @Pattern(regexp = "^([0-9]{4}|[0-9]{6})$") String pincode,
			boolean deleted) {
		super();
		UserId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofBirth = dateofBirth;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.adress = adress;
		this.pincode = pincode;
		this.deleted = deleted;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean deleted = Boolean.FALSE;

}
