package agenda.business;

import agenda.dao.*;
import agenda.entity.*;

import java.util.*;

/**
 * Classe que representa a camada de negócios de Contato
 * @generated
 **/
public class ContatoBusiness {

  /**
   * Instância da classe ContatoDAO que faz o acesso ao banco de dados
   * @generated
   */
  private ContatoDAO dao;
  
  /**
   * Singleton de sessão usado para abrir e fechar conexão com o banco de dados
   * @generated
   */
  protected SessionManager sessionManager;
	
  /**
   * Copia referência da sessão e instancia DAO relacionada à essa classe para manipular o banco de dados
   * 
   * @param sessionmanager
   *          Singleton de sessão
   * @generated modifiable
   */
  public ContatoBusiness(final SessionManager sessionmanager) {
    // begin-user-code
    // end-user-code
    this.sessionManager = sessionmanager;
    this.dao = new ContatoDAO(sessionmanager.getEntityManager());
    // begin-user-code
    // end-user-code
  }
  
  /**
   * Construtor padrão, inicializa singleton de sessão
   * @generated modifiable   
   */
  public ContatoBusiness() {
    // begin-user-code
    // end-user-code  
    this(SessionManager.getInstance());
    // begin-user-code
    // end-user-code    
  }	

  /**
   * Grava valor no banco
   * 
   * @param entity Linha da tabela a ser persistida no banco de dados
   * @generated modifiable   
   */
  public void save(final Contato entity) {
    // begin-user-code
    // end-user-code  
    dao.save(entity);
    // begin-user-code
    // end-user-code    
  }
  
  /**
   * Dá um refresh na entidade com valores valor no banco
   * 
   * @param entity Entidade
   * @generated modifiable
   */
  public void refresh(final Contato entity) {
    // begin-user-code
    // end-user-code  
    dao.refresh(entity);
    // begin-user-code
    // end-user-code  
  }  
  
  /**
   * Atualiza valor do banco
   * 
   * @param entity Linha da tabela a ser atualizada
   * @generated modifiable   
   */
  public Contato update(final Contato entity) {
    // begin-user-code
    // end-user-code  
	Contato updatedEntity = dao.update(entity);
    // begin-user-code
    // end-user-code	
    return updatedEntity;
  }
  
  /**
   * Apaga valor do banco
   * 
   * @param entity Linha da tabela a ser excluída
   * @generated modifiable   
   */
  public void delete(final Contato entity){
    // begin-user-code
    // end-user-code    
	dao.delete(entity);
    // begin-user-code
    // end-user-code  	
  }
  
  /**
   * Remove a instância de Contato utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated modifiable   
   */  
  public int deleteById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    int result = dao.deleteById(id);
    // begin-user-code
    // end-user-code    
    return result;    
  }  
  
  /**
   * Obtém a instância de Contato utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated modifiable
   */  
  public Contato findById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    Contato entity = dao.findById(id);
    // begin-user-code
    // end-user-code      
    return entity;  
  }   
  
  /**
   * @generated modifiable
   */  
  public List<Telefone> findTelefone(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<Telefone> result = dao.findTelefone(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }


  
  /**
   * @generated modifiable
   */  	
  public List<Contato> list(int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<Contato> result = dao.list(limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
  /**
   * @generated modifiable
   */  	
  public List<Contato> listByNome(java.lang.String nome, int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<Contato> result = dao.listByNome(nome, limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
}
