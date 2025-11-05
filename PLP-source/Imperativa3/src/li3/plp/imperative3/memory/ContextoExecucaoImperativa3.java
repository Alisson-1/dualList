package li3.plp.imperative3.memory;

import li3.plp.expressions2.expression.Id;
import li3.plp.expressions2.memory.Contexto;
import li3.plp.expressions2.memory.VariavelJaDeclaradaException;
import li3.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li3.plp.imperative1.memory.ContextoExecucaoImperativa;
import li3.plp.imperative1.memory.ListaValor;
import li3.plp.imperative3.declaration.DefProcedimento;

public class ContextoExecucaoImperativa3 extends ContextoExecucaoImperativa
		implements AmbienteExecucaoImperativa3 {

	/**
	 * O contexto de procedimentos faz as vezes de um contexto de execu��o que
	 * armazena apenas procedimentos.
	 */
	private Contexto<DefProcedimento> contextoProcedimentos;

	/**
	 * Heap para armazenamento dinâmico de references de dados.
	 */
	private Heap heap;

	/**
	 * Construtor da classe.
	 */
	public ContextoExecucaoImperativa3(ListaValor entrada) {
		super(entrada);
		contextoProcedimentos = new Contexto<DefProcedimento>();
		this.heap = new Heap();
	}

	@Override
	public void incrementa() {
		super.incrementa();
		this.contextoProcedimentos.incrementa();
	}

	@Override
	public void restaura() {
		super.restaura();
		this.contextoProcedimentos.restaura();
	}

	/**
	 * Mapeia o id no procedimento dado.
	 * 
	 * @exception ProcedimentoJaDeclaradoException
	 *                se j� existir um mapeamento do identificador nesta tabela.
	 */
	public void mapProcedimento(Id idArg, DefProcedimento procedimentoId)
			throws ProcedimentoJaDeclaradoException {
		try {
			this.contextoProcedimentos.map(idArg, procedimentoId);
		} catch (VariavelJaDeclaradaException e) {
			throw new ProcedimentoJaDeclaradoException(idArg);
		}

	}

	/**
	 * Retorna o procedimento mapeado ao id dado.
	 *
	 * @exception ProcedimentoNaoDeclaradoException
	 *                se n�o existir nenhum procedimento mapeado ao id dado
	 *                nesta tabela.
	 */
	public DefProcedimento getProcedimento(Id idArg)
			throws ProcedimentoNaoDeclaradoException {
		try {
			return this.contextoProcedimentos.get(idArg);
		} catch (VariavelNaoDeclaradaException e) {
			throw new ProcedimentoNaoDeclaradoException(idArg);
		}

	}

	/**
	 * Retorna a heap do ambiente.
	 */
	public Heap getHeap() {
		return heap;
	}

	/**
	 * Define a heap do ambiente.
	 */
	public void setHeap(Heap heap) {
		this.heap = heap;
	}
}
