package li3.plp.imperative3.util;

import static li3.plp.expressions1.util.ToStringProvider.listToString;

import java.util.ArrayList;
import java.util.List;

import li3.plp.expressions1.util.Tipo;

public class TipoProcedimento implements Tipo {

	private List<Tipo> tiposParametrosFormais = new ArrayList<Tipo>();

	public TipoProcedimento(List<Tipo> tiposParametrosFormais2) {
		this.tiposParametrosFormais.addAll(tiposParametrosFormais2);
	}

	public boolean eBooleano() {
		return false;
	}

	public boolean eIgual(Tipo tipo) {
		if (tipo instanceof TipoProcedimento) {
			TipoProcedimento tipoProc = (TipoProcedimento) tipo;

			// Verificar se têm o mesmo número de parâmetros
			if (tipoProc.tiposParametrosFormais.size() != this.tiposParametrosFormais.size()) {
				return false;
			}

			// Comparar cada tipo de parâmetro usando eIgual() em vez de equals()
			for (int i = 0; i < this.tiposParametrosFormais.size(); i++) {
				Tipo tipoThis = this.tiposParametrosFormais.get(i);
				Tipo tipoOutro = tipoProc.tiposParametrosFormais.get(i);
				if (!tipoThis.eIgual(tipoOutro)) {
					return false;
				}
			}

			return true;
		}

		return tipo.eIgual(this);
	}

	public boolean eInteiro() {
		return false;
	}

	public boolean eString() {
		return false;
	}

	public boolean eValido() {
		boolean retorno = true;
		for (Tipo tipo : tiposParametrosFormais) {
			retorno &= tipo.eValido();
		}

		return retorno;
	}

	public String getNome() {
		return listToString(this.tiposParametrosFormais, "{", "}", ",");
	}

	public Tipo intersecao(Tipo outroTipo) {
		if (outroTipo.eIgual(this))
			return this;
		else
			return null;
	}

}
