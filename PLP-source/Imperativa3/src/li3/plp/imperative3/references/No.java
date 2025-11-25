package li3.plp.imperative3.references;

import li3.plp.expressions2.expression.Valor;

/**
 * Representa um nó em uma lista duplamente encadeada.
 */
public class No {
	private Valor valor;
	private No anterior;
	private No proximo;

	public No(Valor valor) {
		this.valor = valor;
		this.anterior = null;
		this.proximo = null;
	}

	// Getters e Setters

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}
