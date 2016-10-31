package com.gicu.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gicu.dao.PendientesDao;
import com.gicu.model.Pendientes;
import com.gicu.service.PendientesService;

@Service
@Component
@Configurable
public class PendientesServiceImpl implements PendientesService {
	
	@Autowired
	private PendientesDao pendientesDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Transactional
	public void addPendiente(Pendientes pendientes) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(pendientes);
		tx.commit();
		session.close();
		
	}

	@Transactional
	public void updatePendiente(Pendientes pendientes) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.update(pendientes);
		tx.commit();
		session.close();
		
	}

	@Transactional
	public List<Pendientes> listPendiente() {
		return pendientesDao.listPendiente();
	}

	@Transactional
	public Pendientes getPendientesById(int pendienteId) {
		return pendientesDao.getPendientesById(pendienteId);
	}

	@Transactional
	public void removePendiente(int id) {
		pendientesDao.removePendiente(id);
		
	}
	
}
