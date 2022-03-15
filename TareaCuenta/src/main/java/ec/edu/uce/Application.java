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

import ec.edu.uce.modelo.jpa.Venta;
import ec.edu.uce.modelo.jpa.Producto;
import ec.edu.uce.modelo.jpa.CuentaHabientesVIP;
import ec.edu.uce.repository.jpa.IProductoRepo;
import ec.edu.uce.service.IVentaService;
import ec.edu.uce.service.IProductoService;
import ec.edu.uce.service.IGestorService;
import ec.edu.uce.service.IDetalleService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(Application.class);

	@Autowired
	private IProductoService habienteService;
	
	@Autowired
	private IVentaService cuentaService;
	
	@Autowired
	private IGestorService gestorService; 
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Producto duenio=new Producto();
		duenio.setNombre("Miguel");
		duenio.setApellido("Valverde");
		duenio.setCedula("3452343");
		
		Venta cuenta=new Venta();
		cuenta.setNumero("235325");
		cuenta.setSaldo(new BigDecimal(400.00));
		cuenta.setTipo("corriente");
		cuenta.setCuenta_habiente(duenio);
		
		//habienteService.InsertarCuentaHabienteService(duenio);
		//cuentaService.InsertarCuentaBancariaService(cuenta);
		
		
		gestorService.ConsultarCuentas("3452343");
		
		//gestorService.RetirarDinero("235325", new BigDecimal(20.00));
		
		gestorService.ConsultarSaldo("235325");
		
		//gestorService.RetirarDinero("235325", new BigDecimal(30.00));
		
		gestorService.ConsultarSaldo("235325");
		
		//habienteService.BorrarCuentaHabienteService("171242353");
		//cuentaService.BorrarCuentaBancariaService("124567");
		
		List<CuentaHabientesVIP> cuentaHabientesVIPs=this.
				gestorService.reporteHabienteVip(new BigDecimal(30.00));
		
		cuentaHabientesVIPs.forEach((c) -> System.out.println(c.toString()));
		
	}

}
