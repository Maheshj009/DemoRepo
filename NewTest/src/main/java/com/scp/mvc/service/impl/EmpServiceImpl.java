package com.scp.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.mvc.beans.Employee;
import com.scp.mvc.dao.impl.EmpDaoImpl;
import com.scp.mvc.entity.EmpEntity;
import com.scp.mvc.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDaoImpl empDaoImpl;
	
	

		public EmpDaoImpl getEmpDaoImpl() {
		return empDaoImpl;
	}

	public void setEmpDaoImpl(EmpDaoImpl empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}

		public boolean addEmployee(Employee bean) {
			if(validateBeanInfo(bean)) {
				empDaoImpl.insertEmployee(beanToEntity(bean));
			}
			return false;
		}

		private EmpEntity beanToEntity(Employee bean) {
			if(bean!=null) {
				String address[] = bean.getEmpAddress().split(" ");
				return new EmpEntity(bean.getEmpId(),bean.getEmpName(),bean.getEmpAge(),bean.getEmpSalary(),address[0],address[1]);
			}
			return null;
		}

		private boolean validateBeanInfo(Employee bean) {
			if(bean!=null) {
				if(bean.getEmpName()!=null && bean.getEmpName().length()>=5) {
					System.out.println("name length is matching....");
					String address [] = bean.getEmpAddress().split(" ");
					if (address.length==2)
							return true;
					else{
						System.out.println("addresses not as per business requirement");
					}
				}
			}
			return false;
		}

		public Employee getEmployee(int empId) {
			return entityToBean(empDaoImpl.fetchEmployee(empId));
		}

		public List<Employee> getAllEmployees() {
			return entitiesToBeans(empDaoImpl.fetchAllEmployees());
		}

		private List<Employee> entitiesToBeans(List<EmpEntity> entities) {
			 List<Employee>  empBeans = new ArrayList<Employee>();
			 for (EmpEntity entity : entities) {
				 empBeans.add(entityToBean(entity));
			}
			return empBeans;
		}

		private Employee entityToBean(EmpEntity entity) {
			Employee bean = new Employee();
			bean.setEmpAddress(entity.getLine1()+" "+entity.getLine2());
			bean.setEmpName(entity.getEmpName());
			bean.setEmpId(entity.getEmpId());
			bean.setEmpAge(entity.getEmpAge());
			bean.setEmpSalary(entity.getEmpSalary());
			return bean;
		}

		public List<Employee> deleteEmployee(int empId) {
			EmpEntity entity = empDaoImpl.fetchEmployee(empId);
			if(entity!=null) {
				empDaoImpl.removeEmployee(empId);
			}
			return getAllEmployees();
		}

		public Employee updateEmployee(Employee bean) {
			return entityToBean(empDaoImpl.modifyEmployee(beanToEntity(bean)));
		}

		
		

}
