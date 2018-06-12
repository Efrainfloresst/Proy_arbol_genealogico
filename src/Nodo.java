/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EFT
 */
import java.util.ArrayList;


public class Nodo {
    
    String Data1;
    String Data2;
    ArrayList<Nodo> L;
    
    public Nodo(){
       L = new ArrayList();
        this.Data1 =  new String();
        this.Data2 =  new String();
     }
    public Nodo(String varon,String mujer){//Constructor 
        L = new ArrayList();
        this.Data1 = varon;
        this.Data2 = mujer;
    }
    
    public Nodo(String varon){
        this.Data1 = varon;
        this.Data2 =  new String();
        this.L = new ArrayList();
    }
    public int cantHijos(){
      return  L.size();
    }
    
    public boolean TieneHijos(){
        if (this.L.size() == 0) {
            return false;
        }
        return true;
    }
   public boolean existeN(String x){
       if(this.getData1().equals(x) || this.getData2().equals(x)){
           return true;
       }else{
           for (int i = 0; i < this.cantHijos(); i++) {
               if(this.getL().get(i).getData1().equals(x) || this.getL().get(i).getData2().equals(x) ){
                   return true;
               }
           }
       }
   return false;
   }
    public boolean existeHijo(String x){
    
           for (int i = 0; i < this.cantHijos(); i++) {
               if(this.getL().get(i).getData1().equals(x) ){
                   return true;
               }
           }
       
   return false;
   }
    
    public String getData1() {
        return Data1;
    }

    public String getData2() {
        return Data2;
    }

    public ArrayList<Nodo> getL() {
        return L;
    }

    public void setData1(String Data1) {
        this.Data1 = Data1;
    }

    public void setData2(String Data2) {
        this.Data2 = Data2;
    }

    public void setL(ArrayList<Nodo> L) {
        this.L = L;
    }
    
    //////////////////// 
    
    public void EliminarHijo(Nodo hijo){ //Elimina el Nodo hijo 
        this.L.remove(hijo);
    }
    
    public void ElimiHijoPos(int pos){ // Elimina el Nodo hijo en la posicion
        this.L.remove(pos);
    }
 
    public boolean datasLlenas(){ // si el dato varon o mujer esta llego = true;
        return this.getData1().length()>0 && this.getData2().length()>0;
        
    }
    
    public boolean sinHijos(){ // nodo hoja en otras palabras
        return this.L.size()==0;
    }
    
    public boolean sinEsposa(){ // falta el data2 (falta la esposa)
        return this.getData2().length()==0; // this.getData2()=="";
        
    }
    
//    public int compareTo(String otro) {
//        // DEVUELVE -1 => SI EL STRING DATA1 < Otro
//        // DEVUELVE 0 => SI EL STRING DATA1 == Otro
//        // DEVUELVE -1=> SI EL STRING DATA2 > Otro
//        //int i="A".compareTo("B");
//        if( this.getData1().compareTo(otro) ==0 || this.getData2().compareTo(otro)==0 ){
//        return 0;
//        } 
//        return-1;
//    }
}//Fin Class

