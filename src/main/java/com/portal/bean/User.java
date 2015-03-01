package com.portal.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.portal.constraints.FieldMatch;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "users")
@FieldMatch.List({
    @FieldMatch(first = "password", second = "verifyPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "verifyEmail", message = "The email fields must match")
})
public class User {
	
	@Id
	private String id;
	
	@NotNull
	//@Pattern(regexp = "^[a-z]+[a-z\\d]*$", flags = {Pattern.Flag.CASE_INSENSITIVE})
	@Pattern(regexp = "^[0-9a-zA-Z]{5,40}$", flags = {Pattern.Flag.CASE_INSENSITIVE})
	private String username;
	
	@NotBlank
	@Email
	private String email;
	
	@Transient
	private String verifyEmail;
	
	@Size(max = 40)
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$")
	private String password;
	
	@Transient
	private String verifyPassword;
	
	@Column(name = "last_updated")
	private Date lastUpdated;
	
	@Column(name = "date_created")
	private Date dateCreated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public boolean equals(Object object) {
		if (!(object instanceof User)) {
			return false;
		}
		User rhs = (User) object;
		return new EqualsBuilder()
				.append(this.email, rhs.email)
				.append(this.username, rhs.username).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(-42402111, -1426108261)
				.append(this.email)
				.append(this.username).toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).append("password", this.password)
				.append("lastUpdated", this.lastUpdated)
				.append("dateCreated", this.dateCreated)
				.append("verifyPassword", this.verifyPassword)
				.append("email", this.email)
				.append("verifyEmail", this.verifyEmail).append("id", this.id)
				.append("username", this.username).toString();
	}

}
