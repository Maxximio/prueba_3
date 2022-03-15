package ec.edu.uce.service;

import java.time.LocalDateTime;

import ec.edu.uce.modelo.jpa.Producto;

public interface IGestorService {

	void IngresarProductos(Producto prod);
	
	void RealizarVenta(String codigo,Integer cantidad,String cedulaCliente, String numeroVenta);
	
	void ConsultarStock(String codigoBarra);
	
	void ReporteVentas(LocalDateTime fecha, String categoria, Integer cantidadMin);
}
