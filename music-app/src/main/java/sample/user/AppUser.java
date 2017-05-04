package sample.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	@NotNull
	private String name;
	
	private Date lastModified;
	
	private Date createdAt;

	AppUser() {
		//empty
	}
	
	public AppUser(String username) {
		this.name = username;
	}
	
	@PrePersist
	void setDefaults() {
		createdAt = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppUser [id=").append(id).append(", name=").append(name).append(", createdAt=")
				.append(createdAt).append("]");
		return builder.toString();
	}

	
}
