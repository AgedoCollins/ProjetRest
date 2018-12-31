package Bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "article")
@XmlType(propOrder = { "libelle", "prix", "descriptif", "nomImage"})
public class Article {
	private int id;
	private String libelle;
	private double prix;
	private String descriptif;
	private String nomImage;

	public Article() {

	}

	public Article(int id, String libelle, double prix, String descriptif, String nomImage) {
		this.id=id;
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
	}
	
	public Article(String libelle, double prix, String descriptif, String nomImage) {
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
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

	@XmlAttribute(name = "nomimage")
	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String toJson() {
		String retour = "";
		retour += "{";

		retour += "\"id\":";
		retour += "\"" + this.getId() + "\"";
		retour += ",";
		retour += "\"libelle\":";
		retour += "\"" + this.getLibelle() + "\"";
		retour += ",";
		retour += "\"prix\":";
		retour += "\"" + this.getPrix() + "\"";
		retour += ",";
		retour += "\"descriptif\":";
		retour += "\"" + this.getDescriptif() + "\"";
		retour += ",";
		retour += "\"nomImage\":";
		retour += "\"" + this.getNomImage() + "\"";
		retour += "}";

		return retour;
	}

	public static String toJson(List<Article> list) {
		String retour = "{";
		retour += "\"article\":";
		retour += "[";
		int cpt = 0;
		for (Article art : list) {
			if (cpt > 0) {
				retour += ",";
			}
			retour += art.toJson();
			cpt++;
		}

		retour += "]";
		retour += "}";
		return retour;
	}

}
