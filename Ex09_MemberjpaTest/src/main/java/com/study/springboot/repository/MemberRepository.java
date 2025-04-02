package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;
import org.springframework.data.domain.Sort;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	/*
	findBy 뒤에 컬럼명을 붙여주면 된다.
	컬럼의 조건이 여러개 일 때 : And, Or을 붙여주면됨
	예제) 이름이 더조은 이거나 이메일이 test1@test.com
 		=> findByNameOrEmail(String name, String email)
 	예제) 이름이 더조은 이면서 이메일이 test1@test.com
 		=> findByNameAndEmail(String name, String email)
	 */
	Optional<Member> findByName(String name);
	Optional<Member> findByEmail(String email);
	
	// 다양한 확장 가능
	List<Member> findByNameLike(String name2);
//	List<Member> selectByNameLikeOrderByName(String name2);
	List<Member> selectByNameLikeOrderByNameDesc(String name2);
	List<Member> findByNameLike(String name2, Sort sort);
	
}
