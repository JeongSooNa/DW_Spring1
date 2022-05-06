package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpTestService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpTestController {
	@Autowired
	private EmpTestService empTestService;
	
	//문제 1. 이름에 L문자가 두 번 이상 포함된 사원 이름, 직업 조회(* L을 두번만 포함하는 사람)
	@GetMapping("/emp/name")
	public List<EmpVO> callEmpListLName(){
		return empTestService.getEmpListLName();
	}
	
	//문제 2. 커미션(comm)이 null('')인 사원의 이름, 커미션 조회
	@GetMapping("/emp/comm")
	public List<EmpVO> callEmpListNullComm(){
		return empTestService.getEmpListNullComm();
	}
	
	//문제 3. 입사일이 '1980-12-17' ~ '1982-01-23'인 사원의 이름, 입사날짜 조회
	@GetMapping("/emp/hiredate")
	public List<EmpVO> callEmpListDate(){
		return empTestService.getEmpListDate();
	}
	@GetMapping("/emp/no/{empNo}")
	public EmpVO callEmp(@PathVariable("empNo") int empNo) {
		return empTestService.getEmp(empNo);
	}
	
	// 문제) job이 "MANAGER"이고 급여가 2000이상인 사원이름 조회
	// 만약 job이 SALESMAN이라면 return null 
	@GetMapping("/emp/job/{job}/sal/{sal}") 
	public List<EmpVO> callEmpListJobSal(@PathVariable("job") String job,@PathVariable("sal") int sal){
		return empTestService.getEmpListJobSal(job, sal);
	}
}
