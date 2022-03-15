package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.DetalleVenta;
import ec.edu.uce.modelo.jpa.DetalleVenta;

public interface IDetallesRepo {

	void InsertarDetalle(DetalleVenta retiro);
	
	void ActualizarDetalle(DetalleVenta retiro);
	
	DetalleVenta BuscarPorSubtotal(BigDecimal subtotal);
	
	void BorrarDetalle(BigDecimal subtotal);
}
