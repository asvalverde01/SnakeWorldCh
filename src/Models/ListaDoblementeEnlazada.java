package Models;

import java.util.LinkedList;

public class ListaDoblementeEnlazada {
    private LinkedList<Participante> lista;

    public ListaDoblementeEnlazada() {
        lista = new LinkedList<>();
    }

    public void agregar(Participante participante) {
        lista.add(participante);
    }

    public LinkedList<Participante> getLista() {
        return lista;
    }
    
}
