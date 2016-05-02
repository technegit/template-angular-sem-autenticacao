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
@Path("/Grupo")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class GrupoREST implements RESTService<Grupo> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private GrupoBusiness business;
  /**
   * @generated
   */
  private ContatoBusiness contatoBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public GrupoREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new GrupoBusiness(session);
    this.contatoBusiness = new ContatoBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Grupo entity) {
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
  public Response put(Grupo entity) {
    try {
	    session.begin();
	    Grupo updatedEntity = business.update(entity);
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
  public Response putWithId(Grupo entity) {
    try {
	    session.begin();
	    Grupo updatedEntity = business.update(entity);
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
  public Response delete(Grupo entity) {  
		try {
			session.begin();
			Grupo updatedEntity = business.update(entity);
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
  @Path("/{instanceId}/Contato")
  public GenericEntity<List<Contato>> findContato(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Contato>>(this.business.findContato(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/Contato/{relationId}")
  public Response deleteContato(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.contatoBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/Contato/{relationId}")
  public Response putContato(Contato entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			Contato updatedEntity = this.contatoBusiness.update(entity);
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
  @Path("/{instanceId}/Contato")
  public Response postContato(Contato entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Grupo grupo = this.business.findById(instanceId);
			entity.setGrupo(grupo);
			this.contatoBusiness.save(entity);
			session.commit();
			this.contatoBusiness.refresh(entity);
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
  	
  public GenericEntity<List<Grupo>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Grupo>>(business.list(limit, offset)){};

  }
  /**
   * NamedQuery listByNome
   * @generated
   */
  @GET
  @Path("/listByNome/{nome}")	
  public GenericEntity<List<Grupo>> listByNome(@PathParam("nome")java.lang.String nome, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Grupo>>(business.listByNome(nome, limit, offset)){};

  }
	
  /**
   * NamedQuery listByNome
   * @generated
   */
  @GET
  @Path("/listByNome")	
  public GenericEntity<List<Grupo>> listByNomeParams(@QueryParam("nome")java.lang.String nome, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Grupo>>(business.listByNome(nome, limit, offset)){};	
  }
}
