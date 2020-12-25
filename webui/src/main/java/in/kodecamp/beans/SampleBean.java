package in.kodecamp.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SampleBean {
  private String name = "Sunil Kumar Verma";
  private String address;
  private String firstname = "Sunil Verma";
  private String lastname = "Kumar";

  public SampleBean(String name, String address, String firstname, String lastname) {
    super();
    this.name = name;
    this.address = address;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public SampleBean() {
    System.out.println("Constructor : SampleBean #############");
  }

  public String getLastname() { return this.lastname; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getAddress() { return address; }

  public void setAddress(String address) { this.address = address; }

  public String getFirstname() { return this.firstname; }

  public void doSomething() {
    System.out.println("Method called.");
    System.out.println("Name : " + this.name);
    System.out.println("Address : " + this.address);
    System.out.println("Address : " + this.address);
  }

}
