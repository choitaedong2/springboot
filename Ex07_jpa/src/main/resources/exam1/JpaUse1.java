package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUse1 {

	public static void main(String[] args) {
		// Persistence 사용시 META-INF 폴더를 반드시 사용해야함
		// META-INF/persistence.xml을 우선 확인하기 때문
		
		// JPA 환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// EntityManager (데이터베이스와 직접적으로 상호작용할 메소드)
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		
		try {
			ts.begin(); // 트랜잭션 시작
			
			// user를 만들면서 이름을 입력
			Member1 user = new Member1("홍길동", LocalDate.now());
			
			// .persist() 영속성으로 객체에 데이터 입력(메모리에 insert 해주는 부분)
			em.persist(user);
			
			// db에 create table & insert
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
