package cl.empresa.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cl.empresa.tienda.Producto;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		
		//Creamos un objeto de tipo producto nombrado como celular
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono Usado");
		celular.setPrecio(new BigDecimal("1000"));
		
		//EStablecemos las configuraciones del Entity para usar el recurso en el archivo xml 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		//Establecemos el entity manger pasandole la unidad de persistencia
		EntityManager em = factory.createEntityManager();
		
		//Obtenemos las transacciones y comenzamos a operar
		em.getTransaction().begin();
		
		//Guardamos el objeto celular creando anteriomente
		em.persist(celular);
		
		//Enviamos los valores hacia la base de datos
		em.getTransaction().commit();
		
		//Cerramos la transaccion
		em.close();
		
	}
	
	
	

}
