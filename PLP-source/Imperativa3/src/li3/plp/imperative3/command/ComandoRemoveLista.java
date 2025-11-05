package li3.plp.imperative3.command;

import li3.plp.imperative1.command.Comando;
import li3.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li3.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li3.plp.imperative1.memory.EntradaVaziaException;
import li3.plp.imperative1.memory.ErroTipoEntradaException;
import li3.plp.imperative3.util.TipoLista;
import li3.plp.imperative3.references.ListaDuplaEncadeada;
import li3.plp.expressions2.expression.Id;
import li3.plp.expressions2.expression.Expressao;
import li3.plp.expressions2.expression.Valor;
import li3.plp.expressions2.expression.ValorLista;
import li3.plp.expressions1.util.Tipo;
import li3.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li3.plp.expressions2.memory.IdentificadorNaoDeclaradoException;

/**
 * Comando: remove(lista, valor)
 * Remove a primeira ocorrência do valor da lista.
 */
public class ComandoRemoveLista implements Comando {

	private Id idLista;
	private Expressao expressaoValor;

	public ComandoRemoveLista(Id idLista, Expressao expressaoValor) {
		this.idLista = idLista;
		this.expressaoValor = expressaoValor;
	}

	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException,
			EntradaVaziaException, ErroTipoEntradaException {

		// 1. Obter ValorLista
		Valor valorVariavel = ambiente.get(idLista);
		if (!(valorVariavel instanceof ValorLista)) {
			throw new RuntimeException("Variável " + idLista.getIdName() + " não é uma lista");
		}
		ValorLista valorLista = (ValorLista) valorVariavel;

		// 2. Obter lista diretamente
		ListaDuplaEncadeada lista = valorLista.getLista();

		// 3. Avaliar valor a remover
		Valor valorRemover = expressaoValor.avaliar(ambiente);

		// 4. Remover da lista
		lista.remover(valorRemover);

		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {

		Tipo tipoVariavel = idLista.getTipo(ambiente);
		if (!tipoVariavel.eLista()) {
			return false;
		}

		TipoLista tipoLista = (TipoLista) tipoVariavel;
		return expressaoValor.checaTipo(ambiente) &&
				expressaoValor.getTipo(ambiente).eIgual(tipoLista.getTipoElemento());
	}
}
