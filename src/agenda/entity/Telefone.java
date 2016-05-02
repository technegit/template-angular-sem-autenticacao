package agenda.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela telefone
 * @generated
 */
@Entity
@Table(name = "\"telefone\"")
@NamedQueries({
        @NamedQuery(name = "telefoneList", query = "select t from Telefone t"),
        @NamedQuery(name = "telefoneListByContato", query = "select t from Telefone t where t.contato = :contato"),
        @NamedQuery(name = "telefoneListByNumero", query = "select t from Telefone t where t.numero LIKE CONCAT('%', COALESCE(:numero, t.numero),'%')")
})
@XmlRootElement
public class Telefone implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1295853778l;
	
	/**
	 * @generated
	 */
	@Id
    
	@Column(name = "id")
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	@Column(name = "numero", nullable = false, unique = false, length=9)
	private java.lang.String numero;
	
	/**
	 * @generated
	 */
	@ManyToOne
	@JoinColumn(name="fk_contato", referencedColumnName = "id")
	private Contato contato;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Telefone(){
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
	 * Obtém numero
	 * @param numero numero
	 * return numero
	 * @generated
	 */
	public java.lang.String getNumero(){
		return this.numero;
	}
	
	/**
	 * Define numero
	 * @param numero numero
	 * @generated
	 */
	public void setNumero(java.lang.String numero){
		this.numero = numero;
	}
	
	/**
	 * Obtém contato
	 * @param contato contato
	 * return contato
	 * @generated
	 */
	public Contato getContato(){
		return this.contato;
	}
	
	/**
	 * Define contato
	 * @param contato contato
	 * @generated
	 */
	public void setContato(Contato contato){
		this.contato = contato;
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
	    
	    if(!(obj instanceof Telefone))
	      return false;
	    
	    Telefone other = (Telefone)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}