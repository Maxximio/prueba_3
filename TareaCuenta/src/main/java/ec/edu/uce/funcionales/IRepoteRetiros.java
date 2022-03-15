package ec.edu.uce.funcionales;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.modelo.jpa.DetalleVenta;

@FunctionalInterface
public interface IRepoteRetiros {

	List<DetalleVenta> filtro(BigDecimal montoRetiro);
	
}
