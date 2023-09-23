package cl.empresa.tienda.dao;

import java.util.List;

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
	
	public Producto consultaPorId(Long id) {
		return this.em.find(Producto.class, id);
	}

	public List<Producto> consultarTodos(){
		//La query que armamos es de acuerdo al nombre del objeto
		//Cuidado con la mayuscula del primer caracter del objeto
		String jpql = "SELECT P FROM Producto AS P";
		return this.em.createQuery(jpql,Producto.class).getResultList();
	}
	
	
}
