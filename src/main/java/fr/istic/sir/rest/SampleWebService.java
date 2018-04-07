
package fr.istic.sir.rest;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import jpa.EntityManagerHelper;

import domaine.Home;
import domaine.Person;

@Path("/API")
public class SampleWebService {
    EntityManager manager = EntityManagerHelper.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public SampleWebService(){

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bienvenu() {
        return "Bienvenu sur notre API";
    }

    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getPerson() {

        Collection<Person> result = manager.createQuery("Select p from Personne p", Person.class).getResultList();

        return result;
    }

    @GET
    @Path("/persons/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) {

        Person result = manager.createQuery("Select p from Person p where p.id = :id", Person.class)
                .setParameter("id", id).getResultList().get(0);

        return result;
    }

    @GET
    @Path("/homes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Home> getHome() {

        Collection<Home> result = manager.createQuery("Select h from Home h", Home.class).getResultList();

        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();

        return result;
    }

    @POST
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(@QueryParam("firstname") String firstname, @QueryParam("name") String name,
                                 @QueryParam("mail") String mail) {
        Person p = new Person();
        p.setEmail(mail);
        p.setName(name);
        p.setFirstname(firstname);

        tx.begin();
        manager.persist(p);
        tx.commit();

        String result = "Nom: " + name + "\n Prenom : " + firstname + "\n Email : " + mail;
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/home")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHome(
                                 @QueryParam("nbRoom") int nbRoom,@QueryParam("size") float size, @QueryParam("idOwner") long idP) {
        Home home = new Home();
        home.setNbRoom(nbRoom);

        Person owner = manager.createQuery("Select p from Person p where p.id = :id", Person.class)
                .setParameter("id", idP).getResultList().get(0);

        home.setOwner(owner);

        tx.begin();
        manager.persist(home);
        tx.commit();

        String result =  "Nombre de piece : " + nbRoom + "; Taille : " + size +"; Home ID : " + idP;
        return Response.status(200).entity(result).build();
    }

}