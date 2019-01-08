package Bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "commande")
@XmlType(propOrder = { "id", "dateCommande"})
public class Commande {
	private int id;
	private String dateCommande;

	public Commande() {

	}

	public Commande(int id, String dateCommande) {
		this.id = id;
		this.dateCommande = dateCommande;
	}

	public Commande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlAttribute(name = "dateCommande")
	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
}
