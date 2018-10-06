package br.com.pizza.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CIDADE" , schema = "PIZZA")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CIDADE_ID")
	private Long id;
	
	@Column(name = "CIDADE_NOME", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "cidade",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.LAZY,
			orphanRemoval = true,
			targetEntity = Cliente.class)
	private List<Cliente> clientes;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
		cliente.setCidade(this);
	}
	public void removeCliente(Cliente cliente) {
		this.clientes.remove(cliente);
		cliente.setCidade(null);
	}
	
}
