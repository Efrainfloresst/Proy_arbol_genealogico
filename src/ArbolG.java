/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EFT
 */
public class ArbolG {
    
    Nodo raiz;

  
    public ArbolG(String D1,String D2){
        raiz = new Nodo(D1, D2);
        
    }
    public void AddHijo(String hijo,String padre){
        AddHijo(hijo,padre,raiz);
    }
    private void AddHijo(String hijo, String padre, Nodo r){
        if(r!=null){
          if(!Existe(hijo) && Existe(padre)){
              if(r.existeN(padre)){
                  if(ExistePaMa(padre, r) && estanCazados(r) ){ // si existe el padre o madre en el nodo insertamos hijo
                       Nodo a = new Nodo(hijo);
                      // r= BuscarNodo(padre,raiz);
                       r.getL().add(a); 
                  }else{ // buscamos en los hijos padre = dato1 o dato 2;
                      for (int i = 0; i < r.cantHijos(); i++) {
                           
                          if( estanCazados(r.getL().get(i)) && r.getL().get(i).getData1().equals(padre)|| r.getL().get(i).getData2().equals(padre)){
                               Nodo a = new Nodo(hijo); 
                              r.getL().get(i).getL().add(a); 
                          }
                      }
                  }
                // caso general..
              }else{   
                  if(!r.TieneHijos()){
                    if(ExistePaMa(padre, r) && estanCazados(r)){ // si existe el padre o madre en el nodo insertamos hijo
                       Nodo a = new Nodo(hijo);                      
                       r.getL().add(a);
                       }
                   }
                  else{
                        for (int i = 0; i < r.cantHijos(); i++) {
                            
                            AddHijo(hijo, padre, r.getL().get(i));
                        }
                    }
               
              }//end else
          }//end if existe  
      
      }
    }
//    public void AddHijo2(String hijo, String padre ){
//       if(!Existe(hijo) && Existe(padre) ){
//           // if(ExistePaMa(padre, r)){
//                Nodo a = new Nodo(hijo);
//             Nodo  r= BuscarNodo(padre,raiz);
//              if(estanCazados(r)){                 
//                r.getL().add(a);
//              }
//          //  }
//        }
//    }
    public void esposa(String x){
        raiz.setData2(x);
    }
    public void AddEsposa(String x,String p){
        if(!Existe(x) && Existe(p)){
            Nodo a = new Nodo(p,x);
            Nodo r = BuscarNodo(p,raiz);
             if(!estanCazados(r)){
                 
                 r.setData2(x); ;
             }
     
        }
    }
    public boolean estanCazados(Nodo x){
        if(x.getData2().length()==0){
            return false;
        }
        return true;
    }
    public Nodo BuscarNodo(String x){
        return BuscarNodo(x,raiz);
    }
    private Nodo BuscarNodo(String x, Nodo r){
        if(r!=null){
            if(r.existeN(x)){
                if(ExistePaMa(x,r)){ // si no esta en el padre o madre
                    return r;
                }else{ // buscar en los hijos
                    for (int i = 0; i < r.cantHijos(); i++) {
                        if(r.getL().get(i).getData1().equals(x) || r.getL().get(i).getData2().equals(x)){
                            return r.getL().get(i);
                        }
                    }//end for
                } 
            }     else{ // CASO GENERAL
                    if(ExistePaMa(x,r)){
                    return r;
                    }else{
                        for (int i = 0; i < r.cantHijos(); i++) {
                            return BuscarNodo(x,r.getL().get(i));
                        }
                    }
               
            }
            
        }
        return null;
    }
//    public Nodo BuscarNodo(String x,Nodo r){
//        if(Existe(x)){
//            if(ExistePaMa(x,r)){
//                return r;
//            }else{
//                for (int i = 0; i < r.cantHijos(); i++) {
//                    return BuscarNodo(x,r.getL().get(i));
//                      
//                }
//            }
//        }
//        return null;
//    }
    public boolean Existe(String x){
        return Existe(x,raiz);
    }
    
    private boolean Existe(String x,Nodo p){
       if(p!=null){
              if(p.existeN(x) ){
               return true;
           }else{ // caso general
           if(!p.TieneHijos()){// si no tiene hijos.
            return ExistePaMa(x, p) ; // Si "x" existe en dato 1 o dato 2;
            }else{
               for (int i = 0; i < p.cantHijos(); i++) {
                   if(Existe(x, p.getL().get(i)) ){
                       return true;
                   }
               }
               return false;
           }
        }
                
        }return false;
    }
    
         public boolean ExistePaMa(String x,Nodo r){
        if(r.getData1().equals(x)  || r.getData2().equals(x)){
            return true;
        }
        return false;
    }
//     
//    public int getHijo(String hijo,Nodo r){
//         
//        int i =0;
//        while(i>r.cantHijos() ){
//         if(r.getL().get(i).Data1.equals(hijo) || r.getL().get(i).Data2.equals(hijo) ){
//             // Si el padre o padre  esta el hijo retorna la posision de la lista caso contrario -1;
//            return i;    
//            }  
//         i++;
//        }
//       return -1;
//        
//        
//    }
    public boolean sonHermanos(String x, String y){
      return  sonHermanos(x,y,raiz);
    }
    private boolean sonHermanos(String x, String y, Nodo r){
        if(r!=null){
           
            if(Existe(x)&& Existe(y)){ // si existe X -y- Y
                if(!r.sinHijos()){
                    return false;
                }
                 if(r.existeN(x)){                    
                        if(r.existeHijo(x) && r.existeHijo(y)  ){ // si son hermanos X y Y
                      return true;
                       }

                }else{// caso gneral
                    if(!r.sinHijos()){
                    return false;
                    }else{
                        for (int i = 0; i < r.cantHijos(); i++) {
                            return sonHermanos(x,y,r.getL().get(i));
                        }
                    }
                    
                }   
            
                 
                 
                 
            }  //end if Existe X y Y  
        }//end if r!=null
        return false;
    } 
         
     public void print(){ // imprime el Nodo PAdre - PAdre y los HIjos.
        Nodo p=raiz;
        System.out.println( p.getData1()+" -  "+p.getData2());
      if(!p.sinHijos()){ /// si tiene hijos va imprimir sus hijos.
          System.out.println(" Sus Hijos son: ");
          for (int i=0; i< p.cantHijos(); i++){
          System.out.print(", "+ p.getL().get(i).getData1()); 
            }
          System.out.println(" ");
        }
     }
     
     public String ImpNodo(Nodo x){
       String resul = "";
       Nodo a=BuscarNodo(x.getData1());
       
       if(  !Existe(a.getData1())){
            resul = " no existe en el arbol ";
        }else{ 
         
          resul= a.getData1()+" - "+a.getData2();
         String nuevalinea = System.getProperty("line.separator");
         if(!a.sinHijos()){
          resul = resul + nuevalinea + " Sus Hijos son: " + nuevalinea;
          for (int i=0; i< a.cantHijos(); i++){
              resul = resul + ", "+ a.getL().get(i).getData1();
          
                }         
            }else{
             resul = resul + " No tienen Hijos";
         }
       } 
         return resul;             
     }
     
     
 
}// fin class;
