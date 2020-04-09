package by.epam.webproject.resourcesjersey;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.service.GroupService;
import by.epam.webproject.service.impl.GroupServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/universities/{univerId}/faculties/{facultyId}/specialities/{specialityId}/groups")
@Produces(MediaType.APPLICATION_JSON)
public class GroupResource {

    @Autowired
    private GroupServiceImpl groupService;

    @GET
    @Path("/{groupId}")
    public GroupDTO get(@PathParam("univerId")Long univerId,
                        @PathParam("facultyId")Long facultyId,
                        @PathParam("specialityId")Long specialityId,
                        @PathParam("groupId")Long groupId){
        GroupDTO groupDTO = groupService.get(univerId, facultyId, specialityId, groupId);

        return groupDTO;
    }
}
