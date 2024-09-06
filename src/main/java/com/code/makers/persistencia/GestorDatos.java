package com.code.makers.persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.code.makers.dominio.Articulo;

public class GestorDatos {
	private Map<String, Articulo> repositorioArticulos = cargarArticulos();

	private static Map<String, Articulo> cargarArticulos() {
		Map<String, Articulo> articulosTest = new TreeMap<>();
		articulosTest.put("001", new Articulo("001", "Cuaderno Profesional", "100 hojas, carta", new BigDecimal("3500"),
				new BigDecimal("4000"), 20));
		articulosTest.put("002", new Articulo("002", "Bolígrafo Azul", "Paquete de 12", new BigDecimal("1200"),
		        new BigDecimal("1500"), 50));
		articulosTest.put("003", new Articulo("003", "Marcador Permanente", "Negro", new BigDecimal("800"),
		        new BigDecimal("1000"), 30));
		articulosTest.put("004", new Articulo("004", "Resaltador Amarillo", "Individual", new BigDecimal("500"),
		        new BigDecimal("700"), 25));
		articulosTest.put("005", new Articulo("005", "Calculadora Científica", "Modelo avanzado", new BigDecimal("8500"),
		        new BigDecimal("9500"), 10));
		
		return articulosTest;
	}
	
	public Articulo leerArticulo(String clave) {
		return this.repositorioArticulos.get(clave);
	}
	
	
	
	public int getTotalArticulos() {
		return this.repositorioArticulos.size();
	}
	
	public boolean insertarArticulo(Articulo articulo) {
		if(this.repositorioArticulos.get(articulo.getClave()) == null) {
			this.repositorioArticulos.put(articulo.getClave(), articulo);
			return true;
		}
		return false;
	}
	
	public List<Articulo> obtenerArticulos() {
	    List<Articulo> articulos = new ArrayList<>();
		for (Map.Entry<String, Articulo> entry : this.repositorioArticulos.entrySet()) {
	        String clave = entry.getKey();
	        Articulo articulo = entry.getValue();
	        articulos.add(articulo);
	        System.out.println("Clave: " + clave + ", Artículo: " + articulo.getNombre()
	                + ", Descripción: " + articulo.getDescripcion()
	                + ", costo: " + articulo.getCosto()
	                + ", Venta: " + articulo.getPrecio()
	                + ", Cantidad: " + articulo.getExistencia());
	    }
		return articulos;
	}
	
	public Articulo eliminarArticulo(String clave) {
		Articulo art = new Articulo();
		if(this.repositorioArticulos.get(clave) != null) {
			art = this.repositorioArticulos.get(clave); 
			this.repositorioArticulos.remove(clave);
		}else {
			art =null;
		}
		return art;
	}
	
	public boolean actualizarArticulo(String clave, Articulo articuloActualizado) {
		if(this.repositorioArticulos.get(clave) != null) {
			this.repositorioArticulos.put(clave, articuloActualizado);
			return true;
		}
	    return false; 
	}


	
}
