package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.EmpVO;

@Mapper
public interface EmpTestMapper {
	/**
	 * @return
	 * comment : 문제 1. 이름에 L문자가 두 번 이상 포함된 사원 이름, 직업 조회(* L을 두번만 포함하는 사람)
	 */
	public List<EmpVO> selectEmpListLName();
	
	/**
	 * @return
	 * comment : 문제 2. 커미션(comm)이 null('')인 사원의 이름, 커미션 조회
	 */
	public List<EmpVO> selectEmpListNullComm();
	
	/**
	 * @return
	 * comment : 문제 3. 입사일이 '1980-12-17' ~ '1982-01-23'인 사원의 이름, 입사날짜 조회
	 */
	public List<EmpVO> selectEmpListDate();
}
