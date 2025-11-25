package li3.plp.imperative3.references;

import li3.plp.expressions1.util.Tipo;
import li3.plp.expressions2.expression.Valor;

/**
 * Implementação de lista duplamente encadeada com operações imperativas.
 * Todas as operações modificam a lista in-place (efeitos colaterais).
 */
public class ListaDuplaEncadeada {

	private No cabeca;  // head
	private No cauda;   // tail
	private Tipo tipoElemento;

	public ListaDuplaEncadeada(Tipo tipoElemento) {
		this.tipoElemento = tipoElemento;
		this.cabeca = null;
		this.cauda = null;
	}

	/**
	 * Adiciona um elemento ao final da lista (operação imperativa).
	 * Modifica a lista in-place.
	 *
	 * @param valor o valor a ser adicionado
	 */
	public void adicionarFim(Valor valor) {
		No novoNo = new No(valor);

		if (cabeca == null) {
			// Lista vazia
			cabeca = novoNo;
			cauda = novoNo;
		} else {
			// Adicionar após o último nó
			cauda.setProximo(novoNo);
			novoNo.setAnterior(cauda);
			cauda = novoNo;
		}
	}

	/**
	 * Remove a primeira ocorrência de um valor da lista.
	 * Retorna true se encontrou e removeu, false caso contrário.
	 *
	 * @param valor o valor a ser removido
	 * @return true se removeu, false se não encontrou
	 */
	public boolean remover(Valor valor) {
		No atual = cabeca;

		while (atual != null) {
			// Comparar valores (usar equals ou comparação específica)
			if (valoresIguais(atual.getValor(), valor)) {
				removerNo(atual);
				return true;
			}
			atual = atual.getProximo();
		}

		return false;
	}

	/**
	 * Remove um nó específico da lista (método auxiliar).
	 */
	private void removerNo(No no) {
		if (no == cabeca && no == cauda) {
			// Único elemento
			cabeca = null;
			cauda = null;
		} else if (no == cabeca) {
			// Primeiro elemento
			cabeca = no.getProximo();
			cabeca.setAnterior(null);
		} else if (no == cauda) {
			// Último elemento
			cauda = no.getAnterior();
			cauda.setProximo(null);
		} else {
			// Elemento no meio
			no.getAnterior().setProximo(no.getProximo());
			no.getProximo().setAnterior(no.getAnterior());
		}
	}

	/**
	 * Atualiza a primeira ocorrência de valorAntigo para valorNovo.
	 *
	 * @param valorAntigo o valor a ser substituído
	 * @param valorNovo o novo valor
	 * @return true se encontrou e atualizou, false caso contrário
	 */
	public boolean atualizar(Valor valorAntigo, Valor valorNovo) {
		No atual = cabeca;

		while (atual != null) {
			if (valoresIguais(atual.getValor(), valorAntigo)) {
				atual.setValor(valorNovo);
				return true;
			}
			atual = atual.getProximo();
		}

		return false;
	}

	/**
	 * Retorna uma representação em string da lista.
	 * Formato: "elemento1 elemento2 elemento3"
	 */
	public String mostrar() {
		if (cabeca == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		No atual = cabeca;

		while (atual != null) {
			sb.append(atual.getValor().toString());
			if (atual.getProximo() != null) {
				sb.append(" ");
			}
			atual = atual.getProximo();
		}

		return sb.toString();
	}

	/**
	 * Verifica se dois valores são iguais.
	 * Usa toString() para comparação.
	 */
	private boolean valoresIguais(Valor v1, Valor v2) {
		return v1.toString().equals(v2.toString());
	}

	/**
	 * Verifica se a lista está vazia.
	 */
	public boolean estaVazia() {
		return cabeca == null;
	}

	public Tipo getTipoElemento() {
		return tipoElemento;
	}

	public No getCabeca() {
		return cabeca;
	}

	public No getCauda() {
		return cauda;
	}
}
