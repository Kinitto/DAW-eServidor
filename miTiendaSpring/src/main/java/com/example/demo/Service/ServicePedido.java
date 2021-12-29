package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ModelPedido;

@Service
public class ServicePedido {

	private List<ModelPedido> listaPedido = new ArrayList<>();

	public List<ModelPedido> findAll() {
		return listaPedido;
	}
	
	/**
	 * recibimos la id del pedido y encontramos cual es
	 * @param id
	 * @return
	 */

	public ModelPedido findById(long id) {
		ModelPedido result = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < listaPedido.size()) {
			if (listaPedido.get(i).getId() == id) {
				encontrado = true;
				result = listaPedido.get(i);
			} else {
				i++;
			}
		}

		return result;
	}
	/**
	 * recibimos un objeto pedido y lo editamos
	 * @param pedido
	 * @return
	 */

	public ModelPedido edit(ModelPedido pedido) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < listaPedido.size()) {
			if (listaPedido.get(i).getId() == pedido.getId()) {
				encontrado = true;
				listaPedido.remove(i);
				listaPedido.add(i, pedido);
			} else {
				i++;
			}
		}

		if (!encontrado)
			listaPedido.add(pedido);

		return pedido;
	}

	/**
	 * elimina un objeto pedido el cual lo busca por su id
	 * @param id
	 */
	public void delete(long id) {
		int i = 0;
		while (i < listaPedido.size()) {
			if (listaPedido.get(i).getId() == id) {
				listaPedido.remove(i);
			}
		}
	}

	/**
	 * obtiene el tamaño de la lista de pedido.
	 * @return
	 */
	public int cantidad() {
		return listaPedido.size();
	}
	
	/**
	 * añade un pedido
	 * @param pedido
	 * @return
	 */

	public ModelPedido add(ModelPedido pedido) {
		listaPedido.add(pedido);

		return pedido;
	}

}
