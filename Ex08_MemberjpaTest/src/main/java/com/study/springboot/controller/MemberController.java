package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String name, Model model) {
		/*
		Member member2 = new Member();
		member2.setUsername(name);
		member2.setCreateDate(LocalDate.now());
		*/
		Member member = Member.builder()
							  .username(name)
							  .createDate(LocalDate.now())
							  .build();
		
		Member result = memberService.insert(member);
		
		model.addAttribute("member", result);
		return "insert";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		/*
		 * Optional<T> : NullpointerException 발생을 방지하기 위해
		 				 기존의 반환 값 타입 T에 Optional<T>를 wrapping하여,
		 				 null 대신 Optional안에 빈 타입 객체를 돌려주는 기법
		 	ex) Member member = memberRepository.findById("user01"); => 없는 아이디
		 		member.getUserName(); => NullpointerException 발생
		 		
		 		값을 받아오기 위해서는 .get() 메소드 사용 필요
		 *  
		 */
		Optional<Member> result = memberService.select(id);
		if(result.isPresent()) { // isEmpty() 사용과 비슷, 값이 들어있으면 True 없으면 False
			model.addAttribute("member", result.get());
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) { // 전체 조회를 담을 객체 model 정의
		List<Member> result = memberService.selectAll(); // list 형태로 담아오기
		model.addAttribute("members", result); // 받아온 멤버All 값을 model에 넣는 과정 ("키값 - 임의 키값", 받은 객체 model )
		return "selectAll";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.deleteById(id);
		return "selectAll";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Long id, @RequestParam("username") String name, Model model) {
		Member member = Member(isid);
		
		Member result = memberService.insert(member);
		
		Optional<Member> result = memberService.update(id, name);
		model.addAttribute("member", result.get());
		return "select";
	}
}
