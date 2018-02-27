package jpa;

import domaine.Heater;
import domaine.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {



    Person p = new Person();
    Heater h1 = new Heater();

			p.setName("martin");
			manager.persist(p);




		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
//		String s = "SELECT e FROM domaine.Person as e where e.name=:name";

//		Query q = manager.createQuery(s,domaine.Person.class);
//		q.setParameter("name", "martin");
//		List<domaine.Person> res = q.getResultList();

//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());

		manager.close();
		factory.close();
	}

}
