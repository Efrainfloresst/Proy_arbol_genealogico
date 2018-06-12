/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EFT
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                ArbolG G = new ArbolG("Adan","Eva");
              
                
                //System.out.println( G.Existe(x) );
                G.AddHijo("Cain", "Adan");
                G.AddHijo("Abel", "Eva");
                G.AddHijo("Brayan", "Eva");
                G.AddHijo("Forco", "Eva");
                
             
              
                
                G.print();
               System.out.println( "Existe Forco: "+G.Existe("Forco")  );
               G.AddEsposa("Ana","Cain");
               System.out.println("Tiene esposa de cain: " + G.Existe("Ana" ) );
              
                  G.AddHijo("Jon1", "Cain");     
                G.AddHijo("Jon2", "Cain");
                G.AddHijo("Jon3", "Cain");    
                G.AddHijo("Jon4", "Cain");
                G.AddHijo("Jon5", "Cain");
               
               System.out.println( "Hijo de Cain; "+ G.Existe("Jon4" )  );
               G.AddEsposa("carla","Jon1");
               System.out.println("Tiene esposa de Jon1: " + G.Existe("carla" ) );
               
                G.AddHijo("JrJon1", "Jon1");
                G.AddHijo("JrJon5", "Jon5");
                
               System.out.println( "Hijo de Jon1; "+ G.Existe("JrJon1" )  );
               System.out.println( "Hijo de Jon5; "+ G.Existe("JrJon5" )  );
//               System.out.println("-------OTRO ARBOL----------------");
//                ArbolG B = new ArbolG("Adan","Eva");
//                B.AddHijo2("Cain", "Adan");
//                B.AddHijo2("Abel", "Eva");
//                B.AddHijo2("Brayan", "Eva");
//                B.AddHijo2("Forco", "Eva");
//                
//                B.AddHijo2("Jon1", "Cain");     
//                B.AddHijo2("Jon2", "Cain");
//                B.AddHijo2("Jon3", "Cain");
//                B.AddHijo2("Jon4", "Cain");
//                B.AddHijo2("Jon5", "Cain");
//                
//               B.AddHijo2("bry1", "Brayan");
//               B.AddHijo2("bry2", "Brayan");
//               
//                G.AddHijo("tona", "Jon1");
//                 G.print();
//               System.out.println( G.Existe("tona")  );
  }
    
}
