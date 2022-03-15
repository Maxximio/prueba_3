package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class Venta {

	@Id
	@Column(name="venta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ventaa")
	@SequenceGenerator(name="seq_venta",sequenceName = "seq_venta",allocationSize = 1)
	private Integer id;
	
	@Column(name="venta_numero")
	private String numero;
	
	@Column(name="venta_valor")
	private BigDecimal valor;
	
	@Column(name="venta_fecha")
	private LocalDateTime fecha;
	
	@Column(name="cuba_cedula_cliente")
	private String cedulaCliente;
	
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
