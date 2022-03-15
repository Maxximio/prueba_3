package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.DetalleVenta;

@Repository
@Transactional
public class DetallesRepoImpl implements IDetallesRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarDetalle(DetalleVenta retiro) {
		this.entityManager.persist(retiro);
	}

	@Override
	public void ActualizarDetalle(DetalleVenta retiro) {
		this.entityManager.merge(retiro);
	}

	@Override
	public DetalleVenta BuscarPorSubtotal(BigDecimal subtotal) {
		Query miQuery= this.entityManager.createNativeQuery("select d from detalle d where d.deta_subtotal=:valor",DetalleVenta.class);
		miQuery.setParameter("valor", subtotal);
		return (DetalleVenta) miQuery.getSingleResult();
	}

	@Override
	public void BorrarDetalle(BigDecimal subtotal) {
		DetalleVenta borrado=this.BuscarPorSubtotal(subtotal);
		this.entityManager.remove(borrado);
	}

	
	
}
