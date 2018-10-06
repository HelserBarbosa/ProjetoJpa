package br.com.pizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO", schema = "PIZZA")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PEDIDO_ID")
	private Long id;
	
	@Column(name = "PIZZA_BROT")
	private Integer pizzaBrotinho;
	
	@Column(name = "PIZZA_GDE")
	private Integer pizzaGrande;
	
	@Column(name = "PIZZA_MEDIA")
	private Integer pizzaMedia;
	
	@Column(name = "PIZZA_MINI")
	private Integer pizzaMini;
	
	@Column(name = "PIZZA_BB")
	private Integer pizzaBb;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

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
	 * @return the pizzaBrotinho
	 */
	public Integer getPizzaBrotinho() {
		return pizzaBrotinho;
	}

	/**
	 * @param pizzaBrotinho the pizzaBrotinho to set
	 */
	public void setPizzaBrotinho(Integer pizzaBrotinho) {
		this.pizzaBrotinho = pizzaBrotinho;
	}

	/**
	 * @return the pizzaGrande
	 */
	public Integer getPizzaGrande() {
		return pizzaGrande;
	}

	/**
	 * @param pizzaGrande the pizzaGrande to set
	 */
	public void setPizzaGrande(Integer pizzaGrande) {
		this.pizzaGrande = pizzaGrande;
	}

	/**
	 * @return the pizzaMedia
	 */
	public Integer getPizzaMedia() {
		return pizzaMedia;
	}

	/**
	 * @param pizzaMedia the pizzaMedia to set
	 */
	public void setPizzaMedia(Integer pizzaMedia) {
		this.pizzaMedia = pizzaMedia;
	}

	/**
	 * @return the pizzaMini
	 */
	public Integer getPizzaMini() {
		return pizzaMini;
	}

	/**
	 * @param pizzaMini the pizzaMini to set
	 */
	public void setPizzaMini(Integer pizzaMini) {
		this.pizzaMini = pizzaMini;
	}

	/**
	 * @return the pizzaBb
	 */
	public Integer getPizzaBb() {
		return pizzaBb;
	}

	/**
	 * @param pizzaBb the pizzaBb to set
	 */
	public void setPizzaBb(Integer pizzaBb) {
		this.pizzaBb = pizzaBb;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
