package by.epam.webproject.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "speciality")
public class SpecialityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_speciality")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_faculty")
    private Long facultyId;

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

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SpecialityEntity that = (SpecialityEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(facultyId, that.facultyId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(facultyId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("facultyId", facultyId)
                .toString();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Long facultyId;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withFacultyId(Long facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public SpecialityEntity build() {
            SpecialityEntity specialityEntity = new SpecialityEntity();
            specialityEntity.setId(id);
            specialityEntity.setName(name);
            specialityEntity.setFacultyId(facultyId);
            return specialityEntity;
        }
    }
}
