package by.epam.webproject.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_groups")
public class StudentGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_student")
    private Long studentId;

    @Column(name = "id_group")
    private Long groupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StudentGroupEntity that = (StudentGroupEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(studentId, that.studentId)
                .append(groupId, that.groupId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(studentId)
                .append(groupId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("studentId", studentId)
                .append("groupId", groupId)
                .toString();
    }

    public static final class Builder {
        private Long id;
        private Long studentId;
        private Long groupId;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withStudentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder withGroupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }

        public StudentGroupEntity build() {
            StudentGroupEntity studentGroupEntity = new StudentGroupEntity();
            studentGroupEntity.setId(id);
            studentGroupEntity.setStudentId(studentId);
            studentGroupEntity.setGroupId(groupId);
            return studentGroupEntity;
        }
    }
}
