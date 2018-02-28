package domaine;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Home {

  private int id;
  private Collection<Heater> heaters;
  private float size;
  private int nbRoom;
  private Person owner;

  public Home() {
  heaters = new ArrayList<Heater>();
  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @JsonIgnore
  @OneToMany(mappedBy="home")
  public Collection<Heater> getHeaters() {
    return heaters;
  }

  public void setHeaters(Collection<Heater> heaters) {
    this.heaters = heaters;
  }

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  public int getNbRoom() {
    return nbRoom;
  }

  public void setNbRoom(int nbRoom) {
    this.nbRoom = nbRoom;
  }

  @ManyToOne
  public Person getOwner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

}
