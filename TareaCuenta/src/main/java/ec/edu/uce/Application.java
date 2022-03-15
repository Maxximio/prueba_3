package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.Producto;
import ec.edu.uce.service.IVentaService;
import ec.edu.uce.service.IProductoService;
import ec.edu.uce.service.IGestorService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(Application.class);

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IGestorService gestorService; 
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Producto prod=new Producto();
		prod.setCodigoBarras("1234");
		prod.setNombre("Quesito");
		prod.setCategoria("Lacteos");
		prod.setPrecio(new BigDecimal(5.50));
		prod.setStock(40);
		
		//gestorService.IngresarProductos(prod);
		
		//gestorService.RealizarVenta("1234", 2, "12345", "31234");
		
		
		Producto prod1=new Producto();
		prod1.setCodigoBarras("01234");
		prod1.setNombre("Pan");
		prod1.setCategoria("Panaderia");
		prod1.setPrecio(new BigDecimal(0.50));
		prod1.setStock(20);
		
		
		Producto prod2=new Producto();
		prod2.setCodigoBarras("001234");
		prod2.setNombre("Mantequilla");
		prod2.setCategoria("Lacteos");
		prod2.setPrecio(new BigDecimal(1.50));
		prod2.setStock(10);
		
		//gestorService.IngresarProductos(prod);
		
		//gestorService.RealizarVenta("1234", 2, "12345", "31234");
		
		//gestorService.IngresarProductos(prod1);
		
		gestorService.RealizarVenta("01234", 10, "12345", "123124");
		
		gestorService.ConsultarStock("01234");
		
		
		
	}

}
