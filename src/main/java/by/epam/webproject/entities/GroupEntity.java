package by.epam.webproject.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collection;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "groups")
public class GroupEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_group")
	private Long id;
	
	@Column(name="name")
	private String name;

	@Column(name="id_speciality_otdelenie")
	private Long specialityOtdelenieId;

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

	public Long getSpecialityOtdelenieId() {
		return specialityOtdelenieId;
	}

	public void setSpecialityOtdelenieId(Long specialityOtdelenieId) {
		this.specialityOtdelenieId = specialityOtdelenieId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		GroupEntity that = (GroupEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(specialityOtdelenieId, that.specialityOtdelenieId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(name)
				.append(specialityOtdelenieId)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.JSON_STYLE)
				.append("id", id)
				.append("name", name)
				.append("specialityOtdelenieId", specialityOtdelenieId)
				.toString();
	}

	public static final class Builder {
		private Long id;
		private String name;
		private Long specialityOtdelenieId;

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withSpecialityOtdelenieId(Long specialityOtdelenieId) {
			this.specialityOtdelenieId = specialityOtdelenieId;
			return this;
		}

		public GroupEntity build() {
			GroupEntity groupEntity = new GroupEntity();
			groupEntity.setId(id);
			groupEntity.setName(name);
			groupEntity.setSpecialityOtdelenieId(specialityOtdelenieId);
			return groupEntity;
		}
	}
}
