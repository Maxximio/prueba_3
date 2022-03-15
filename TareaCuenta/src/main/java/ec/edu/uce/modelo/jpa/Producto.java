package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	@Id
	@Column(name="pro_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pro")
	@SequenceGenerator(name="seq_pro",sequenceName = "seq_pro",allocationSize = 1)
	private Integer id;
	
	@Column(name="pro_codigo_barras")
	private String codigoBarras;
	
	@Column(name="pro_nombre")
	private String nombre;
	
	@Column(name="pro_categoria")
	private String categoria;
	
	@Column(name="pro_stock")
	private Integer stock;
	
	@Column(name="pro_precio")
	private BigDecimal precio;
	
	@OneToMany(mappedBy = "producto",cascade=CascadeType.ALL)
	private List<Venta> venta;
	
	@OneToMany(mappedBy = "producto",cascade=CascadeType.ALL)
	private List<Venta> datalle;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Venta> getDatalle() {
		return datalle;
	}

	public void setDatalle(List<Venta> datalle) {
		this.datalle = datalle;
	}

	
	
	
}
