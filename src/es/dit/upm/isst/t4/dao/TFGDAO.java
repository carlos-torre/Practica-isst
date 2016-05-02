package es.dit.upm.isst.t4.dao;

import java.util.List;

import es.upm.dit.isst.t4.model.TFG;

public interface TFGDAO {

	public void create(String autor, String titulo, String resumen, String tutor,
			String secretario, String fichero, int estado);
	public TFG readAutor(String autor);
	public List<TFG> readLista();
	public List<TFG> readTutor(String tutor);
	public List<TFG> readSecretario(String secretario);
	public List<TFG> readEstado(int estado);
	public void update(TFG tfg);
	public void delete(TFG tfg);
}
