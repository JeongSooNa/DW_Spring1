package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpHomeworkMapper;
import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.JoinVO;

@Service
public class EmpHomeworkService {
	@Autowired
	private EmpHomeworkMapper empHomeworkMapper;
	
	public List<EmpVO> getHomework0(int sal){
		return empHomeworkMapper.selectHomework0(sal);
	}
	public List<EmpVO> getHomework1(){
		return empHomeworkMapper.selectHomework1();
	}
	public List<EmpVO> getHomework2(int year){
		return empHomeworkMapper.selectHomework2(year);
	}
	public EmpVO getHomework3(int month){
		return empHomeworkMapper.selectHomework3(month);
	}
	public EmpVO getHomework4(String jobName){
		return empHomeworkMapper.selectHomework4(jobName);
	}
	public JoinVO getHomework5(int empno){
		return empHomeworkMapper.selectHomework5(empno);
	}
}
