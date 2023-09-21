package cl.empresa.tienda.dao;

import javax.persistence.EntityManager;

import cl.empresa.tienda.Producto;

public class ProductoDAO {
	
	private EntityManager em;
	
	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	

}
