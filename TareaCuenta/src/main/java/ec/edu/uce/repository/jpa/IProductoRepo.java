package ec.edu.uce.repository.jpa;

import java.util.List;

import ec.edu.uce.modelo.jpa.Producto;

public interface IProductoRepo {

	void InsertarCuentaHabiente(Producto cuentah);
	
	void ActualizarCuentaHabiente(Producto cuentah);
	
	Producto BuscarPorCodigoB(String codigoBarras);
	
	void BorrarProducto(String codigoBarras);
}
