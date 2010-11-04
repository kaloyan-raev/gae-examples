package name.raev.kaloyan.examples.gae.app.repo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBLoadServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Loading database...");
		
		Application app1 = addApplication("My First Application");
		addVersion(app1, "1.0");
		addVersion(app1, "2.0");
		Application app2 = addApplication("My Second Application");
		addVersion(app2, "0.5");
		
		resp.getWriter().println("Database loaded successfully.");
	}
	
	private Application addApplication(String name) {
		Application app = new Application();
		app.setName(name);
		
		EntityManager em = EMF.get().createEntityManager();
		try {
			em.persist(app);
		} finally {
			em.close();
		}
		
		return app;
	}
	
	private Version addVersion(Application app, String number) {
		Version v = new Version();
		v.setNumber(number);
		app.getVersions().add(v);
		
		EntityManager em = EMF.get().createEntityManager();
		try {
			em.persist(v);
			em.merge(app);
		} finally {
			em.close();
		}
		
		return v;
	}

}

