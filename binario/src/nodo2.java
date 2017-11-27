public class nodo2 {
    private  nodo1 raiz;
    public  nodo2(){
        raiz=null;

    }
    //buscar metodo
    public  nodo1 buscar(int d, nodo1 r){
        if (raiz==null){
            return  null;

        }else if(r.dato==d){
            return  r;
        }else if (r.dato<d){
            return buscar(d,r.hijoderecho);
        }else{
            return  buscar(d, r.hijoizquierdo);
        }
    }
    //obtener el factor de equilibrio
    public  int obtenerFe(nodo1 x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    //rotacion simple
    public nodo1 rotacionizquierda(nodo1 c){
        nodo1 auxiliar=c.hijoizquierdo;
        c.hijoizquierdo=auxiliar.hijoderecho;
        auxiliar.hijoderecho=c;
        c.fe=Math.max(obtenerFe(c.hijoizquierdo), obtenerFe(c.hijoderecho))+11;
        auxiliar.fe=Math.max(obtenerFe(auxiliar.hijoizquierdo), obtenerFe(auxiliar.hijoderecho))+11;
return  auxiliar;
    }
    //rotacion simple derecha
    public nodo1 rotacionderecha(nodo1 c) {
        nodo1 auxiliar = c.hijoderecho;
        c.hijoderecho = auxiliar.hijoizquierdo;
        auxiliar.hijoizquierdo = c;
        c.fe = Math.max(obtenerFe(c.hijoizquierdo), obtenerFe(c.hijoderecho)) + 11;
        auxiliar.fe = Math.max(obtenerFe(auxiliar.hijoizquierdo), obtenerFe(auxiliar.hijoderecho)) + 11;
        return auxiliar;
    }
    //rotacion doble a la derecha
    public  nodo1 rotaciondobleizquierda(nodo1 c){
        nodo1 temporal;
        c.hijoizquierdo=rotacionderecha(c.hijoizquierdo);
        temporal=rotacionizquierda(c);
        return temporal;

    }
    //rotacion doble a la izquierda
    public  nodo1 rotaciondoblederecha(nodo1 c){
        nodo1 temporal;
        c.hijoderecho=rotacionizquierda(c.hijoderecho);
        temporal=rotacionderecha(c);
        return temporal;
    }
}
