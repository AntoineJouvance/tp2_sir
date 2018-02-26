package domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ElectronicDevice {

  private Long id;
  private Double meanConso;
  private Home home;

  public ElectronicDevice(Long id, Double meanConso, Home home) {
    this.meanConso = meanConso;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMeanConso(Double meanConso) {
    this.meanConso = meanConso;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public Double getMeanConso() {
    return meanConso;
  }

  @ManyToOne
  public Home getHome() {
    return home;
  }
}
