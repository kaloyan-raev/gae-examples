package name.raev.kaloyan.examples.gae.app.repo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
	private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("AppRepoExample");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }

}
