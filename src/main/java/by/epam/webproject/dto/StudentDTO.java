package by.epam.webproject.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Double score;
    private Long groupId;

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

        StudentDTO that = (StudentDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(firstName, that.firstName)
                .append(lastName, that.lastName)
                .append(score, that.score)
                .append(groupId, that.groupId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(score)
                .append(groupId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("score", score)
                .append("groupId", groupId)
                .toString();
    }


    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Double score;
        private Long groupId;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withGroupId(Long groupId) {
            this.groupId = groupId;
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

        public StudentDTO build() {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(id);
            studentDTO.setFirstName(firstName);
            studentDTO.setLastName(lastName);
            studentDTO.setScore(score);
            studentDTO.setGroupId(groupId);
            return studentDTO;
        }
    }
}
