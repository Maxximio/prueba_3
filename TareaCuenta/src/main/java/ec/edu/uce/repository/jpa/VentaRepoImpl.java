package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarVenta(Venta vent) {
		this.entityManager.persist(vent);
	}

	@Override
	public void ActualizarVenta(Venta vent){
		this.entityManager.merge(vent);
	}

	@Override
	public Venta BuscarPorNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery("select * from venta v where v.venta_numero=:valor",Venta.class);
		miQuery.setParameter("valor", numero);
		return (Venta) miQuery.getSingleResult();
	}

	@Override
	public void BorrarVenta(String numero) {
		Venta borrado=this.BuscarPorNumero(numero);	
		this.entityManager.remove(borrado);
	}

}
