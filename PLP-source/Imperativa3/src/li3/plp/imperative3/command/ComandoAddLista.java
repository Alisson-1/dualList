package li3.plp.imperative3.command;

import li3.plp.imperative1.command.Comando;
import li3.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li3.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li3.plp.imperative1.memory.EntradaVaziaException;
import li3.plp.imperative1.memory.ErroTipoEntradaException;
import li3.plp.imperative3.util.TipoDualList;
import li3.plp.imperative3.references.ListaDuplaEncadeada;
import li3.plp.expressions2.expression.Id;
import li3.plp.expressions2.expression.Expressao;
import li3.plp.expressions2.expression.Valor;
import li3.plp.expressions2.expression.ValorLista;
import li3.plp.expressions1.util.Tipo;
import li3.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li3.plp.expressions2.memory.IdentificadorNaoDeclaradoException;

/**
 * Comando: add(lista, valor)
 * Adiciona um elemento ao final da lista.
 */
public class ComandoAddLista implements Comando {

	private Id idLista;
	private Expressao expressaoValor;

	public ComandoAddLista(Id idLista, Expressao expressaoValor) {
		this.idLista = idLista;
		this.expressaoValor = expressaoValor;
	}

	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException,
			EntradaVaziaException, ErroTipoEntradaException {

		// 1. Obter ValorLista da variável
		Valor valorVariavel = ambiente.get(idLista);
		if (!(valorVariavel instanceof ValorLista)) {
			throw new RuntimeException("Variável " + idLista.getIdName() + " não é uma lista");
		}
		ValorLista valorLista = (ValorLista) valorVariavel;

		// 2. Obter lista diretamente
		ListaDuplaEncadeada lista = valorLista.getLista();

		// 3. Avaliar expressão do valor a adicionar
		Valor novoValor = expressaoValor.avaliar(ambiente);

		// 4. Adicionar na lista (modifica in-place!)
		lista.adicionarFim(novoValor);

		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {

		// Verificar que idLista é do tipo TipoDualList
		Tipo tipoVariavel = idLista.getTipo(ambiente);
		if (!tipoVariavel.eLista()) {
			return false;
		}

		// Verificar que expressaoValor tem o tipo correto
		TipoDualList tipoLista = (TipoDualList) tipoVariavel;
		boolean expressaoValida = expressaoValor.checaTipo(ambiente);
		boolean tipoCompativel = expressaoValor.getTipo(ambiente).eIgual(tipoLista.getTipoElemento());

		return expressaoValida && tipoCompativel;
	}
}
