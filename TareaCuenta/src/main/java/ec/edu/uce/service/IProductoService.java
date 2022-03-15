package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.jpa.Producto;

public interface IProductoService {

	void InsertarProductoService(Producto cuentah);
	
	void ActualizarProductoService(Producto cuentah);
	
	Producto BuscarPorCodigoService(String codigoBarras);
	
	void BorrarProductoService(String codigoBarras);
}
