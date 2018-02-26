package domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Person {


  private Long id;
  private String name;
  private String firstName;
  private String mail;
  private List<Person> freinds;

  public Person(){

  }
  public Person(String name, String firstName, String mail) {
    this.name = name;
    this.firstName = firstName;
    this.mail = mail;
    this.freinds = new ArrayList<Person>();
  }



  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }


  public void setFreinds(List<Person> freinds) {
    this.freinds = freinds;
  }


  public String getName() {
    return name;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMail() {
    return mail;
  }


  @OneToMany
  public List<Person> getFreinds() {
    return freinds;
  }


  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }
}
