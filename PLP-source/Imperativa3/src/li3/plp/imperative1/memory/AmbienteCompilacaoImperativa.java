package li3.plp.imperative1.memory;

import li3.plp.expressions1.util.Tipo;
import li3.plp.expressions2.memory.*;

public interface AmbienteCompilacaoImperativa extends AmbienteCompilacao {

	public Tipo getTipoEntrada() throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
		EntradaVaziaException;

}
