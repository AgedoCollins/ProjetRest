package REST_Classes;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Bean.Article;
import DAO.DAOArticle;
import DAO.DAOFactory;

@Path("articles")
public class REST_Article {
	private DAOFactory daoFactory= null;
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostArt(
			@FormParam("libelle") String libelle,
			 @FormParam("prix") double prix,
			 @FormParam("descriptif") String descriptif,
			 @FormParam("nomimage") String nomimage) {
		daoFactory= new DAOFactory();
		Article article = new Article();
		article.setLibelle(libelle);
		article.setPrix(prix);
		article.setDescriptif(descriptif);
		article.setNomImage(nomimage);
		DAOArticle dao_art = (DAOArticle) daoFactory.getDaoArticle();
		
		return Response.status(Status.OK).entity(dao_art.create(article)).build();	
	}
	
}
