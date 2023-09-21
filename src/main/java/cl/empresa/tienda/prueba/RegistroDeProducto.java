package cl.empresa.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cl.empresa.tienda.Producto;
import cl.empresa.tienda.dao.ProductoDAO;
import cl.empresa.tienda.modelo.Categoria;
import cl.empresa.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		
		//Creamos un objeto de tipo producto nombrado como celular
		Producto celular = new Producto("Samsung","telefono usado",new BigDecimal("1000"),Categoria.CELULARES);
		//celular.setNombre("Samsung");
		//celular.setDescripcion("Telefono Usado");
		//celular.setPrecio(new BigDecimal("1000"));
		
		//EStablecemos las configuraciones del Entity para usar el recurso en el archivo xml 
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		//Establecemos el entity manger pasandole la unidad de persistencia
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDAO productoDAO = new ProductoDAO(em);		
		
		//Obtenemos las transacciones y comenzamos a operar
		em.getTransaction().begin();
		
		//Guardamos el objeto celular creando anteriomente
		//em.persist(celular);
		productoDAO.guardar(celular);
		
		
		//Enviamos los valores hacia la base de datos
		em.getTransaction().commit();
		
		//Cerramos la transaccion
		em.close();
		
	}
	
	
	

}
