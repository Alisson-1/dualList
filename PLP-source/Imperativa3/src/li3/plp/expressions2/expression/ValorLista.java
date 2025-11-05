package li3.plp.expressions2.expression;

import li3.plp.expressions1.util.Tipo;
import li3.plp.imperative3.util.TipoLista;
import li3.plp.imperative3.references.ListaDuplaEncadeada;
import li3.plp.expressions2.memory.AmbienteCompilacao;

/**
 * Valor que representa uma lista.
 * Guarda referência direta à ListaDuplaEncadeada para toString() funcionar.
 */
public class ValorLista extends ValorConcreto<Integer> {

	private ListaDuplaEncadeada lista;  // Referência direta!
	private TipoLista tipo;  // Tipo da lista

	/**
	 * Construtor.
	 *
	 * @param referenciaId ID na heap (para compatibilidade)
	 * @param lista referência direta à lista
	 * @param tipo tipo da lista
	 */
	public ValorLista(int referenciaId, ListaDuplaEncadeada lista, TipoLista tipo) {
		super(referenciaId);
		this.lista = lista;
		this.tipo = tipo;
	}

	/**
	 * Retorna o ID da referência na heap.
	 */
	public int getReferenciaId() {
		return valor();
	}

	/**
	 * Retorna referência direta à lista.
	 */
	public ListaDuplaEncadeada getLista() {
		return lista;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) {
		return tipo;
	}

	@Override
	public String toString() {
		// Usa a lista diretamente!
		return lista.mostrar();
	}

	@Override
	public ValorLista clone() {
		return new ValorLista(getReferenciaId(), lista, tipo);
	}
}
