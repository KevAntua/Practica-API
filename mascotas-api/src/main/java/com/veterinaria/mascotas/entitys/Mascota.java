package com.veterinaria.mascotas.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Objeto Plano (propiedades y metodos de acceso)

@Entity //Indica que es una entidad
@Table(name="mascotas")
public class Mascota {
    
	@Id
	@Column(name="codigoRegistro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoRegistro;
	
	@Column(name="nombreMascota", nullable=false, length=20)
	private String nombreMascota;
	
	@Column(name="tipoMascota", nullable=false, length=20)
	private String tipoMascota;
	
	@Column(name="edadMascota")
	private int edadMascota;
	
	@Column(name="nombreDueño", nullable=false, length=20)
	private String nombreDueño;
	
	public int getCodigoRegistro() {
		return codigoRegistro;
	}
	public void setCodigoRegistro(int codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getTipoMascota() {
		return tipoMascota;
	}
	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}
	public int getEdadMascota() {
		return edadMascota;
	}
	public void setEdadMascota(int edadMascota) {
		this.edadMascota = edadMascota;
	}
	public String getNombreDueño() {
		return nombreDueño;
	}
	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}
	
}
