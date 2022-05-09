package com.example.first_spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.EmpVO;

@Mapper
public interface PostMapper {
//	public List<EmpVO> 
	
	public int insertEmp(EmpVO empVO); // insert
	public int deleteEmp(int empno); // delete
	public int updateEmp(EmpVO empVO); //update
}
