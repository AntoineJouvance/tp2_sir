package domaine;

 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.Id;
 import javax.persistence.ManyToOne;



@Entity
public class ElectronicDevice {

    private int id;
    private String name;
    private Person owner;
    private float cons;

    public ElectronicDevice(){
    }



    public float getCons() {
        return cons;
    }


    public void setCons(float cons) {
        this.cons = cons;
    }



    public ElectronicDevice(String name, float cons,Person owner) {
        this.name = name;
        this.owner = owner;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
