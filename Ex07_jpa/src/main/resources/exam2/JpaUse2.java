package exam2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUse2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();
		
		try {
			ts.begin();
			Member2 user = new Member2("아무개", "1234");
			em.persist(user);
			ts.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
