package in.kodecamp.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ContactDetails implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String number;
  private String serviceProvider;

  public ContactDetails(final String number, final String serviceProvider) {
    this.number = number;
    this.serviceProvider = serviceProvider;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getServiceProvider() {
    return serviceProvider;
  }

  public void setServiceProvider(String serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

}
