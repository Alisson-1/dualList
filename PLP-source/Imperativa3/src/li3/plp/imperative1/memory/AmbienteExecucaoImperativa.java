package li3.plp.imperative1.memory;

import li3.plp.expressions2.expression.Id;
import li3.plp.expressions2.expression.Valor;
import li3.plp.expressions2.memory.AmbienteExecucao;
import li3.plp.expressions2.memory.VariavelNaoDeclaradaException;

public interface AmbienteExecucaoImperativa extends AmbienteExecucao {

	public void changeValor(Id idArg, Valor valorId)
			throws VariavelNaoDeclaradaException;

	public Valor read() throws EntradaVaziaException;

	public void write(Valor v);

	public ListaValor getSaida();
}
