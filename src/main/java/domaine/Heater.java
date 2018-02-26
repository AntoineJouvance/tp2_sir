package domaine;


import javax.persistence.*;

@Entity
public class Heater {

  private int id;
  private double meanConso;
  private Home home;

  public Heater(double meanConso) {
    this.meanConso = meanConso;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMeanConso(double meanConso) {
    this.meanConso = meanConso;
  }

  public void setHome(Home home) {
    this.home = home;
  }


  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public double getMeanConso() {
    return meanConso;
  }

  @ManyToOne
  public Home getHome() {
    return home;
  }
}
