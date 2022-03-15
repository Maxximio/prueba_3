package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Venta;

public interface IVentaService {

	void InsertarVentaService(Venta cuenta);
	
	void ActualizarVentaService(Venta cuenta);
	
	Venta BuscarPorNumeroService(String numero);
	
	void BorrarVentaService(String numero);
}
