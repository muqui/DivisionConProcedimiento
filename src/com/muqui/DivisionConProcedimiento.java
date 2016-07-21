/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muqui;

/**
 *
 * @author mq12
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;	
public class DivisionConProcedimiento {

	public List<List<String>>  procedimiento1(String dividendo, String divisor) {
        String originalString = dividendo;
        List<List<String>> procedimiento = new ArrayList<List<String>>();
        List<String> cocientes = new ArrayList<String>();
        List<String> linea = null;
        String ayuda = null;
        //= new ArrayList<String>();
        int apuntador = divisor.length();
//        System.out.println("apuntador " + apuntador);
        int size = 0;
        int subdivisor = 0;
        int cociente = 0;
        int residuo = 0;
        float resultado = Float.valueOf(dividendo) / Float.valueOf(divisor);
        int modulo = Integer.valueOf(dividendo) % Integer.valueOf(divisor);
//        System.out.println("modulo " + modulo);
        String cadena = "" + resultado;
        int original = dividendo.length();
//        System.out.println("original " + dividendo.length() + " nuevo " + cadena.length());

        if (modulo != 0) {
            for (int i = dividendo.length(); i < cadena.length() - 1 + (apuntador); i++) {
//          System.out.println("fixer "+ i);
                dividendo = dividendo + "0";
            }
        }

        size = dividendo.length();

//        System.out.println("Nuevo dividendo " + dividendo);
//        System.out.println("resultado " + resultado + " tamaño " + size);
        subdivisor = Integer.valueOf(dividendo.substring(0, divisor.length()));
        if (subdivisor < Integer.parseInt(divisor)) {
            subdivisor = Integer.valueOf(dividendo.substring(0, (divisor.length() + 1)));
            apuntador = divisor.length() + 1;
//            System.out.println("apuntador condicion " + apuntador);
        }

        cociente = subdivisor / Integer.valueOf(divisor);
        for (int i = 1; i <= size; i++) {
            cocientes.add("");
        }
        cocientes.add(apuntador - 1, "" + cociente);
//        System.out.println("subduvisor " + subdivisor);
//        System.out.println("cociente " + cociente);
        residuo = subdivisor % Integer.valueOf(divisor);
//        System.out.println("residuo " +  residuo);

//        System.out.println("CICLO ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: ");
        while (apuntador < size) {
//            System.out.println("A P U N T A D O R &&&&&&&&&&&&&&&&&&&&&&&&&&& "  + apuntador);
            linea = new ArrayList<String>();
            for (int i = 1; i <= size; i++) {
                linea.add("");

            }
            // System.out.println("linea " + linea);
            ayuda = residuo + dividendo.substring(apuntador, apuntador + 1);

//            System.out.println("ayuda lenght " +  ayuda.length() );
            //tamaño del subdivisor
            int talmaSubdivisor = ayuda.length();
            int apuntadorActual = (apuntador + 1) - ayuda.length();
            for (int i = 0; i < talmaSubdivisor; i++) {
//                System.out.println(ayuda.substring(i, i+1));
//                System.out.println("apuntadorActual " + apuntadorActual);
                linea.add(apuntadorActual, ayuda.substring(i, i + 1));
                apuntadorActual++;
            }

            subdivisor = (Integer.valueOf("" + residuo + dividendo.substring(apuntador, apuntador + 1)));
//            System.out.println("subduvisor " + ayuda );
            apuntador++;
            cociente = subdivisor / Integer.valueOf(divisor);
//            System.out.println( " cociente  " + cociente);
            //   cocientes.add(apuntador, "" + cociente);
            //  cocientes.add("" + cociente);
            residuo = subdivisor % Integer.valueOf(divisor);
            if (apuntador == original + 1) {
//                System.out.println("apuntador " + apuntador);
                cocientes.add(apuntador - 1, "." + cociente);

                // cocientes.remove(size-1);
            } else {
                cocientes.add(apuntador - 1, "" + cociente);
                //  cocientes.remove(size-1);
            }
//            System.out.println("cociente " + cociente);
//            System.out.println("residuo " + residuo);
//System.out.println("linea " + linea);
            //Elimina los espacios de mas  
            int tempSize = linea.size();
            for (int i = tempSize; i > dividendo.length(); i--) {
                linea.remove(i - 1);
              //  System.out.println("posicion " + i);
            }

            procedimiento.add(linea);

        }

        linea = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            linea.add("");
        }
        String residuoString = "" + residuo;
//        System.out.println("residuo: " +  residuo +  " residuo string: "+  residuoString + " tamaño residuo: " +  residuoString.length());
        int talmaSubdivisor = residuoString.length();
        int apuntadorActual = (apuntador) - residuoString.length();
        for (int i = 0; i < talmaSubdivisor; i++) {
//               System.out.println("apuntadorActual " + apuntadorActual);
            linea.add(apuntadorActual, residuoString.substring(i, i + 1));
            apuntadorActual++;
        }
//            System.out.println("lires " + linea);
         
          //Elimina los espacios de mas  
            int tempSize1 = linea.size();
            for (int i = tempSize1; i > dividendo.length(); i--) {
                linea.remove(i - 1);
               // System.out.println("posicion " + i);
            }
 
        procedimiento.add(linea);

        
        /*
        Eliminar valores de mas
        */
         int tempSize = cocientes.size();
            for (int i = tempSize; i > dividendo.length(); i--) {
                cocientes.remove(i - 1);
               // System.out.println("posicion " + i);
            }
        
        procedimiento.add(0, cocientes);

        
        
        
        
        
        
//        linea = new ArrayList<String>();
//        for (int i = 0; i < dividendo.length(); i++) {
////            System.out.println("char dividendo " + dividendo.substring(i, i+1));
//            linea.add(dividendo.substring(i, i + 1));
//        }
 linea = new ArrayList<String>();
        for (int i = 0; i < originalString.length(); i++) {
//            System.out.println("char dividendo " + dividendo.substring(i, i+1));
            linea.add(originalString.substring(i, i + 1));
        }
        procedimiento.add(1, linea);
        System.out.println("");
        System.out.println("");

        Iterator iter = procedimiento.iterator();

        while (iter.hasNext()) {
           
            System.out.println("Final" + iter.next());
           // List<String> temp = (List<String>) iter.next(); 
        }
        
return procedimiento;
	}
	public List<List<String>> procedimiento3(String dividendo, String divisor) {
        String dividendoOriginal = dividendo;
        String divisorOriginal = divisor;
        int posicionFinalPunto = 0;
        /*
        Si dividendo y divisor tienen punto decimal
         */
        if (divisor.indexOf('.') > 0 && dividendo.indexOf('.') > 0) {
            int divisorSize = divisor.length() - 1;
            int posPuntoDivisor = divisor.indexOf('.');
            int cantidadDecimalDivisor = divisorSize - posPuntoDivisor;
            int dividendoSize = dividendo.length() - 1;
            int posPuntoDividendo = dividendo.indexOf('.');
            int cantidadDecimalDividendo = dividendoSize - posPuntoDividendo;
            System.out.println(divisor + " divisor tamaño " + divisorSize + " posicion punto  " + posPuntoDivisor + "cantidad decimales " + cantidadDecimalDivisor);
            System.out.println(dividendo + " dividendo tamaño " + dividendoSize + " posicion punto  " + posPuntoDividendo + "cantidad decimales " + cantidadDecimalDividendo);
            //rellenar los espacios que se recorren
            if (cantidadDecimalDivisor > cantidadDecimalDividendo) {
                int agregar = cantidadDecimalDivisor - cantidadDecimalDividendo;
                System.out.println("faltan ceros" + agregar);
                for (int i = 0; i < agregar; i++) {
                    dividendo = dividendo + "0";
                }
            }
        } else /*
        Si  divisor tienen punto decimal
         */ if (divisor.indexOf('.') > 0) {
                int divisorSize = divisor.length() - 1;
                int posPuntoDivisor = divisor.indexOf('.');
                int cantidadDecimalDivisor = divisorSize - posPuntoDivisor;

                System.out.println(divisor + " divisor tamaño " + divisorSize + " posicion punto  " + posPuntoDivisor + "cantidad decimales " + cantidadDecimalDivisor);

                for (int i = 0; i < cantidadDecimalDivisor; i++) {
                    dividendo = dividendo + "0";
                }

            }

        divisor = divisor.replace(".", "");
        dividendo = dividendo.replace(".", "");
        System.out.println("dividendo " + dividendo);
        System.out.println("divisor " + divisor);

        String originalString = dividendo;
        List<List<String>> procedimiento = new ArrayList<List<String>>();
        List<String> cocientes = new ArrayList<String>();
        List<String> linea = null;
        String ayuda = null;
        //= new ArrayList<String>();
        int apuntador = divisor.length();
      //  System.out.println("set apuntador GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG=   " + apuntador);
        int size = 0;
        int subdivisor = 0;
        int cociente = 0;
        int residuo = 0;
        float resultado = Float.valueOf(dividendo) / Float.valueOf(divisor);
        int modulo = Integer.valueOf(dividendo) % Integer.valueOf(divisor);
//        System.out.println("modulo " + modulo);
        String cadena = "" + resultado;
        int original = dividendo.length();
//        System.out.println("original " + dividendo.length() + " nuevo " + cadena.length());

        if (modulo != 0) {
            for (int i = dividendo.length(); i < cadena.length() - 1 + (apuntador); i++) {
//          System.out.println("fixer "+ i);
                dividendo = dividendo + "0";
            }
        }

        size = dividendo.length();
        System.out.println("PUNTO FINAL BBBBBBBBBBBBBBBBBBBBBBBBBBB========= " + posicionFinalPunto);
         posicionFinalPunto = original + 1;
         // System.out.println("posicionFinalPunto " + posicionFinalPunto);
          if (dividendoOriginal.indexOf('.') > 0  && divisorOriginal.indexOf('.') > 0){
        	//  System.out.println("los dos tienen decimaal " + posicionFinalPunto);
        	  int divisorSize = divisorOriginal.length() - 1;
              int posPuntoDivisor = divisorOriginal.indexOf('.');
              int cantidadDecimalDivisor = divisorSize - posPuntoDivisor;
              int dividendoSize = dividendoOriginal.length() - 1;
              int posPuntoDividendo = dividendoOriginal.indexOf('.');
              int cantidadDecimalDividendo = dividendoSize - posPuntoDividendo;
             // System.out.println( "cantidad decimales Divisor xxxxxxxxxxx" + cantidadDecimalDivisor);
             // System.out.println( "cantidad decimales Dividendo xxxxxxxxxx" + cantidadDecimalDividendo);
             // System.out.println("posPuntoDivisor " + posPuntoDivisor +  " posPuntoDividendo " + posPuntoDividendo);
              if(cantidadDecimalDividendo > cantidadDecimalDivisor){
            	  posicionFinalPunto = original + 1 -(cantidadDecimalDividendo - cantidadDecimalDivisor);
              }
        	 // posicionFinalPunto = original + 1;
          }
          else
        if (dividendoOriginal.indexOf('.') > 0) {
           // System.out.println("solo dividendo con decimal");

            int dividendoSize = dividendoOriginal.length() - 1;
            
            int posPuntoDividendo = dividendoOriginal.indexOf('.');
            posicionFinalPunto = original + 1 - (dividendoSize - posPuntoDividendo);
          //  System.out.println(" dividendo tamaño " + dividendoSize + " posicion punto  " + posPuntoDividendo + "Posicion del punto decimal en el dividendo " + posicionFinalPunto);
           //  System.out.println("posicionFinalPunto " + posicionFinalPunto);
        } 
           
        
      //  System.out.println("dividendoOriginal " + dividendoOriginal + " divisor original " + divisorOriginal);
        //  posicionFinalPunto = original + 1; 
       
//        System.out.println("resultado " + resultado + " tamaño " + size);
          
          System.out.println("PUNTO FINAL BBBBBBBBBBBBBBBBBBBBBBBBBBB========= " + posicionFinalPunto);
        subdivisor = Integer.valueOf(dividendo.substring(0, divisor.length()));
        if (subdivisor < Integer.parseInt(divisor)) {
            subdivisor = Integer.valueOf(dividendo.substring(0, (divisor.length() + 1)));
            apuntador = divisor.length() + 1;
//            System.out.println("apuntador condicion " + apuntador);
        }

        cociente = subdivisor / Integer.valueOf(divisor);
        for (int i = 1; i <= size; i++) {
            cocientes.add("");
        }
        if(apuntador  > posicionFinalPunto){
      	   System.out.println("APUNTADOR   punto no estra al ciclo::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " );
      	   for (int i = 0; i <= apuntador-2; i++) {
      		   if(i == posicionFinalPunto-1){
      			 cocientes.add(i, ".0");
      		   }
      		   else{
      			 cocientes.add(i, "0");
      		   }
                 
                 System.out.println("APUNTADOR MUQUI get coccisonetes::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " + cocientes.get(i));
             }
      	  // for(int i = 1; i < (apuntador-1) ; i++){
      	//	   System.out.println(" ciclo::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " + i);
      		//   cocientes.add(i - 1, "0");
      	 //  }
      	 
         }
        cocientes.add(apuntador - 1, "" + cociente);
//        System.out.println("subduvisor " + subdivisor);
//        System.out.println("cociente " + cociente);
        residuo = subdivisor % Integer.valueOf(divisor);
//        System.out.println("residuo " +  residuo);
        System.out.println("APUNTADOR MUQUI::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " + apuntador);
   
      
        while (apuntador < size) {
             if (apuntador == posicionFinalPunto) {
                System.out.println("apuntador " + apuntador + "Poscion punto decimal " + posicionFinalPunto);
                cocientes.add(apuntador - 1, "." + cociente);

                // cocientes.remove(size-1);
            }
          //  System.out.println("A P U N T A D O R &&&&&&&&&&&&&&&&&&&&&&&&&&& "  + apuntador);
            linea = new ArrayList<String>();
            for (int i = 1; i <= size; i++) {
                linea.add("");

            }
            // System.out.println("linea " + linea);
            ayuda = residuo + dividendo.substring(apuntador, apuntador + 1);

//            System.out.println("ayuda lenght " +  ayuda.length() );
            //tamaño del subdivisor
            int talmaSubdivisor = ayuda.length();
            int apuntadorActual = (apuntador + 1) - ayuda.length();
            for (int i = 0; i < talmaSubdivisor; i++) {
//                System.out.println(ayuda.substring(i, i+1));
//                System.out.println("apuntadorActual " + apuntadorActual);
                linea.add(apuntadorActual, ayuda.substring(i, i + 1));
                apuntadorActual++;
            }

            subdivisor = (Integer.valueOf("" + residuo + dividendo.substring(apuntador, apuntador + 1)));
//            System.out.println("subduvisor " + ayuda );
            apuntador++;
            cociente = subdivisor / Integer.valueOf(divisor);
//            System.out.println( " cociente  " + cociente);
            //   cocientes.add(apuntador, "" + cociente);
            //  cocientes.add("" + cociente);
            residuo = subdivisor % Integer.valueOf(divisor);
            if (apuntador == posicionFinalPunto) {
              //  System.out.println("apuntador " + apuntador + "Poscion punto decimal " + posicionFinalPunto);
                cocientes.add(apuntador - 1, "." + cociente);

                // cocientes.remove(size-1);
            } else {
                cocientes.add(apuntador - 1, "" + cociente);
                //  cocientes.remove(size-1);
            }
//            System.out.println("cociente " + cociente);
//            System.out.println("residuo " + residuo);
//System.out.println("linea " + linea);
            //Elimina los espacios de mas  
            int tempSize = linea.size();
            for (int i = tempSize; i > dividendo.length(); i--) {
                linea.remove(i - 1);
                //  System.out.println("posicion " + i);
            }

            procedimiento.add(linea);

        }
   
        linea = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            linea.add("");
        }
        String residuoString = "" + residuo;
//        System.out.println("residuo: " +  residuo +  " residuo string: "+  residuoString + " tamaño residuo: " +  residuoString.length());
        int talmaSubdivisor = residuoString.length();
        int apuntadorActual = (apuntador) - residuoString.length();
        for (int i = 0; i < talmaSubdivisor; i++) {
//               System.out.println("apuntadorActual " + apuntadorActual);
            linea.add(apuntadorActual, residuoString.substring(i, i + 1));
            apuntadorActual++;
        }
//            System.out.println("lires " + linea);

        //Elimina los espacios de mas  
        int tempSize1 = linea.size();
        for (int i = tempSize1; i > dividendo.length(); i--) {
            linea.remove(i - 1);
            // System.out.println("posicion " + i);
        }

        procedimiento.add(linea);

        /*
        Eliminar valores de mas
         */
        int tempSize = cocientes.size();
        for (int i = tempSize; i > dividendo.length(); i--) {
            cocientes.remove(i - 1);
            // System.out.println("posicion " + i);
        }

        procedimiento.add(0, cocientes);

//        linea = new ArrayList<String>();
//        for (int i = 0; i < dividendo.length(); i++) {
////            System.out.println("char dividendo " + dividendo.substring(i, i+1));
//            linea.add(dividendo.substring(i, i + 1));
//        }
        linea = new ArrayList<String>();
       
        for (int i = 0; i < dividendo.length(); i++) {
            System.out.println("char dividendo " + dividendo.substring(i, i+1));
            linea.add(dividendo.substring(i, i + 1));
        }
        procedimiento.add(1, linea);
        System.out.println("");
        System.out.println("");

        Iterator iter = procedimiento.iterator();

    //    while (iter.hasNext()) {

   //         System.out.println("Final" + iter.next());
            // List<String> temp = (List<String>) iter.next(); 
  //      }

        return procedimiento;
    }

}
