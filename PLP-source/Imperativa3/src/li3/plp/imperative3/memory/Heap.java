package li3.plp.imperative3.memory;

import java.util.HashMap;

/**
 * Heap para armazenamento dinâmico de references de dados.
 * Similar ao heap memory em C, armazena objetos alocados dinamicamente.
 */
public class Heap {
    private HashMap<Integer, Object> memoria;
    private int proximoId;

    public Heap() {
        this.memoria = new HashMap<>();
        this.proximoId = 1;
    }

    /**
     * Aloca um objeto na heap e retorna seu ID de referência.
     *
     * @param objeto o objeto a ser alocado
     * @return ID único da referência
     */
    public int alocar(Object objeto) {
        int id = proximoId++;
        memoria.put(id, objeto);
        return id;
    }

    /**
     * Obtém um objeto da heap pela sua referência.
     *
     * @param referenciaId ID da referência
     * @return o objeto armazenado
     */
    public Object obter(int referenciaId) {
        return memoria.get(referenciaId);
    }

    /**
     * Desaloca um objeto da heap (opcional, para GC manual).
     *
     * @param referenciaId ID da referência a desalocar
     */
    public void desalocar(int referenciaId) {
        memoria.remove(referenciaId);
    }

    /**
     * Retorna o número de objetos alocados na heap.
     */
    public int tamanho() {
        return memoria.size();
    }
}
