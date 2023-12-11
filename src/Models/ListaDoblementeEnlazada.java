package Models;

import java.util.LinkedList;

public class ListaDoblementeEnlazada<T> {

    private LinkedList<T> lista;

    public ListaDoblementeEnlazada() {
        lista = new LinkedList<>();
    }

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public LinkedList<T> getLista() {
        return lista;
    }
}
