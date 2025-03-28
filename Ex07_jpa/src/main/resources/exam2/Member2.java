package exam2;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember2")
public class Member2 {
	@Id
	
	@SequenceGenerator (
		name ="mySequence", 	// generateValue (generator="")에 들어가는 name과 동일하게 설정 
		sequenceName = "JPAMamber2_seq", // 실제로 DB에 생성되는 시퀀스 이름
		initialValue = 1, 		// 초기값
		allocationSize = 1		// 1씩 증가
	)
	
	// 50씩 증가하기 때문에 1씩 증가를 원할시 위와 같이 시퀀스 설정 변경
	@GeneratedValue(generator = "mySequence") // 시퀀스 별칭 
	private Long id;
	
	@Access(AccessType.FIELD)  	// 필드를 통해서 데이터 접근(기본값)
	private String username;
	
	@Access(AccessType.PROPERTY) 	// get/set 메소드를 통해 데이터에 접근
	private String password;
	
	@Transient
	private long timestamp1;		// 어노테이션을 이용하여 영속대상(db)에서 제외
	transient private long timestamp2; 	// 키워드를 이용하여 영속대상(db)에서 제외
	
	public Member2(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
