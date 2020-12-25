package in.kodecamp.services.student;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

/**
 * StudentController
 */
@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

  @Inject
  @ConfigProperty(name = "someValue")
  private String value;

  @PersistenceContext
  private EntityManager em;

  public StudentController() {
    System.out.println("Constructor : StudentController @@@@@@@@@@@@@ ");
  }

  @Path("/{id}")
  @GET
  public LinkedHashMap<String, String> student(@PathParam("id") String id) {
    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    map.put("id", id);
    map.put("name", "sunil kumar 888");
    map.put("address", "My Address 888");
    map.put("address", "My Address 888");
    map.put("age", "65");
    return map;
  }

  @GET
  public List<LinkedHashMap<String, String>> listAll() {
    //@formatter:off
    List<LinkedHashMap<String,String>> map =  em.createQuery("from StudentEntity se", StudentEntity.class)
      .getResultList().stream()
      .map(this::convertIntoMap)
      .collect(Collectors.toList());
    //@formatter:on
    return map;
  }

  private LinkedHashMap<String, String> convertIntoMap(final StudentEntity se) {
    final LinkedHashMap<String, String> map = new LinkedHashMap<>();
    map.put("id", String.valueOf(se.getId()));
    map.put("name", se.getName());
    map.put("address", se.getAddress());
    map.put("createdOn", se.getCreatedOn().toString());
    map.put("modifiedOn", se.getModifiedOn().toString());
    return map;
  }

  @Path("/value")
  @GET
  public String value() {
    return this.value;
  }

  @Path("/code")
  @GET
  public String code() {
    return "RX100";
  }

}
