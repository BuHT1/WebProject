package by.epam.webproject.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GroupDTO {

    private Long id;
    private String name;
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

        GroupDTO groupDTO = (GroupDTO) o;

        return new EqualsBuilder()
                .append(id, groupDTO.id)
                .append(name, groupDTO.name)
                .append(specialityOtdelenieId, groupDTO.specialityOtdelenieId)
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
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
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

        public GroupDTO build() {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setId(id);
            groupDTO.setName(name);
            groupDTO.setSpecialityOtdelenieId(specialityOtdelenieId);
            return groupDTO;
        }
    }
}
