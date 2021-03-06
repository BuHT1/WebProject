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
@Table(name = "groups")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_group")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_speciality")
    private Long specialityId;

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

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity that = (GroupEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(specialityId, that.specialityId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(specialityId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("specialityId", specialityId)
                .toString();
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Long specialityId;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSpecialityId(Long specialityId) {
            this.specialityId = specialityId;
            return this;
        }

        public GroupEntity build() {
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setId(id);
            groupEntity.setName(name);
            groupEntity.setSpecialityId(specialityId);
            return groupEntity;
        }
    }
}
