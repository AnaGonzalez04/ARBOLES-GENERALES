/**
 *
 * @author anago
 */
public class ArbolGeneral {
    NodoGeneral raiz;

    public ArbolGeneral() {
        raiz = null;
    }
    //------------------------------INSERTAR------------------------------------
    public boolean insertar (char dato, String path){
        if(raiz == null){
            raiz = new NodoGeneral(dato);
            if(raiz == null){
                return false;
            }
            return true;
        }
        
        if(path.isEmpty()){
            return false;
        }
        NodoGeneral padre = buscarNodoRecursivo(path, raiz);
        if(padre == null){
            return false;
        }
        
        NodoGeneral hijoYaExiste = buscarNodoRecursivo(path + "/" + dato, raiz);
        if(hijoYaExiste != null){
            return false;
        }
        
        NodoGeneral nuevo = new NodoGeneral(dato);
        return padre.enlazar(nuevo);
    }
    //-----------------------------NO RECURSIVO-----------------------------------
    private NodoGeneral buscarNodo(String path){
        path = path.substring(1);
        String vector[] = path.split("/");
        if(vector[0].charAt(0) == raiz.dato){
            if(vector.length == 1){
                return raiz;
            }
            NodoGeneral padre = raiz;
            for(int i=1; i<vector.length; i++){
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre == null){
                    return null;
                }
            }
            return padre;
        }
        return null;
    }
    
    //-----------------------------RECURSIVO---------------------------------
    public NodoGeneral buscarNodoRecursivo(String path, NodoGeneral nodo){
        path = path.substring(1);
        String vector[] = path.split("/");
        if(vector.length == 1){
            if(vector[0].charAt(0) == nodo.dato){
                return nodo;
            }
            return null;
        }
        nodo = nodo.obtenerHijo(vector[1].charAt(0));
        if (nodo == null) {
            return null;
        }
        return buscarNodoRecursivo(path.substring(1), nodo);
    }

    //------------------------------ELIMINAR------------------------------------
    public boolean eliminar (String path){
        if(raiz == null){    
            return false;
        }
        NodoGeneral hijo = buscarNodo(path);
        if(hijo == null){
            return false;
        }
        if(!hijo.esHoja()){
            return false;
        }
        
        String pathPadre = obtenerPathPadre(path);
        NodoGeneral padre = buscarNodo(path);
        
        return padre.desenlazar(hijo);
    }
    
    private String obtenerPathPadre(String path){
        int posicionAntesUltimaDiagonal = path.lastIndexOf("/")-1;
        return path.substring(0, posicionAntesUltimaDiagonal);
    }
}
