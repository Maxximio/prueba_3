package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.DetalleVenta;
import ec.edu.uce.modelo.jpa.DetalleVenta;
import ec.edu.uce.repository.jpa.IDetallesRepo;

@Service
public class DetalleServiceImpl implements IDetalleService{

	@Autowired
	private IDetallesRepo detaRepo;
	
	@Override
	public void InsertarDetalleService(DetalleVenta detalle) {
		this.detaRepo.InsertarDetalle(detalle);
	}

	@Override
	public void ActualizarDetallesService(DetalleVenta detalle) {
		this.detaRepo.ActualizarDetalle(detalle);
	}

	@Override
	public DetalleVenta BuscarPorSubtotalService(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.detaRepo.BuscarPorSubtotal(subtotal);
	}

	@Override
	public void BorrarDetalleService(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		this.detaRepo.BorrarDetalle(subtotal);
	}


	
}
