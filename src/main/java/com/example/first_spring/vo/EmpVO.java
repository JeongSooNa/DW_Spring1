package com.example.first_spring.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private int comm;
	private int mgr;
	private int deptno;
	private DeptVO deptvo;

	public EmpVO() {
		
	}
}
