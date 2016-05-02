package agenda.dao;

import javax.persistence.*;
import agenda.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class ContatoDAO extends BasicDAO<String, Contato> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1678785077l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public ContatoDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Contato utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Contato entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Contato utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Contato findById(java.lang.String id){
      TypedQuery<Contato> query = this.entityManager.createQuery("SELECT entity FROM Contato entity WHERE entity.id = :id", Contato.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<Telefone> findTelefone(java.lang.String id, int limit, int offset) {
      TypedQuery<Telefone> query = this.entityManager.createQuery("SELECT entity FROM Telefone entity WHERE entity.contato.id = :id", Telefone.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }


  /**
   * NamedQuery list
   * @generated
   */
  public List<Contato> list(int limit, int offset){
      return this.entityManager.createNamedQuery("contatoList", Contato.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
  /**
   * NamedQuery listByNome
   * @generated
   */
  public List<Contato> listByNome(java.lang.String nome, int limit, int offset){
      return this.entityManager.createNamedQuery("contatoListByNome", Contato.class).setParameter("nome", nome).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}