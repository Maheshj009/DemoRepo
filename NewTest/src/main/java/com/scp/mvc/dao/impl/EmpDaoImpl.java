package com.scp.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scp.mvc.dao.EmpDao;
import com.scp.mvc.entity.EmpEntity;


@Repository
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	@Qualifier("sf")
	SessionFactory sessionfactory;
	
	

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public boolean insertEmployee(EmpEntity entity) {
		Session session = null;
		Transaction tr = null;
		
		try {
			session  =  sessionfactory.openSession();
			tr=session.beginTransaction();
			Integer primaryKey = (Integer) session.save(entity);
			return primaryKey>0;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("problem in insert");
		}finally {
			closeResources(session,tr);
		}
		
		return false;
	}

	private void closeResources(Session session, Transaction tr) {
		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
		
	}

	public EmpEntity fetchEmployee(int empId) {
		return sessionfactory.openSession().get(EmpEntity.class,empId);
	}

	public List<EmpEntity> fetchAllEmployees() {
		return sessionfactory.openSession().createCriteria(EmpEntity.class).list();
	}

	public List<EmpEntity> removeEmployee(int empId) {
		Session session = null;
		Transaction tr = null;
		try {
			System.out.println("inside removeemployee");
			session  =  sessionfactory.openSession();
			tr=session.beginTransaction();
			session.delete(session.get(EmpEntity.class,empId));
			System.out.println("object delete successfully...>!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("problem in insert");
		}finally {
			closeResources(session,tr);
		}
		
		return fetchAllEmployees();
	
		
		
	}

	public EmpEntity modifyEmployee(EmpEntity entity) {
		EmpEntity dbEntity = fetchEmployee(entity.getEmpId());
		dbEntity.setEmpAge(entity.getEmpAge());
		dbEntity.setEmpName(entity.getEmpName());
		dbEntity.setEmpSalary(entity.getEmpSalary());
		dbEntity.setLine1(entity.getLine1());
		dbEntity.setLine2(entity.getLine2());
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(dbEntity);
		closeResources(session, tr);
		return fetchEmployee(entity.getEmpId());
	}

	
	
}
