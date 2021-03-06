package agenda.dao;

import javax.persistence.*;
import agenda.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class GrupoDAO extends BasicDAO<String, Grupo> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 69084250l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public GrupoDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Grupo utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Grupo entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Grupo utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Grupo findById(java.lang.String id){
      TypedQuery<Grupo> query = this.entityManager.createQuery("SELECT entity FROM Grupo entity WHERE entity.id = :id", Grupo.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<Contato> findContato(java.lang.String id, int limit, int offset) {
      TypedQuery<Contato> query = this.entityManager.createQuery("SELECT entity FROM Contato entity WHERE entity.grupo.id = :id", Contato.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }


  /**
   * NamedQuery list
   * @generated
   */
  public List<Grupo> list(int limit, int offset){
      return this.entityManager.createNamedQuery("grupoList", Grupo.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
  /**
   * NamedQuery listByNome
   * @generated
   */
  public List<Grupo> listByNome(java.lang.String nome, int limit, int offset){
      return this.entityManager.createNamedQuery("grupoListByNome", Grupo.class).setParameter("nome", nome).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}