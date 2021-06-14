/**
 *
 * @author anago
 */
public class NodoGeneral {
    char dato;
    NodoHijo ini;
    NodoHijo fin;

    public NodoGeneral(char v) {
        dato = v;
        ini = fin = null;
    }
    //------------------------------ENLAZAR------------------------------------
    public boolean enlazar (NodoGeneral hijo){
        NodoHijo enlace = new NodoHijo(hijo);
        if(enlace == null){
            return false;
        }
        if(ini == null && fin == null){
            ini = fin = enlace;
            return true;
        }
        fin.sig = enlace;
        enlace.ant = fin;
        fin = enlace;
        return true;
    }
    //---------------------------OBTENER HIJO-----------------------------------
    public NodoGeneral obtenerHijo (char valorHijoBuscado){
        if(esHoja()){
            return null;
        }
        for(NodoHijo buscar = ini; buscar != null; buscar = buscar.sig){
            if(buscar.direccionHijo.dato == valorHijoBuscado){
                return buscar.direccionHijo;
            }
        }
        return null;
    }
    
    public boolean esHoja(){
        return ini == null && fin == null;
    }
    //-----------------------------DESENLAZAR-----------------------------------
    public boolean desenlazar(NodoGeneral hijo){
        if(ini == fin){
            if(fin.direccionHijo == hijo){
                ini = fin = null;
                return true;
            }
            return false;
        }
        
        NodoHijo temp = ini;
        if(ini.direccionHijo == hijo){
            ini = temp.sig;
            ini.ant = temp.sig = null;
            return true;
        }
        if(fin.direccionHijo == hijo){
            temp = fin;
            fin = temp.ant;
            fin.sig = temp.ant = temp = null;
            return true;
        }
        
        temp = temp.sig;
        while(temp.direccionHijo != hijo && temp != null){
            temp = temp.sig;
        }
        if(temp == null){
            return false;
        }
        temp.sig.ant = temp.ant;
        temp.ant.sig = temp.sig;
        temp.sig = temp.ant = temp = null;
        return true;        
    }
}
