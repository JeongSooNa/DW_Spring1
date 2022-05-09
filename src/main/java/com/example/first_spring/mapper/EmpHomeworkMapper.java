package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.JoinVO;

@Mapper
public interface EmpHomeworkMapper {
	//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	public List<EmpVO> selectHomework0(int sal);
	//문제 1. emp에서 사수가 없는 사원 조회
	public List<EmpVO> selectHomework1();
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회
	public List<EmpVO> selectHomework2(int year);
	//문제 3. 12월를 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	public List<EmpVO> selectHomework3(int month);
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회
	public EmpVO selectHomework4(String jobName);
	//문제 5. 사원번호 7782를 파라미터로 받고 해당 사원의 모든 정보(부서번호, 부서이름, 부서위치) 조회
	public JoinVO selectHomework5(int empno);
	public EmpVO selectHomework5Join(int empno);
}
