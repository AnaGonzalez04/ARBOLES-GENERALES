/**
 *
 * @author anago
 */
public class ListaPrioridadDoble {
    protected NodoDoble ini;
    protected NodoDoble fin;
    
    public ListaPrioridadDoble() {
        ini = fin = null;
    }
    public boolean insertar(char dato, int nivel){
        NodoDoble nuevo = new NodoDoble(dato, nivel);
        if(nuevo == null){
            return false;
        }
        if(listaDobleEstaVacia()){
            ini = fin = nuevo;
            return true;
        }
        if(hayMasDeUnNodo() || nuevo != ini){
            acomodo(nuevo);
        }
        return true;
    }
    public boolean eliminar(){
        if(listaDobleEstaVacia()){
            return false;
        }
        if(hayUnNodo()){
            ini = fin = null;
            return true;
        }
        NodoDoble temp = ini;
        ini = temp.getSig();
        ini.setAnt(null);
        temp.setSig(null);
        temp = null;
        return true;
    }
    
    public void acomodo(NodoDoble nuevo){
        NodoDoble actual = ini;
        do {
            if(nuevo.getNivel() > actual.getNivel()) { 
                if(!actual.equals(ini)){
                    actual.getAnt().setSig(nuevo);                    
                }
                actual.setAnt(nuevo);
                nuevo.setSig(actual);
                nuevo.setAnt(actual.getAnt());
                if(actual.equals(ini)) {
                    ini = nuevo;
                }
                break;
            } else if(nuevo.getNivel() <= actual.getNivel() && actual.equals(fin)) {
                actual.setSig(nuevo);
                nuevo.setAnt(actual);
                fin = nuevo;
                break;
            } else{
                actual = actual.getSig();
            }
        } while( actual != null);
    }
    
    public boolean listaDobleEstaVacia(){
        return ini == null;
    }
    public boolean hayUnNodo(){
        return ini == fin;
    }
    public NodoDoble getIni() {
        return ini;
    }
    public boolean hayMasDeUnNodo(){
        return ini.getSig() != ini;
    }   
}
