package agenda.rest;


import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.persistence.*;

import agenda.rest.util.*;

import agenda.dao.*;
import agenda.entity.*;
import agenda.business.*;
import agenda.rest.exceptions.*;
import javax.servlet.http.HttpServletRequest;


/**
 * Publicando metodos de negocio via REST
 * @generated
 **/
@Path("/Telefone")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TelefoneREST implements RESTService<Telefone> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private TelefoneBusiness business;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public TelefoneREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new TelefoneBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Telefone entity) {
    try {
	    session.begin();
	    business.save(entity);
	    session.commit();
	    business.refresh(entity);
	    return Response.ok(entity).build();
    }
    
    catch(Exception exception){
	    session.rollBack();
        throw new CustomWebApplicationException(exception);
    }
  }

  /**
   * @generated
   */
  @PUT
  public Response put(Telefone entity) {
    try {
	    session.begin();
	    Telefone updatedEntity = business.update(entity);
	    session.commit();
	    return Response.ok(updatedEntity).build();
    }
    
    catch(Exception exception){
	    session.rollBack();
        throw new CustomWebApplicationException(exception);
    }  
  }
  
  /**
   * @generated
   */  
  @PUT
  @Path("/{id}")
  public Response putWithId(Telefone entity) {
    try {
	    session.begin();
	    Telefone updatedEntity = business.update(entity);
	    session.commit();
	    return Response.ok(updatedEntity).build();
    }
    
    catch(Exception exception){
	    session.rollBack();
        throw new CustomWebApplicationException(exception);
    }  
  }
  
  /**
   * @generated
   */  
  @DELETE
  public Response delete(Telefone entity) {  
		try {
			session.begin();
			Telefone updatedEntity = business.update(entity);
			business.delete(updatedEntity);
			session.commit();
			return Response.ok().build();
		}

		catch (Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);
		}    
  } 
   
  /**
   * @generated
   */    
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") java.lang.String id) {  
		try {
			session.begin();
			if (business.deleteById(id) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				return Response.status(404).build();
			}
		}

		catch (Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);
		}    
  }
  
  
  


  
  /**
   * NamedQuery list
   * @generated
   */
  @GET
  	
  public GenericEntity<List<Telefone>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Telefone>>(business.list(limit, offset)){};

  }
  /**
   * NamedQuery listByContato
   * @generated
   */
  @GET
  @Path("/listByContato/{contato}")	
  public GenericEntity<List<Telefone>> listByContato(@PathParam("contato")Contato contato, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Telefone>>(business.listByContato(contato, limit, offset)){};

  }
  /**
   * NamedQuery listByNumero
   * @generated
   */
  @GET
  @Path("/listByNumero/{numero}")	
  public GenericEntity<List<Telefone>> listByNumero(@PathParam("numero")java.lang.String numero, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Telefone>>(business.listByNumero(numero, limit, offset)){};

  }
	
  /**
   * NamedQuery listByContato
   * @generated
   */
  @GET
  @Path("/listByContato")	
  public GenericEntity<List<Telefone>> listByContatoParams(@QueryParam("contato")Contato contato, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Telefone>>(business.listByContato(contato, limit, offset)){};	
  }
  /**
   * NamedQuery listByNumero
   * @generated
   */
  @GET
  @Path("/listByNumero")	
  public GenericEntity<List<Telefone>> listByNumeroParams(@QueryParam("numero")java.lang.String numero, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Telefone>>(business.listByNumero(numero, limit, offset)){};	
  }
}
