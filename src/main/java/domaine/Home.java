package domaine;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Home {

  private Long id;
  private int size;
  private int numberOfRoom;
  private Person owner;
  private List<Heater> heaterList;
  private List<ElectronicDevice> electronicDeviceList;


  public Home(int size, int numberOfRoom) {
    this.size = size;
    this.numberOfRoom = numberOfRoom;
    this.heaterList = new ArrayList<Heater>();
    this.electronicDeviceList = new ArrayList<ElectronicDevice>();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setNumberOfRoom(int numberOfRoom) {
    this.numberOfRoom = numberOfRoom;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public void setHeaterList(List<Heater> heaterList) {
    this.heaterList = heaterList;
  }

  public void setElectronicDeviceList(List<ElectronicDevice> electronicDeviceList) {
    this.electronicDeviceList = electronicDeviceList;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public int getSize() {
    return size;
  }


  public int getNumberOfRoom() {
    return numberOfRoom;
  }

  @ManyToOne
  public Person getOwner() {
    return owner;
  }

  @OneToMany
  public List<Heater> getHeaterList() {
    return heaterList;
  }

  @OneToMany
  public List<ElectronicDevice> getElectronicDeviceList() {
    return electronicDeviceList;
  }
}
