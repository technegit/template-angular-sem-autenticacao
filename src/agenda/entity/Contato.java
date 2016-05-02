package agenda.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela contato
 * @generated
 */
@Entity
@Table(name = "\"contato\"")
@NamedQueries({
        @NamedQuery(name = "contatoList", query = "select c from Contato c"),
        @NamedQuery(name = "contatoListByNome", query = "select c from Contato c where c.nome LIKE CONCAT('%', COALESCE(:nome, c.nome),'%')")
})
@XmlRootElement
public class Contato implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1678785077l;
	
	/**
	 * @generated
	 */
	@Id
    
	@Column(name = "id")
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	@Column(name = "nome", nullable = false, unique = false, length=500)
	private java.lang.String nome;
	
	/**
	 * @generated
	 */
	@Column(name = "email", nullable = false, unique = false, length=500)
	private java.lang.String email;
	
	/**
	 * @generated
	 */
	@ManyToOne
	@JoinColumn(name="fk_grupo", referencedColumnName = "id")
	private Grupo grupo;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Contato(){
	}

	
	/**
	 * Obtém id
	 * @param id id
	 * return id
	 * @generated
	 */
	public java.lang.String getId(){
		return this.id;
	}
	
	/**
	 * Define id
	 * @param id id
	 * @generated
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 * Obtém nome
	 * @param nome nome
	 * return nome
	 * @generated
	 */
	public java.lang.String getNome(){
		return this.nome;
	}
	
	/**
	 * Define nome
	 * @param nome nome
	 * @generated
	 */
	public void setNome(java.lang.String nome){
		this.nome = nome;
	}
	
	/**
	 * Obtém email
	 * @param email email
	 * return email
	 * @generated
	 */
	public java.lang.String getEmail(){
		return this.email;
	}
	
	/**
	 * Define email
	 * @param email email
	 * @generated
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	
	/**
	 * Obtém grupo
	 * @param grupo grupo
	 * return grupo
	 * @generated
	 */
	public Grupo getGrupo(){
		return this.grupo;
	}
	
	/**
	 * Define grupo
	 * @param grupo grupo
	 * @generated
	 */
	public void setGrupo(Grupo grupo){
		this.grupo = grupo;
	}
	
	/**
	 * @generated
	 */
	@Override
	public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }
	
	/**
	 * @generated
	 */	
	@Override
  	public boolean equals(Object obj) {
    
	    if(this == obj)
	      return true;
	    
	    if(obj == null)
	      return false;
	    
	    if(!(obj instanceof Contato))
	      return false;
	    
	    Contato other = (Contato)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}