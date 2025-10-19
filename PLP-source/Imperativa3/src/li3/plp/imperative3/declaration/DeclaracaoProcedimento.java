package li3.plp.imperative3.declaration;

import li3.plp.expressions2.expression.Id;
import li3.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li3.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li3.plp.imperative1.declaration.Declaracao;
import li3.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li3.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li3.plp.imperative1.memory.EntradaVaziaException;
import li3.plp.imperative1.memory.ErroTipoEntradaException;
import li3.plp.imperative3.memory.AmbienteExecucaoImperativa3;
import java.util.List;

public class DeclaracaoProcedimento extends Declaracao {

	private Id id;
	private DefProcedimento defProcedimento;

	public DeclaracaoProcedimento(Id id, DefProcedimento defProcedimento) {
		super();
		this.id = id;
		this.defProcedimento = defProcedimento;
	}

	@Override
	public AmbienteExecucaoImperativa elabora(
			AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException {
	((AmbienteExecucaoImperativa3) ambiente).mapProcedimento(getId(),
		getDefProcedimento());
		return ambiente;
	}

	private Id getId() {
		return this.id;
	}

	@Override
    public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
	    throws IdentificadorJaDeclaradoException,
	    IdentificadorNaoDeclaradoException, EntradaVaziaException {
		boolean resposta;

		ambiente.map(id, defProcedimento.getTipo());

	li3.plp.imperative3.declaration.ListaDeclaracaoParametro parametrosFormais = getDefProcedimento()
				.getParametrosFormais();
		if (parametrosFormais.checaTipo(ambiente)) {
			ambiente.incrementa();
			ambiente = parametrosFormais.elabora(ambiente);
			resposta = getDefProcedimento().getComando().checaTipo(ambiente);
			ambiente.restaura();
		} else {
			resposta = false;
		}
		return resposta;
	}

	private DefProcedimento getDefProcedimento() {
		return this.defProcedimento;
	}
}
