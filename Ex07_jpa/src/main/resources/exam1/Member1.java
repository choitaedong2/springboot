package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="JpaMember1")
public class Member1 {
	@Id
	@GeneratedValue		// 시퀀스가 자동 생성
	private Long id; 	// int : 기본값 0
						// Long : null
	private String username;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date date1;
	@Column(name="create_date")
	private LocalDate createDate;


	
	// 기본 생성자
	// 자동으로 호출되므로 빈 생성자는 반드시 있어야 함
	public Member1() {
	}


	// username, createDate를 사용하고자 할 시
	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}

/* @Entity : 해당 클래스가 JPA의 엔티티임을 의미(테이블 매핑된 JPA)
 * @Table(name="이름") : 실제 db에 생성될 테이블 이름
 * 						만약, 이 어노테이션이 없으면 클래스의 이름이 테이블 이름 됨
 * @Id : primary key
 * @GenerateValue : sequence를 이용함
 * @Column(name="이름") : 실제 테이블의 속성명을 이 이름으로 함
 */