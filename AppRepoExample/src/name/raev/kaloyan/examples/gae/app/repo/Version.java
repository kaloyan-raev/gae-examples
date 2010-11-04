package name.raev.kaloyan.examples.gae.app.repo;

import javax.persistence.*;
import java.lang.String;
import com.google.appengine.api.datastore.Key;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Version")
public class Version {

	@Basic
	private String number;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Key id;

	public void setNumber(String param) {
		this.number = param;
	}

	public String getNumber() {
		return number;
	}

	public void setId(Key param) {
		this.id = param;
	}

	public Key getId() {
		return id;
	}

}