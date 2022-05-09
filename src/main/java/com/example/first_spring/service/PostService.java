package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.PostMapper;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.UserVO;

@Service
public class PostService {
	@Autowired
	private PostMapper postMapper;
	
	// INSERT
	@Transactional(rollbackFor = {Exception.class})
	public int setEmp(EmpVO vo) {
		int rows = postMapper.insertEmp(vo); //몇 행 insert 되었는지 return
		return rows;
	}
	
	// DELETE
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empno) {
		int rows = postMapper.deleteEmp(empno);
		return rows;
	}
	
	// business logic때문에 error가 날 때 잡는방법!
	// 짱 고급 Annotation
	// error가 뜰 경우 이전 시점의 commit으로 돌아가기
	// INSERT
	@Transactional(rollbackFor = {Exception.class}) // 짱
//	@Transactional(rollbackFor = {NullPointerException.class}) // null관련 error catch
	public int getEmpUpdateCount(EmpVO vo) {
		int rows = postMapper.updateEmp(vo);
		
		// error만들어서 경험해보자!
		UserVO user = null; // instance화 하지 않아 null이라 error
		String name = user.getName();
		System.out.println(name);
		// 서버에서는 error가 뜨는데 DB는 update가 된다!
		
		return rows;
	}
	
	public List<EmpVO> getEmpJobSalUpdate(String job, int sal){
		List<EmpVO> result = postMapper.selectCommEmp(job,sal);
		int comm = 500;
		int rows = 0;
		for(int i=0;i<result.size();i++) {
			EmpVO vo = new EmpVO();
			vo.setEmpno(result.get(i).getEmpno());
			rows += postMapper.updateCommEmp(vo.getEmpno(), comm);
		}
		return result;
	}
}
