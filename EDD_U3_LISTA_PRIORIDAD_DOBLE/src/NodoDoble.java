/**
 *
 * @author anago
 */
public class NodoDoble {
    private NodoDoble sig;
    private NodoDoble ant;
    private char dato;
    private int nivel;

    public NodoDoble(char dato, int nivel) {
        this.sig = sig;
        this.ant = ant;
        this.dato = dato;
        this.nivel = nivel;
    }

    NodoDoble() {
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoDoble getSig() {
        return sig;
    }

    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    public NodoDoble getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return dato + "," + nivel;
    }
    
}
