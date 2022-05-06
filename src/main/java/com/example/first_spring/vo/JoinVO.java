package com.example.first_spring.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class JoinVO {
	private int empno;
	private String ename;
	private String job;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private int deptno;
	private String dname;
	private String loc;
}
