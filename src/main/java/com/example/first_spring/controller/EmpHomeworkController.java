package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpHomeworkService;
import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpHomeworkController {
	@Autowired
	private EmpHomeworkService empHomeworkService;
	
	//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callHomework0(@PathVariable("sal") int sal){
		return empHomeworkService.getHomework0(sal);
	}
	//문제 1. emp에서 사수가 없는 사원 조회
	@GetMapping("/emp/mgr")
	public List<EmpVO> callHomework1(){
		return empHomeworkService.getHomework1();
	}
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callHomework2(@PathVariable("year") int year){
		return empHomeworkService.getHomework2(year);
	}
	//문제 3. 12월를 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	@GetMapping("/emp/hiredate/month/{month}")
	public EmpVO callHomework3(@PathVariable("month") int month){
		return empHomeworkService.getHomework3(month);
	}
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	@GetMapping("/emp/job/{jobName}")
	public EmpVO callHomework4(@PathVariable("jobName") String jobName){
		return empHomeworkService.getHomework4(jobName);
	}
	//문제 5. 사원번호 7782를 파라미터로 받고 해당 사원의 모든 정보(부서번호, 부서이름, 부서위치) 조회
	@GetMapping("/emp/empno/{empno}")
	public DeptVO callHomework5(@PathVariable("empno") int empno){
		return empHomeworkService.getHomework5(empno);
	}
}
