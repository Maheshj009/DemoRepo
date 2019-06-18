package com.scp.mvc.dao;

import java.util.List;

import com.scp.mvc.entity.EmpEntity;

public interface EmpDao {
	

	public boolean insertEmployee(EmpEntity entity);
	public EmpEntity fetchEmployee(int empId);
	public List<EmpEntity> fetchAllEmployees();
	public List<EmpEntity> removeEmployee(int empId);
	public EmpEntity modifyEmployee(EmpEntity entity);
		

	
}
