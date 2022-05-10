package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;

@Mapper
public interface PostMapper {
//	public List<EmpVO> 
	
	public int insertEmp(EmpVO empVO); // insert
	public int deleteEmp(int empno); // delete
	public int updateEmp(EmpVO empVO); //update
	
	public int updateCommEmp(@Param("empno") int empno, @Param("comm") int comm);
	public List<EmpVO> selectCommEmp(@Param("job") String job,@Param("sal") int sal);
	
	//1
	public int insertDeptEmp(EmpVO empVO);
	public List<EmpVO> selectAllEmp();
	public List<DeptVO> selectAllDept();
	
	//2
	public int deleteSalEmp(int empno);
	public EmpVO selectEmp(int empno);
	
	//
	public List<EmpVO> selectEmpNameCount(String search);
}
