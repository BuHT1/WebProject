package by.epam.webproject.resourcesjersey.application;

import by.epam.webproject.resourcesjersey.GroupResource;

import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(GroupResource.class));
    }
}

