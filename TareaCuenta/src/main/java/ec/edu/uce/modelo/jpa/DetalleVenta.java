package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="detalle")
public class DetalleVenta {

	@Id
	@Column(name="deta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_deta")
	@SequenceGenerator(name="seq_deta",sequenceName = "seq_deta",allocationSize = 1)
	private Integer id;
	
	@Column(name="deta_precio_unitario")
	private BigDecimal precioU;
	
	@Column(name="deta_cantidad")
	private Integer Cantidad;
	
	@Column(name="deta_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="venta_id")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name="pro_id")
	private Producto producto;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrecioU() {
		return precioU;
	}

	public void setPrecioU(BigDecimal precioU) {
		this.precioU = precioU;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
	
	
}

