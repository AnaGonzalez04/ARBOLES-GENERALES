/**
 *
 * @author anago
 */
public class Corrimiento extends ColaPrioridad{
    
    public Corrimiento(int tamaño) {
        super(tamaño);
    }
    
    public boolean insertar(Prioridad dato){
        boolean respuesta = super.insertar(dato);
        if(respuesta == true){
            return respuesta;
        }
        if(INI>0){
            corrimiento();
            return super.insertar(dato);
        }
        return false;
    }
    
    public void corrimiento(){
        int recibe = 0;
        int envia;
        for(envia = INI; envia <= FIN; envia ++, recibe++){
            vector[recibe] = vector[envia];
        }
        INI = 0;
        FIN = recibe-1;
    }
}
