package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Venta;
import ec.edu.uce.modelo.jpa.Producto;
import ec.edu.uce.modelo.jpa.DetalleVenta;

@Service
public class GestorServiceImpl implements IGestorService{

	private static final Logger LOG= LogManager.getLogger(GestorServiceImpl.class);
	
	@Autowired
	private IVentaService ventaServ;
	
	@Autowired
	private IProductoService prodService;
	
	@Autowired
	private IDetalleService detallService;
	
	
	@Override
	//@Transactional(value = TxType.REQUIRES_NEW)// no es transaccional para que agrege aunque no se encuentre la entidad
	public void IngresarProductos(Producto prod) {
		
		String codigo=prod.getCodigoBarras();
		Integer stock=prod.getStock();
		
		
		//try {
			
			Producto producto1=this.prodService.BuscarPorCodigoService(codigo);//hacer por funcionales si sobra tiempo
			
			if(producto1.getCodigoBarras()==codigo) {
				
				producto1.setStock(stock+producto1.getStock());
				prodService.ActualizarProductoService(producto1);
			}else {
				
			
			
		//}catch (Exception e) {
			
			prodService.InsertarProductoService(prod);
			LOG.info("Se ha ingresado correctamente");
			}
		//}
		
		
	}



	@Override
	@Transactional
	public void RealizarVenta(String codigo, Integer cantidad, String cedulaCliente, String numeroVenta) {
		
		Venta venta=new Venta();//////////Asignar tambien los detalles de la venta(hecho)
		DetalleVenta detalles=new DetalleVenta();
		
		Producto producto1=this.prodService.BuscarPorCodigoService(codigo);//hacer por funcionales si sobra tiempo
		if(producto1.getCategoria()!=null) {//comprobar que el producto existe (hecho)
			if(cantidad > producto1.getStock()) {
				LOG.info("No hay Stock suficiente para realizar la venta");
			}else {
				producto1.setStock(producto1.getStock()-cantidad);
				prodService.ActualizarProductoService(producto1);
				
				venta.setCedulaCliente(cedulaCliente);
				venta.setFecha(LocalDateTime.now());
				venta.setNumero(numeroVenta);
				venta.setValor(producto1.getPrecio());
				
				venta.setProducto(producto1);
				
				ventaServ.InsertarVentaService(venta);
				
				detalles.setCantidad(cantidad);
				detalles.setPrecioU(producto1.getPrecio());
				
				BigDecimal subtotalDetalle= producto1.getPrecio().multiply(BigDecimal.valueOf(cantidad));
				detalles.setSubtotal(subtotalDetalle);
				
				detalles.setProducto(producto1);
				detalles.setVenta(venta);
				
				detallService.InsertarDetalleService(detalles);
				
				LOG.info("Venta terminada");
			}
		}else {
			LOG.info("El producto no existe, revise el codigo de barras");
			LOG.info("O ingrese el producto al sistema");
		}
		
	}



	@Override
	public void ConsultarStock(String codigoBarra) {
		
		Producto producto1=this.prodService.BuscarPorCodigoService(codigoBarra);//hacer por funcionales si sobra tiempo
		
		
		if(producto1.getNombre()!=null){
			LOG.info("-------------Generando Reporte-------------");
			
			LOG.info("Codigo de Barras: "+producto1.getCodigoBarras()+" Nombre del Producto: "+producto1.getNombre()+" Stock: "+producto1.getStock());
		}else {
			LOG.info("El producto no existe, revise el codigo de barras");
			LOG.info("O ingrese el producto al sistema");
		}
		
	}



	@Override
	public void ReporteVentas(LocalDateTime fecha, String categoria, Integer cantidadMin) {
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
