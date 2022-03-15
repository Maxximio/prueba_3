package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Venta;

public interface IVentaRepo {

	void InsertarVenta(Venta cuenta);
	
	void ActualizarVenta(Venta cuenta);
	
	Venta BuscarPorNumero(String numero);
	
	void BorrarVenta(String numero);
	
}
