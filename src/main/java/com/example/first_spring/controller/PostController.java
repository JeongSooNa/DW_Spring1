package com.example.first_spring.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// job이 MANAGER고 sal이 2500이상 받는 사원
	// comm 200으로 update
	// ename, job, comm 조회
	// Logic 구현은 Service에서
	@GetMapping("/emp/job/{job}/sal/{sal}/update")
	public List<EmpVO> callEmpJobSalUpdate(@PathVariable("job") String job, @PathVariable("sal") int sal) {
		return postService.getEmpJobSalUpdate(job,sal);
	}
	
	// QueryString 으로 GetMapping
	// 검색할 때 많이 사용
	// tier?region=kr
	@GetMapping("/tier")
	public String callTier(@RequestParam("region") String region, @RequestParam("name") String name) {
		return region+", "+name;
	}
	// 게시판 (현재 보고있는 페이지 & 한 페이지에 보여지는 row)
	// board?page=1&pageSize=10&writer=나정수
	@GetMapping("/board")
	public int callBoard(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize,@RequestParam("writer") String writer) {
		System.out.println("현재 페이지는 : "+page);
		System.out.println("한 페이지에 보여주는 row 수는 : "+pageSize);
		System.out.println("작성자는 : "+writer);
		return 0;
	}
	
	// 1. emp에 없는 부서번호를 찾아서 사원 insert 될 때 해당 부서번호로 insert하기 
	@PostMapping("/emp/dept")
	public int callNonDeptnoEmpSet(@RequestBody EmpVO empVO) {
		System.out.println("---");
		System.out.println("사원 이름은 : "+empVO.getEname());
		System.out.println("사원 번호는 : "+empVO.getEmpno());
		System.out.println("사원 입사는 : "+empVO.getHiredate());
		System.out.println("사원 급여는 : "+empVO.getSal());
		return postService.setSalEmp(empVO);
	}
	// 2. 급여가 3000 이상인 사원만 삭제
	// 급여가 3000 안되는 사람들은 return 0
	@DeleteMapping("/emp/empno/{empno}/sal")
	public int callEmpSalRemove(@PathVariable("empno") int empno) {
		return postService.getEmpSalRemoveCount(empno);
	}
}
