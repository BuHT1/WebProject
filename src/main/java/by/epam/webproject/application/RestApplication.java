package by.epam.webproject.application;

import by.epam.webproject.resources.jersey.GroupRest;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Collections.singletonList(GroupRest.class));
    }
}

