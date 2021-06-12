/**
 *
 * @author anago
 */
public class NodoArista {
    NodoVertice direccion;
    NodoArista abajo;
    NodoArista arriba;
    
    public NodoArista(NodoVertice d){
    direccion = d;
    abajo = arriba = null;
    }
}