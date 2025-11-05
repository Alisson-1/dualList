package li3.plp.imperative3.util;

import li3.plp.expressions1.util.Tipo;

/**
 * Representa o tipo list<T> para listas duplamente encadeadas.
 */
public class TipoLista implements Tipo {

	private Tipo tipoElemento;

	public TipoLista(Tipo tipoElemento) {
		this.tipoElemento = tipoElemento;
	}

	@Override
	public String getNome() {
		return "list<" + tipoElemento.getNome() + ">";
	}

	@Override
	public boolean eInteiro() {
		return false;
	}

	@Override
	public boolean eBooleano() {
		return false;
	}

	@Override
	public boolean eString() {
		return false;
	}

	@Override
	public boolean eLista() {
		return true;
	}

	@Override
	public boolean eIgual(Tipo tipo) {
		if (!(tipo instanceof TipoLista)) {
			return false;
		}
		TipoLista outraLista = (TipoLista) tipo;
		return this.tipoElemento.eIgual(outraLista.tipoElemento);
	}

	@Override
	public boolean eValido() {
		return tipoElemento != null && tipoElemento.eValido();
	}

	@Override
	public Tipo intersecao(Tipo outroTipo) {
		if (this.eIgual(outroTipo)) {
			return this;
		}
		return null;
	}

	/**
	 * Retorna o tipo dos elementos da lista.
	 */
	public Tipo getTipoElemento() {
		return tipoElemento;
	}
}
