package li3.plp.imperative1.declaration;

import li3.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li3.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li3.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li3.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li3.plp.imperative1.memory.EntradaVaziaException;

public abstract class Declaracao {

	public abstract AmbienteExecucaoImperativa elabora(
			AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException;

	public abstract boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException;
}
