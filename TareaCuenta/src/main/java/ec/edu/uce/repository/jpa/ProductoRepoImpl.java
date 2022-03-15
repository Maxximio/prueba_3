package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Venta;
import ec.edu.uce.modelo.jpa.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarCuentaHabiente(Producto cuentah) {
		this.entityManager.persist(cuentah);
	}

	@Override
	public void ActualizarCuentaHabiente(Producto cuentah) {
		this.entityManager.merge(cuentah);
	}

	@Override
	public Producto BuscarPorCodigoB(String codigoBarras) {
		Query miQuery= this.entityManager.createNativeQuery("select * from producto p where p.pro_codigo_barras=:valor",Producto.class);
		miQuery.setParameter("valor", codigoBarras);
		return (Producto) miQuery.getSingleResult();
	}

	@Override
	public void BorrarProducto(String codigoBarras) {
		Producto borrado=this.BuscarPorCodigoB(codigoBarras);
		this.entityManager.remove(borrado);
	}
	
}
