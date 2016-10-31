package com.gicu.service;

import java.util.List;

import com.gicu.model.Pendientes;

public interface Service {
	public void addPendiente(Pendientes pendientes);
	public void updatePendiente(Pendientes pendientes);
	public List<Pendientes> listPendiente();
	public Pendientes getPendientesById(int pendienteId);
	public void removePendiente(int id);
	public List<Pendientes> findAll();

}
