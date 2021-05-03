/**
 *
 * @author anago
 */
public class ColaPrioridad {
    protected Prioridad[] vector;
    protected int INI;
    protected int FIN;
    
    public ColaPrioridad(int tamaño){
        vector = new Prioridad[tamaño];
        INI = -1;
        FIN = -1;
    }
    
    public boolean insertar(Prioridad dato){
        if(ColaLlena() == true){
            return false;
        }
        FIN++;
        vector[FIN] = dato;
        if(INI == -1){
            INI = 0;
        }
        if(FIN >= 1){
            acomodo(dato);
        }
        return true;
    }
    
    public boolean eliminar(){
        if(ColaVacia() == true){
            return false;
        }
        if(HayUnDato()==true){
            INI = -1;
            FIN = -1;
            return true;
        }
        INI++;
        return true;
    }
    
    public void acomodo(Prioridad dato){
        Prioridad temporal;
        for(int i=FIN-1; i>=0; i--){
            if(dato.getNivel() > vector[i].getNivel()){
                temporal = vector[i];
                vector[i] = dato;
                vector[i+1] = temporal;
            }
        }
    }
    public boolean ColaLlena(){
        return FIN == vector.length-1;
    }
    public boolean ColaVacia(){
        return INI == 1 && FIN == -1; 
    }
    public boolean HayUnDato(){
        return INI == FIN; 
    }
    public Prioridad getValor(int pos){
        return vector[pos]; 
    }
    public int getINI(){
        return INI; 
    }
    public int getFIN(){
        return FIN; 
    }
}
