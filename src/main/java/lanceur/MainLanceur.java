package lanceur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Event;
import model.Guest;

public class MainLanceur {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("invitationevent");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			// PERSIST

//			Event e1 = new Event("PGW", "Porte de Versailles", "26 au 30 oct 2018");
//			Event e2 = new Event("RETROMOBILE", "Porte de Versailles", "6 au 9 fev 2019");
//
//			Guest g1 = new Guest("Madjid");
//			Guest g2 = new Guest("Diea");
//			Guest g3 = new Guest("Marlon");
//			Guest g4 = new Guest("Mohamed");
//			Guest g5 = new Guest("Badr");
//			Guest g6 = new Guest("Fabien");
//
//			g1.addEvent(e1);
//			g2.addEvent(e1);
//			g3.addEvent(e2);
//
//			e1.getGuests().add(g4);
//			e2.getGuests().add(g5);
//			e2.getGuests().add(g6);
//
//			em.persist(e1);
//			em.persist(e2);

			//REMOVE
			
			
			Event e3 = em.find(Event.class, 1L);
			
			
			e3.getGuests().remove(em.find(Guest.class, 3L));
			
			
			
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}
