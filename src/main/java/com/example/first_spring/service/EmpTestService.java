package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpTestMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpTestService {
	
	@Autowired
	private EmpTestMapper empTestMapper;
	
	public List<EmpVO> getEmpListLName(){
		return empTestMapper.selectEmpListLName();
	}
	public List<EmpVO> getEmpListNullComm(){
		return empTestMapper.selectEmpListNullComm();
	}
	public List<EmpVO> getEmpListDate(){
		return empTestMapper.selectEmpListDate();
	}
}
