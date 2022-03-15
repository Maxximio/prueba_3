package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.funcionales.ICuentaHabientesVip;
import ec.edu.uce.funcionales.IRepoteRetiros;
import ec.edu.uce.modelo.jpa.Venta;
import ec.edu.uce.modelo.jpa.Producto;
import ec.edu.uce.modelo.jpa.DetalleVenta;

@Service
public class GestorServiceImpl implements IGestorService{

	private static final Logger LOG= LogManager.getLogger(GestorServiceImpl.class);
	
	@Autowired
	private IVentaService ventaServ;
	
	@Autowired
	private IProductoService prodService;
	
	@Autowired
	private IDetalleService detallService;
	
	

	
	public List<CuentaHabientesVIP> reporteHabienteVip(BigDecimal saldo) {

		ICuentaHabientesVip iCuentaHabientesVIP = (s) -> {
			List<CuentaHabientesVIP> cuentas = this.prodService.reporteHabienteVip();
			return cuentas.stream()
					.filter(c -> (c.getSaldo().compareTo(s) == 1 || c.getSaldo().compareTo(s) == 0) ? true : false)
					.collect(Collectors.toList());
		};

		return iCuentaHabientesVIP.filtroSaldo(saldo);
	}
	
	

	public List<DetalleVenta> reporteRetiros(LocalDateTime fechaRetiro, BigDecimal montoRetiro) {

		IRepoteRetiros iReporteHistoricoRetiro = (m) -> {
			List<DetalleVenta> lista = this.detallService.ReporteporFecha(fechaRetiro);
			return lista.stream().filter(h -> (h.getMonto().compareTo(m) == 1 || h.getMonto().compareTo(m) == 0) ? true : false)
					.collect(Collectors.toList());
		};

		return iReporteHistoricoRetiro.filtro(montoRetiro);
	}



	@Override
	public void IngresarProductos(Producto prod) {
		String codigo=prod.getCodigoBarras();
		Integer stock=prod.getStock();
		
		Producto producto1=this.prodService.BuscarPorCodigoService(codigo);
		
		if(producto1.getCodigoBarras()==codigo) {
			
		}
		
	}



	@Override
	public void RealizarVenta(String codigo, Integer cantidad, String cedulaCliente, String numeroVenta) {
		
	}



	@Override
	public void ConsultarStock(String codigoBarra) {
		
	}



	@Override
	public void ReporteVentas(LocalDateTime fecha, String categoria, Integer cantidadMin) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
