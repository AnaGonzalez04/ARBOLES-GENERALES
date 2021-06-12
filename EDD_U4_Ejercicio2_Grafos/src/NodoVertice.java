/**
 *
 * @author anago
 */
public class NodoVertice {
    char dato;
    NodoVertice sig;
    NodoVertice ant;
    NodoArista arista;

    public NodoVertice(char d) {
        dato = d;
        sig = ant = null;
        arista = null;
    }
    //-----------------------INSERTAR ARISTA------------------------------
    public boolean insertarArista(NodoVertice direccion){
        NodoArista nuevo = new NodoArista(direccion);
        if(nuevo == null){
            return false;
        }
        if(arista == null){
            arista = nuevo;
            return true;
        }
        irUltimo();
        arista.arriba = nuevo;
        nuevo.abajo = arista;
        return true;
    }
    
    public void irUltimo() {
        while(arista.arriba != null){
            arista = arista.arriba;
        }
    }
    
    //-----------------------BUSCAR ARISTA------------------------------
    private NodoArista buscarArista(NodoVertice direccion) {
        if(arista == null) {
            return null;
        }
        irPrimero();
        for(NodoArista buscar = arista; buscar != null; buscar = buscar.arriba){
            if(buscar.direccion == direccion){
                return buscar;
            }
        }
        return null;
    }
    
    public void irPrimero() {
        while(arista.abajo != null){
            arista = arista.abajo;
        }
    }
    
    //-----------------------ELIMINAR ARISTA------------------------------
    public boolean eliminarArista (NodoVertice direccion){
        if(arista == null){
            return false;
        }
        NodoArista temp = new NodoArista(direccion);
        if(temp == null){
            return false;
        }
        if(temp == arista){
            if(unaSolaArista()){
                arista = null;
            } else {
                arista = arista.abajo;
                temp.abajo.arriba = temp.abajo = null;
            }
            return true;
        }
        
        if(temp.abajo == null){
            temp.arriba.abajo = temp.arriba = null;
            return true;
        }
        temp.arriba.abajo = temp.abajo;
        temp.abajo.arriba = temp.abajo;
        temp.abajo = temp.arriba = null;
        return true;
    }
    
    public boolean unaSolaArista(){
        return arista.abajo == null && arista.arriba == null;
    }
}
