package com.gicu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gicu.dao.PendientesDao;
import com.gicu.model.Pendientes;
@Configurable
@Component
@Repository
public class PendientesDaoImpl implements PendientesDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	 public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPendiente(Pendientes pendientes) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		sessionFactory.getCurrentSession().save(pendientes);
		tx.commit();
		session.close();

	}

	@Override
	public void updatePendiente(Pendientes pendientes) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		sessionFactory.getCurrentSession().update(pendientes);
		tx.commit();
		session.close();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pendientes> listPendiente() {
		Session session = sessionFactory.openSession();
		List<Pendientes> list = session.createQuery("from Pendientes").list();//es HQL no sql-. investiga como funciona
		session.close();
		return list;
	}

	@Override
	public Pendientes getPendientesById(int pendienteId) {
		Session session = sessionFactory.openSession();
		List<Pendientes> list = session.createQuery("from Pendientes b where b.id = :pendienteId")
				.setParameter("pendienteId", pendienteId)
				.list();
		return list.size()>0 ? (Pendientes)list.get(0):null;
	}

	@Override
	public void removePendiente(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.delete((Pendientes) session.load(Pendientes.class,id));
		tx.commit();
		session.close();

	}

}
