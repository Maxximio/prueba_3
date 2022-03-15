package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Venta;
import ec.edu.uce.repository.jpa.IVentaRepo;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo ventaRepo;
	
	@Override
	public void InsertarVentaService(Venta cuenta) {
		this.ventaRepo.InsertarVenta(cuenta);
	}

	@Override
	public void ActualizarVentaService(Venta cuenta) {
		this.ventaRepo.ActualizarVenta(cuenta);
	}

	@Override
	public Venta BuscarPorNumeroService(String numero) {
		return this.ventaRepo.BuscarPorNumero(numero);
	}

	@Override
	public void BorrarVentaService(String numero) {
		this.ventaRepo.BorrarVenta(numero);
	}

}
