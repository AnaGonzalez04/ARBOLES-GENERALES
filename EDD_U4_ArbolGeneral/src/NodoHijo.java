/**
 *
 * @author anago
 */
public class NodoHijo {
    NodoGeneral direccionHijo;
    NodoHijo ant;
    NodoHijo sig;

    public NodoHijo(NodoGeneral hijoApuntar) {
        direccionHijo = hijoApuntar;
        ant = sig = null;
    }
}
