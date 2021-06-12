/**
 *
 * @author anago
 */
public class Grafo {
    NodoVertice vertice;
    
    public Grafo() {
        vertice = null; 
    }
    
    //-----------------------INSERTAR VERTICE------------------------------
    public boolean insertarVertice(char dato){
        NodoVertice nuevo = new NodoVertice(dato);
        if(nuevo == null){
            return false;
        }
        if(vertice == null){
            vertice = nuevo;
            return true;
        }
        irUltimo();
        vertice.sig = nuevo;
        nuevo.ant = vertice;
        return true;
    }
    
    public void irUltimo() {
        while(vertice.sig != null){
            vertice = vertice.sig;
        }
    }
    //-----------------------BUSCAR VERTICE------------------------------
    public NodoVertice buscarVertice(char dato) {
        if(vertice == null) {
            return null;
        }
        irPrimero();
        for(NodoVertice buscar = vertice; buscar != null; buscar = buscar.sig){
            if(buscar.dato == dato){
                return buscar;
            }
        }
        return null;
    }
    public void irPrimero() {
        while(vertice.ant != null){
            vertice = vertice.ant;
        }
    }
    //-----------------------INSERTAR ARISTA------------------------------
    public boolean insertarAristas(char origen, char destino){
        NodoVertice nodoOrigen = buscarVertice(origen);
        NodoVertice nodoDestino = buscarVertice(destino);
        
        if(nodoOrigen == null || nodoDestino == null){
            return false;
        }
        return nodoOrigen.insertarArista(nodoDestino);
    }
    //-----------------------ELIMINAR ARISTA------------------------------
    public boolean eliminarAristas(char origen, char destino){
        NodoVertice nodoOrigen = buscarVertice(origen);
        NodoVertice nodoDestino = buscarVertice(destino);
        
        if(nodoOrigen == null || nodoDestino == null){
            return false;
        }
        return nodoOrigen.eliminarArista(nodoDestino);
    }
    
    public boolean unSoloVertice(){
        return vertice.ant == null && vertice.sig == null;
    }
    //-----------------------ELIMINAR VERTICE------------------------------
    public boolean eliminarVertice (char dato){
        if(vertice == null){
            return false;
        }
        NodoVertice temp = new NodoVertice(dato);
        if(temp == null){
            return false;
        }
        if(temp.arista != null){
            return false;
        }
        quitarAristasDeOtrosVertices(temp);
        if(temp == vertice){
            if(unSoloVertice()){
                vertice = null;
            } else {
                vertice = temp.sig;
                temp.sig.ant = temp.sig = null;
                return true;
            }
        }
        if(temp.sig == null){
            temp.ant.sig = temp.ant = null;
            return true;
        }
        temp.ant.sig = temp.sig;
        temp.sig.ant = temp.ant;
        temp.sig = temp.ant = null;
        return true;
    }
    
    public void quitarAristasDeOtrosVertices(NodoVertice NodoEliminar){
        irPrimero();
        for(NodoVertice buscar = vertice; buscar != null; buscar = buscar.sig){
            buscar.eliminarArista(NodoEliminar);
        }
    }
}
