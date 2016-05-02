package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.dit.upm.isst.t4.dao.TFGDAO;
import es.dit.upm.isst.t4.dao.TFGDAOImpl;
import es.upm.dit.isst.t4.model.TFG;

public class NuevoTFGServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String autor = (String) req.getSession().getAttribute("user");
		String tutor = req.getParameter("tutor");
		String titulo = req.getParameter("titulo");
		String resumen = req.getParameter("resumen");
		String secretario = "";
		String fichero = "";
		int estado = 1;
		
		TFGDAO dao = TFGDAOImpl.getInstance();
		try{
			dao.create(autor, titulo, resumen,
					tutor, secretario, fichero, estado);
		}catch(Exception e){
			
		}

		resp.sendRedirect("/es_upm_dit_isst_tfg");

	}
}
