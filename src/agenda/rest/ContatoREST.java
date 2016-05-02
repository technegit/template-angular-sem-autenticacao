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
@Path("/Contato")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ContatoREST implements RESTService<Contato> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private ContatoBusiness business;
  /**
   * @generated
   */
  private TelefoneBusiness telefoneBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public ContatoREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new ContatoBusiness(session);
    this.telefoneBusiness = new TelefoneBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Contato entity) {
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
  public Response put(Contato entity) {
    try {
	    session.begin();
	    Contato updatedEntity = business.update(entity);
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
  public Response putWithId(Contato entity) {
    try {
	    session.begin();
	    Contato updatedEntity = business.update(entity);
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
  public Response delete(Contato entity) {  
		try {
			session.begin();
			Contato updatedEntity = business.update(entity);
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
   * OneToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/Telefone")
  public GenericEntity<List<Telefone>> findTelefone(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Telefone>>(this.business.findTelefone(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/Telefone/{relationId}")
  public Response deleteTelefone(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.telefoneBusiness.deleteById(relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @PUT
  @Path("/{instanceId}/Telefone/{relationId}")
  public Response putTelefone(Telefone entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			Telefone updatedEntity = this.telefoneBusiness.update(entity);
			session.commit();
			return Response.ok(updatedEntity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Telefone")
  public Response postTelefone(Telefone entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Contato contato = this.business.findById(instanceId);
			entity.setContato(contato);
			this.telefoneBusiness.save(entity);
			session.commit();
			this.telefoneBusiness.refresh(entity);
			return Response.ok(entity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  


  
  /**
   * NamedQuery list
   * @generated
   */
  @GET
  	
  public GenericEntity<List<Contato>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Contato>>(business.list(limit, offset)){};

  }
  /**
   * NamedQuery listByNome
   * @generated
   */
  @GET
  @Path("/listByNome/{nome}")	
  public GenericEntity<List<Contato>> listByNome(@PathParam("nome")java.lang.String nome, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Contato>>(business.listByNome(nome, limit, offset)){};

  }
	
  /**
   * NamedQuery listByNome
   * @generated
   */
  @GET
  @Path("/listByNome")	
  public GenericEntity<List<Contato>> listByNomeParams(@QueryParam("nome")java.lang.String nome, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Contato>>(business.listByNome(nome, limit, offset)){};	
  }
}
