package in.kodecamp.services;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/api")
@ApplicationScoped
public class RestApiApplication extends Application {
}