package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();
		
		try {
			em.getTransaction().begin();
			
			Member4 user;
			user = new Member4("test1@test.com", "홍길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test2@test.com", "이순신", LocalDate.now());
			em.persist(user);
			user = new Member4("test3@test.com", "감강찬", LocalDate.now());
			em.persist(user);
			user = new Member4("test4@test.com", "더조은", LocalDate.now());
			em.persist(user);
			user = new Member4("test5@test.com", "을지문덕", LocalDate.now());
			em.persist(user);
			user = new Member4("test6@test.com", "최영", LocalDate.now());
			em.persist(user);
			user = new Member4("test7@test.com", "이한나", LocalDate.now());
			em.persist(user);
			
			em.getTransaction().commit();
			System.out.println("가입 요청 처리했습니다");
			
		} catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
