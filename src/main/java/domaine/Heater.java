package domaine;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

public class Heater {

    private int id;
    private Home home;
    private float cons;



    public Heater(){
    }



    public float getCons() {
        return this.cons;
    }

    public void setCons(float cons) {
        this.cons = cons;
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
    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

}
