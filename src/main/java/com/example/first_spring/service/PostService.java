package com.example.first_spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.PostMapper;
import com.example.first_spring.vo.DeptVO;
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
//		UserVO user = null; // instance화 하지 않아 null이라 error
//		String name = user.getName();
//		System.out.println(name);
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
	//1
	public int setSalEmp(EmpVO empVO) {
		// Business Logic에서 해결해도 되나
		// Mybatis Query에서 해결하는 것이 바람직.
		List<EmpVO> listEmp = postMapper.selectAllEmp();
		List<DeptVO> listDept = postMapper.selectAllDept();
		int[] listDeptDeptno = new int[listDept.size()]; 
		int nonDeptno = 0;
		for(EmpVO vo : listEmp) {
			for(int i=0;i<listDept.size();i++) {
				if(vo.getDeptno()==listDept.get(i).getDeptno()) {
					listDeptDeptno[i]++;
				}
			}
		}
		for(int i=0;i<listDept.size();i++) {
			if(listDeptDeptno[i]==0) nonDeptno = listDept.get(i).getDeptno();
		}
		empVO.setDeptno(nonDeptno);
		int rows = postMapper.insertDeptEmp(empVO);
		return rows;
	}
	//2
	public int getEmpSalRemoveCount(int empno) {
		EmpVO vo = postMapper.selectEmp(empno);
		if(vo.getSal()<3000) return 0;
		int rows = postMapper.deleteSalEmp(empno);
		return rows;
	}
	
	//
	public int getEmpNameCount(String search) {
		List<EmpVO> list = postMapper.selectEmpNameCount(search);
		if(list != null) return list.size();
		return 0;
	}
	
	// if
	public List<EmpVO> getEmpIsMgrList(String isMgr){
		return postMapper.selectEmpMgr(isMgr);
	}
	// 문제1.
	public int getEmpEmpnoUpdate(int empno,EmpVO empVO) {
		return postMapper.updateEmpEmpno(empno,empVO);
	}
	// 문제2.
	public int getEmpEmpnoCommUpdate(int empno, int addSal) {
		EmpVO vo = postMapper.selectEmp(empno);
		// int형은 null을 받지 못하므로 integer로 바꿔서 null 여부 check 가능
		if(vo.getComm() == 0) {
			return postMapper.updateEmpEmpnoComm(empno, addSal);
		}
		return 0;
	}
	
	// Map
	public List<Map<String, Object>> getEmpMapList(){
		return postMapper.selectEmpMapList();
	}
	
	//
	public int getApiUpdate(int empno, EmpVO empVO) {
		empVO.setEmpno(empno);
		return postMapper.updateApi(empVO);
	}
}
