package li3.plp.functional2.expression;

import li3.plp.expressions1.util.Tipo;
import li3.plp.expressions2.expression.Expressao;
import li3.plp.expressions2.expression.Valor;
import li3.plp.expressions2.memory.AmbienteCompilacao;
import li3.plp.expressions2.memory.AmbienteExecucao;
import li3.plp.expressions2.memory.VariavelJaDeclaradaException;
import li3.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ValorIrredutivel implements Valor {

	public Valor avaliar(AmbienteExecucao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return null;
	}

	public boolean checaTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return true;
	}

	public Tipo getTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return null;
	}

	public Expressao reduzir(AmbienteExecucao ambiente) {
		return this;
	}
	
	public ValorIrredutivel clone() {
		return this;
	}
}
