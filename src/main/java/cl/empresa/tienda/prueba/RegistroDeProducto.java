package cl.empresa.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cl.empresa.tienda.Producto;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono Usado");
		celular.setPrecio(new BigDecimal("1000"));
		
		//EStablecemos las configuraciones del Entity para usar el recurso en el archivo xml 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda-mysql");
		//Establecemos el entity manger pasandole la unidad de persistencia
		EntityManager em =  factory.createEntityManager();
		
		//Guardamos el objeto celular creando anteriomente
		em.persist(celular);
		
	}
	
	
	

}
