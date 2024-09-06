package com.code.makers.dominio;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Articulo {
	private String clave;
	private String nombre;
	private String descripcion;
	private BigDecimal costo;
	private BigDecimal precio;
	private int existencia;
	
	public Articulo() {
		super();
	}
	
	public Articulo(String clave, String nombre, String descripcion, BigDecimal costo, BigDecimal precio,
			int existencia) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.precio = precio;
		this.existencia = existencia;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	@Override
	public String toString() {
		return "Articulo [clave=" + clave + ", nombre=" + nombre + ", descripcion=" + descripcion + ", costo=" + costo
				+ ", precio=" + precio + ", existencia=" + existencia + "]";
	}
	
}
