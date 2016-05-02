package es.dit.upm.isst.t4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.t4.model.TFG;

public class TFGDAOImpl implements TFGDAO {

	private static TFGDAOImpl instance;
	private TFGDAOImpl () {
	}
	public static TFGDAOImpl getInstance() {
		if (instance == null)
			instance = new TFGDAOImpl();
		return instance;
	}

	@Override
	public void create(String autor, String titulo, String resumen,
			String tutor, String secretario, String fichero, int estado) {
		EntityManager em = EMFService.get().createEntityManager();
		TFG tfg = new TFG(autor, titulo, resumen, tutor, secretario, fichero, estado);
		em.persist(tfg);
		em.close();
	}

	@Override
	public TFG readAutor(String autor) {
		TFG tfg;
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.autor = :autor ");
		q.setParameter("autor", autor);
		try{
			tfg  =(TFG)q.getSingleResult();	
		}catch(Exception e){
			em.close();
			return null;
		}
		em.close();
		return tfg;
	}

	@Override
	public List<TFG> readLista() {
		List<TFG> lista = new ArrayList<TFG>();
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m");
		try{
			lista = (List<TFG>)q.getResultList();
		}catch(Exception e){
			em.close();
			return null;
		}
		em.close();		
		return lista;
	}

	@Override
	public List<TFG> readTutor(String tutor) {
		List<TFG> lista = new ArrayList<TFG>();
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.tutor = :tutor");
		q.setParameter("tutor", tutor);
		try{
			lista = (List<TFG>)q.getResultList();
		}catch(Exception e){
			em.close();
			return null;
		}
		em.close();		
		return lista;
	}

	@Override
	public List<TFG> readSecretario(String secretario) {
		List<TFG> lista = new ArrayList<TFG>();
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.secretario = :secretario");
		q.setParameter("secretario", secretario);
		try{
			lista = (List<TFG>)q.getResultList();
		}catch(Exception e){
			em.close();
			return null;
		}
		em.close();		
		return lista;
	}

	@Override
	public List<TFG> readEstado(int estado) {
		List<TFG> lista = new ArrayList<TFG>();
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from TFG m where m.estado = :estado");
		q.setParameter("estado", estado);
		try{
			lista = (List<TFG>)q.getResultList();
		}catch(Exception e){
			em.close();
			return null;
		}
		em.close();		
		return lista;
	}

	@Override
	public void update(TFG tfg) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			em.merge(tfg);
		}catch(Exception e){
			
		}
		em.close();
	}

	@Override
	public void delete(TFG tfg) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			em.remove(tfg);
		}catch(Exception e){
			
		}
		em.close();
	}

}
