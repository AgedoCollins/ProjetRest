package Bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "article")
@XmlType(propOrder = { "libelle", "prix", "descriptif", "nomImage", "id_commande","etat"})
public class Article {
	private int id;
	private String libelle;
	private double prix;
	private String descriptif;
	private String nomImage;
	private int id_commande;
	private String etat;
	
	public Article() {

	}

	public Article(int id, String libelle, double prix, String descriptif, String nomImage, String etat) {
		this.id=id;
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
		this.etat = etat;
	}
	
	public Article(String libelle, double prix, String descriptif, String nomImage, String etat) {
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
		this.etat = etat;
	}

	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlAttribute(name = "libelle")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@XmlAttribute(name = "prix")
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@XmlAttribute(name = "descriptif")
	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	@XmlAttribute(name = "nomImage")
	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	@XmlAttribute(name = "id_commande")
	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	@XmlAttribute(name = "etat")
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
