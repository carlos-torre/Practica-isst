package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.t4.dao.TFGDAO;
import es.dit.upm.isst.t4.dao.TFGDAOImpl;
import es.upm.dit.isst.t4.model.TFG;

@SuppressWarnings("serial")
public class Es_upm_dit_isst_tfgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		TFGDAO dao = TFGDAOImpl.getInstance();
		//dao.create("pepe", "prueba", "prueba", "juan", "ramon", "prueba", 1);
		//dao.create("pedro", "prueba2", "prueba2", "luis", "fran", "prueba2", 1);
		List<TFG> tfgs = dao.readLista();
		/*
		for(TFG tfg: dao.readLista()) {
			resp.getWriter().println(tfg);
		}
		*/
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		if (req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
		}
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		req.getSession().setAttribute("tfgs", new ArrayList<TFG>(tfgs));
		RequestDispatcher view = req.getRequestDispatcher("MostrarTFGView.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
		}
		/*
		resp.getWriter().println("<p>Pulsa <a href=" + url + ">" + urlLinktext + "</a>.</p>");
		resp.getWriter().println(req.getSession().getAttribute("user"));
		resp.getWriter().println(req.getSession().getAttribute("url"));
		resp.getWriter().println(req.getSession().getAttribute("urlLinktext"));
		*/
	}
}
