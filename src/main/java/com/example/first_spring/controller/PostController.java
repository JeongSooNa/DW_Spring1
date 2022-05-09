package com.example.first_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.PostService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class PostController {
	@Autowired
	private PostService postService;
	// emp table에 insert 해보기
	// PostMapping : 중요한 정보를 보내거나 데이터를 많이 보낼 때 post를 사용한다.
	// ex) 회원가입
	// @RequestBody가 parameter로 넘어오는 VO를 대신 new 해줌!
	@PostMapping("/emp")
	public int callEmpSet(@RequestBody EmpVO empVO) {
		System.out.println("---");
		System.out.println("사원 이름은 : "+empVO.getEname());
		System.out.println("사원 번호는 : "+empVO.getEmpno());
		System.out.println("사원 입사는 : "+empVO.getHiredate());
		return postService.setEmp(empVO);
	}
	
	// @DeleteMapping : data 삭제
	@DeleteMapping("/emp/empno/{empno}")
	public int callEmpRemove(@PathVariable("empno") int empno) {
		return postService.getEmpRemoveCount(empno);
	}
	
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO empVO) {
		return postService.getEmpUpdateCount(empVO);
	}
	
}
