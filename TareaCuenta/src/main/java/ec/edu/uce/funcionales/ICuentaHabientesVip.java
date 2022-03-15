package ec.edu.uce.funcionales;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.modelo.jpa.CuentaHabientesVIP;

@FunctionalInterface
public interface ICuentaHabientesVip {

	List<CuentaHabientesVIP> filtroSaldo(BigDecimal saldo);
	
}
