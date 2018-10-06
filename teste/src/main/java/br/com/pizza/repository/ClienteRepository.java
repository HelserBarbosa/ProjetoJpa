package br.com.pizza.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pizza.Util.JpaUtil;
import br.com.pizza.model.Cliente;

public class ClienteRepository {

	private EntityManager criarEntityManager() {
		return new JpaUtil().getEntityManager();
	}

	public void addCliente(Cliente cliente) throws Exception {
		EntityManager em = criarEntityManager();
		em.getTransaction().begin();
		if (cliente.getId() == null) {

			em.persist(cliente);

		} else {

			Cliente clienteUpdate = getCliente(cliente.getId());

			em.merge(clienteUpdate);
			clienteUpdate.setCidade(cliente.getCidade());
			clienteUpdate.setCnpj(cliente.getCnpj());
			clienteUpdate.setInscricaoEstadual(cliente.getInscricaoEstadual());
			clienteUpdate.setNome(cliente.getNome());
			clienteUpdate.setPedidos(cliente.getPedidos());

		}
		em.getTransaction().commit();
		em.close();
	}

	public boolean existeClientePeloNome(Cliente cliente) {
		EntityManager em = criarEntityManager();
		String jpql = "Select c from Cliente c where c.nome = :pNome";
		Query query = em.createQuery(jpql);
		query.setParameter("pNome", cliente.getNome());
		return query.getResultList().isEmpty() ? false
											   : true;

	}
	public boolean existeClientePorId(Integer id) {
		return  getCliente(id) == null? false : true;
	}

	public Cliente getCliente(Integer id) {
		EntityManager em = criarEntityManager();
		Cliente clienteEncontrado = em.find(Cliente.class, id);
		return clienteEncontrado;
	}
	
	public void deleteClientePorId(Integer id) {
		Cliente cliente = getCliente(id);
		EntityManager em = criarEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
	}
}
