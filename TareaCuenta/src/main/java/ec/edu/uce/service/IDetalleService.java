package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.DetalleVenta;

public interface IDetalleService {

	void InsertarDetalleService(DetalleVenta retiro);
	
	void ActualizarDetallesService(DetalleVenta retiro);
	
	DetalleVenta BuscarPorSubtotalService(BigDecimal subtotal);
	
	void BorrarDetalleService(BigDecimal subtotal);
}
