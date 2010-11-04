package name.raev.kaloyan.examples.gae.app.repo;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AppRepoExampleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		EntityManager em = EMF.get().createEntityManager();
		
		try {
			resp.getWriter().println("Application repository:");
			resp.getWriter().println("==================================");
			Query q = em.createQuery("select from Application");
			List<Application> customerResult = q.getResultList();
			for (Application app : customerResult) {
				resp.getWriter().println(app.getName());
				for (Version v : app.getVersions()) {
					resp.getWriter().println("- " + v.getNumber());
				}
			}
		} finally {
			em.close();
		}
	}
}
