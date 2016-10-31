package com.gicu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="pendientes", schema="sql9142423")
public class Pendientes {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private int id;
	
	@Column (name="pendiente")
	private String pendiente;
	
	@Column (name="descripcion")
	private String descripcion;
	
	public Pendientes(){
		
	}
	
	public Pendientes(int id, String pendiente, String descripcion){
		super();
		this.id = id;
		this.pendiente = pendiente;
		this.descripcion = descripcion;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPendiente() {
		return pendiente;
	}

	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
