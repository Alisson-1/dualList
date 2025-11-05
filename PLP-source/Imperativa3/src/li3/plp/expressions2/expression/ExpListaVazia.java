package li3.plp.expressions2.expression;

import li3.plp.imperative3.util.TipoLista;
import li3.plp.imperative3.references.ListaDuplaEncadeada;
import li3.plp.imperative3.memory.AmbienteExecucaoImperativa3;
import li3.plp.imperative3.memory.Heap;
import li3.plp.expressions1.util.Tipo;
import li3.plp.expressions2.memory.AmbienteCompilacao;
import li3.plp.expressions2.memory.AmbienteExecucao;
import li3.plp.expressions2.memory.VariavelJaDeclaradaException;
import li3.plp.expressions2.memory.VariavelNaoDeclaradaException;

/**
 * Expressão que cria uma lista vazia.
 * Usada na inicialização de variáveis do tipo lista.
 */
public class ExpListaVazia implements Expressao {

	private TipoLista tipo;

	public ExpListaVazia(TipoLista tipo) {
		this.tipo = tipo;
	}

	@Override
	public Valor avaliar(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// 1. Criar uma nova lista duplamente encadeada vazia
		ListaDuplaEncadeada lista = new ListaDuplaEncadeada(tipo.getTipoElemento());

		// 2. Alocar a lista na heap
		AmbienteExecucaoImperativa3 amb3 = (AmbienteExecucaoImperativa3) ambiente;
		Heap heap = amb3.getHeap();
		int referenciaId = heap.alocar(lista);

		// 3. Retornar ValorLista com a referência direta à lista e tipo
		return new ValorLista(referenciaId, lista, tipo);
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return tipo;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return tipo != null && tipo.eValido();
	}

	@Override
	public Expressao reduzir(AmbienteExecucao ambiente) {
		return this;
	}

	@Override
	public Expressao clone() {
		return new ExpListaVazia(tipo);
	}
}
