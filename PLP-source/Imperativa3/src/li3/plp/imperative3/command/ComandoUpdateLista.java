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
 * Comando: update(lista, valorAntigo, valorNovo)
 * Atualiza a primeira ocorrência de valorAntigo para valorNovo.
 */
public class ComandoUpdateLista implements Comando {

	private Id idLista;
	private Expressao expressaoValorAntigo;
	private Expressao expressaoValorNovo;

	public ComandoUpdateLista(Id idLista, Expressao expressaoValorAntigo, Expressao expressaoValorNovo) {
		this.idLista = idLista;
		this.expressaoValorAntigo = expressaoValorAntigo;
		this.expressaoValorNovo = expressaoValorNovo;
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

		// 3. Avaliar valores
		Valor valorAntigo = expressaoValorAntigo.avaliar(ambiente);
		Valor valorNovo = expressaoValorNovo.avaliar(ambiente);

		// 4. Atualizar na lista
		lista.atualizar(valorAntigo, valorNovo);

		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {

		Tipo tipoVariavel = idLista.getTipo(ambiente);
		if (!tipoVariavel.eLista()) {
			return false;
		}

		TipoDualList tipoLista = (TipoDualList) tipoVariavel;
		Tipo tipoElemento = tipoLista.getTipoElemento();

		boolean antigoValido = expressaoValorAntigo.checaTipo(ambiente) &&
								expressaoValorAntigo.getTipo(ambiente).eIgual(tipoElemento);
		boolean novoValido = expressaoValorNovo.checaTipo(ambiente) &&
							expressaoValorNovo.getTipo(ambiente).eIgual(tipoElemento);

		return antigoValido && novoValido;
	}
}
