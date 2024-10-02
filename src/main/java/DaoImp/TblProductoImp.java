package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

import Interfaces.IProducto;
import model.TblProducto;

public class TblProductoImp implements IProducto {

	@Override
	public void RegistrarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoJPAMavenMartesNoche");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			em.close();
		}
	
		
		
	}

	@Override
	public void ActualizarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(producto);
			em.getTransaction().commit();
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			em.close();
		}
		
	}

	@Override
	public void EliminarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			TblProducto elimcli = em.find(TblProducto.class, producto.getIdProducto());
			if(elimcli != null){
				em.remove(elimcli);
				em.getTransaction().commit();
			}
	
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			e.getMessage();
		}finally {
			em.close();
		}
	}

	@Override
	public TblProducto BuscarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			TblProducto tblpro = em.find(TblProducto.class, producto.getIdProducto());
			em.getTransaction().commit();
			return tblpro;
			
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<TblProducto> ListarProdcuto() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			List<TblProducto> listado = em.createQuery("select c from TblProdcuto c", TblProducto.class).getResultList();
			em.getTransaction().commit();
			return listado;
	
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			em.close();
		}
		return null;
	}

}
