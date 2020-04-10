package by.epam.webproject.resources.jersey;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Component
@Path("/universities/{univerId}/faculties/{facultyId}/specialities/{specialityId}/groups")
@Produces(MediaType.APPLICATION_JSON)
public class GroupRest {

    @Autowired
    private GroupService groupService;

    @GET
    @Path("/{groupId}")
    public Response get(@PathParam("univerId") Long univerId,
                        @PathParam("facultyId") Long facultyId,
                        @PathParam("specialityId") Long specialityId,
                        @PathParam("groupId") Long groupId) {
        GroupDTO groupDTO = groupService.get(univerId, facultyId, specialityId, groupId);

        if (Objects.nonNull(groupDTO)) {
            return Response.ok().entity(groupDTO).build();
        } else {
            return Response.status(404).entity("Group not found.").build();
        }
    }

    @GET
    public List<GroupDTO> getAll(@PathParam("univerId") Long univerId,
                                 @PathParam("facultyId") Long facultyId,
                                 @PathParam("specialityId") Long specialityId) {
        return groupService.getAll(univerId, facultyId, specialityId);
    }

    @DELETE
    @Path("/{groupId}")
    public Response delete(@PathParam("univerId") Long univerId,
                           @PathParam("facultyId") Long facultyId,
                           @PathParam("specialityId") Long specialityId,
                           @PathParam("groupId") Long groupId) {
        try {
            groupService.delete(univerId, facultyId, specialityId, groupId);
        } catch (RuntimeException e) {
            return Response.status(404).entity("Group not found.").build();
        }
        return Response.noContent().build();
    }

    @POST
    public Response save(@PathParam("univerId") Long univerId,
                         @PathParam("facultyId") Long facultyId,
                         @PathParam("specialityId") Long specialityId,
                         GroupDTO groupDTO,
                         @Context HttpServletRequest request) {
        try {
            GroupDTO savedGroupDTO = groupService.save(univerId, facultyId, specialityId, groupDTO);

            return Response.status(201).entity(savedGroupDTO)
                    .header("Location", request.getRequestURL().append("/").append(savedGroupDTO.getId()).toString())
                    .build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    @PUT
    @Path("/{groupId}")
    public Response update(@PathParam("univerId") Long univerId,
                           @PathParam("facultyId") Long facultyId,
                           @PathParam("specialityId") Long specialityId,
                           @PathParam("groupId") Long groupId,
                           GroupDTO groupDTO) {
        GroupDTO updatedGroupDTO = groupService.update(univerId, facultyId, specialityId, groupId, groupDTO);
        if (Objects.nonNull(updatedGroupDTO)) {
            return Response.status(202).entity(updatedGroupDTO).build();
        } else {
            return Response.status(404).entity("Group not found").build();
        }
    }
}
