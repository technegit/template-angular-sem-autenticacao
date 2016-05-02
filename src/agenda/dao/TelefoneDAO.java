package agenda.dao;

import javax.persistence.*;
import agenda.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class TelefoneDAO extends BasicDAO<String, Telefone> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1295853778l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public TelefoneDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Telefone utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Telefone entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Telefone utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Telefone findById(java.lang.String id){
      TypedQuery<Telefone> query = this.entityManager.createQuery("SELECT entity FROM Telefone entity WHERE entity.id = :id", Telefone.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



  /**
   * NamedQuery list
   * @generated
   */
  public List<Telefone> list(int limit, int offset){
      return this.entityManager.createNamedQuery("telefoneList", Telefone.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
  /**
   * NamedQuery listByContato
   * @generated
   */
  public List<Telefone> listByContato(Contato contato, int limit, int offset){
      return this.entityManager.createNamedQuery("telefoneListByContato", Telefone.class).setParameter("contato", contato).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
  /**
   * NamedQuery listByNumero
   * @generated
   */
  public List<Telefone> listByNumero(java.lang.String numero, int limit, int offset){
      return this.entityManager.createNamedQuery("telefoneListByNumero", Telefone.class).setParameter("numero", numero).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}