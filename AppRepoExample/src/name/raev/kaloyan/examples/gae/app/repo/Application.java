package name.raev.kaloyan.examples.gae.app.repo;

import javax.persistence.*;
import java.lang.String;
import name.raev.kaloyan.examples.gae.app.repo.Version;
import java.util.Collection;
import java.util.ArrayList;
import static javax.persistence.GenerationType.IDENTITY;
import com.google.appengine.api.datastore.Key;

@Entity(name = "Application")
public class Application {

	@Basic
	private String name;
	@OneToMany
	private Collection<Version> versions = new ArrayList<Version>();
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Key id;

	public void setName(String param) {
		this.name = param;
	}

	public String getName() {
		return name;
	}

	public Collection<Version> getVersions() {
		return versions;
	}

	public void setVersions(Collection<Version> param) {
		this.versions = param;
	}

	public void setId(Key param) {
		this.id = param;
	}

	public Key getId() {
		return id;
	}

}