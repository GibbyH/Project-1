package com.hksoftworks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hksoftworks.users.Users;
import com.hksoftworks.util.HibernateUtil;

public class UserDAO {

	public void saveUser(Users user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(user);
		} catch(Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public void updateUser(Users user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(user);
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public void deleteUser(Users user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.delete(user);
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	
}
