package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Producto;
import ec.edu.uce.repository.jpa.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo habienteRepo;
	
	@Override
	public void InsertarProductoService(Producto cuentah) {
		this.habienteRepo.InsertarCuentaHabiente(cuentah);
	}

	@Override
	public void ActualizarProductoService(Producto cuentah) {
		this.habienteRepo.ActualizarCuentaHabiente(cuentah);
	}

	@Override
	public Producto BuscarPorCodigoService(String cedula) {
		return this.habienteRepo.BuscarPorCodigoB(cedula);
	}

	@Override
	public void BorrarProductoService(String cedula) {
		this.habienteRepo.BorrarProducto(cedula);
	}
	

}
