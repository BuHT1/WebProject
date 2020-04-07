package by.epam.webproject.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_students")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="average_score")
	private Double score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		StudentEntity that = (StudentEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(firstName, that.firstName)
				.append(lastName, that.lastName)
				.append(score, that.score)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(firstName)
				.append(lastName)
				.append(score)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.JSON_STYLE)
				.append("id", id)
				.append("firstName", firstName)
				.append("lastName", lastName)
				.append("score", score)
				.toString();
	}

	public static final class Builder {
		private Long id;
		private String firstName;
		private String lastName;
		private Double score;

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withScore(Double score) {
			this.score = score;
			return this;
		}

		public StudentEntity build() {
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setId(id);
			studentEntity.setFirstName(firstName);
			studentEntity.setLastName(lastName);
			studentEntity.setScore(score);
			return studentEntity;
		}
	}
}
