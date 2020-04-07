package by.epam.webproject.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StudentGroupDTO {

    private Long id;
    private Long studentId;
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

        StudentGroupDTO that = (StudentGroupDTO) o;

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

        public StudentGroupDTO build() {
            StudentGroupDTO studentGroupDTO = new StudentGroupDTO();
            studentGroupDTO.setId(id);
            studentGroupDTO.setStudentId(studentId);
            studentGroupDTO.setGroupId(groupId);
            return studentGroupDTO;
        }
    }
}
