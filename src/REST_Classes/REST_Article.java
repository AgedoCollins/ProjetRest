package REST_Classes;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Bean.Article;
import Bean.Vendeur;
import DAO.DAOArticle;
import DAO.DAOFactory;

@Path("articles")
public class REST_Article {
	private DAOFactory daoFactory= null;
	
	@GET
	@Path("afficher/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticle(@PathParam("id") int id) {
		daoFactory= new DAOFactory();
		DAOArticle dao_article = (DAOArticle) daoFactory.getDaoArticle();
		Article article = dao_article.findId(id);	
		if(article!=null)
			return Response.status(Status.OK).entity(article).build();
		else
			return Response.status(Status.OK).build();		
			
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticle() {
		daoFactory= new DAOFactory();
		DAOArticle daoArticle = (DAOArticle) daoFactory.getDaoArticle();
		List<Article> listArticles = daoArticle.findAll();	
		if(listArticles.size()>0)
			return Response.status(Status.OK).entity(listArticles).build();
		else
			return Response.status(Status.OK).entity(null).build();		
			
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticleByVendeur(@PathParam("id") String id) {
		daoFactory= new DAOFactory();
		DAOArticle daoArticle = (DAOArticle) daoFactory.getDaoArticle();
		List<Article> listArticles = daoArticle.findByIdVendeur(id);	
		if(listArticles.size()>0)
			return Response.status(Status.OK).entity(listArticles).build();
		else
			return Response.status(Status.OK).entity(null).build();		
			
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response PostArt(
			@FormParam("libelle") String libelle,
			 @FormParam("prix") double prix,
			 @FormParam("descriptif") String descriptif,
			 @FormParam("nomimage") String nomimage,
			 @FormParam("id_utilisateur") int id) {
		daoFactory= new DAOFactory();
		Article article = new Article();
		Vendeur vendeur = new Vendeur();
		article.setLibelle(libelle);
		article.setPrix(prix);
		article.setDescriptif(descriptif);
		article.setNomImage(nomimage);
		vendeur.setId(id);
		DAOArticle dao_art = (DAOArticle) daoFactory.getDaoArticle();
		
		return Response.status(Status.OK).entity(dao_art.create(article, vendeur)).build();	
	}
	
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response UpdateArt(
			@FormParam("id") int id,
			@FormParam("libelle") String libelle,
			 @FormParam("prix") double prix,
			 @FormParam("descriptif") String descriptif,
			 @FormParam("nomimage") String nomimage) {
		daoFactory= new DAOFactory();
		Article article = new Article();
		article.setId(id);
		article.setLibelle(libelle);
		article.setPrix(prix);
		article.setDescriptif(descriptif);
		article.setNomImage(nomimage);
		DAOArticle dao_art = (DAOArticle) daoFactory.getDaoArticle();
		
		return Response.status(Status.OK).entity(dao_art.updateArticle(article)).build();	
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteArticle(@PathParam("id") String id) {
		daoFactory= new DAOFactory();
		DAOArticle daoArticle = (DAOArticle) daoFactory.getDaoArticle();
		Article article = new Article();
		article.setId(Integer.parseInt(id));
		if(daoArticle.delete(article))
			return Response.status(Status.OK).entity("ok").build();
		else
			return Response.status(Status.OK).entity("ko").build();
	}
	
}
