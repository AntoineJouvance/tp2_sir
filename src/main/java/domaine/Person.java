package domaine;

import domaine.Home;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Person {

  private int id;
  private String name;
  private String firstname;
  private String email;
  private Collection<Person> friends;
  private Collection<Home> homes;

  public Person(String name, String firstname, String email){
    this.firstname = firstname;
    this.name = name;
    this.email = email;
    this.homes = new ArrayList<Home>();
    this.friends = new ArrayList<Person>();
  }

  public Person(){

  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  @JsonIgnore
  @ManyToMany
  public Collection<Person> getFriends() {
    return friends;
  }

  public void setAmis(Collection<Person> friends) {
    this.friends = friends;
  }

  @JsonIgnore
  @OneToMany(mappedBy = "owner")
  public Collection<Home> getHomes() {
    return homes;
  }

  public void setHomes(Collection<Home> homes) {
    this.homes = homes;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
