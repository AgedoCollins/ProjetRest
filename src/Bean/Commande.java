package Bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "commande")
@XmlType(propOrder = { "id", "dateCommande", "etat","prixTotale" })
public class Commande {
	private int id;
	private String dateCommande;
	private String etat;
	private double prixTotale; 

	public Commande() {

	}

	public Commande(int id, String dateCommande, String etat,double prixTotale) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.etat =etat;
		this.prixTotale = prixTotale;
	}

	public Commande(String dateCommande, String etat,double prixTotale) {
		this.dateCommande = dateCommande;
		this.etat =etat;
		this.prixTotale = prixTotale;
	}

	@XmlAttribute(name = "prixTotale")
	public double getPrixTotale() {
		return prixTotale;
	}

	public void setPrixTotale(double prixTotale) {
		this.prixTotale = prixTotale;
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

	@XmlAttribute(name = "etat")
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
