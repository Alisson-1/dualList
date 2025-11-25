package li3.plp.imperative3.memory;

import li3.plp.expressions2.expression.Id;
import li3.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li3.plp.imperative3.declaration.DefProcedimento;

public interface AmbienteExecucaoImperativa3 extends AmbienteExecucaoImperativa {

	public void mapProcedimento(Id idArg, DefProcedimento procedimentoId)
			throws ProcedimentoJaDeclaradoException;

	public DefProcedimento getProcedimento(Id idArg)
			throws ProcedimentoNaoDeclaradoException;

	/**
	 * Retorna a heap para alocação dinâmica.
	 */
	public Heap getHeap();

	/**
	 * Define a heap do ambiente.
	 */
	public void setHeap(Heap heap);

}
