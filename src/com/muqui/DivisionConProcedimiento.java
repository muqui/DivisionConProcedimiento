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

         
                for (int i = 0; i < cantidadDecimalDivisor; i++) {
                    dividendo = dividendo + "0";
                }

            }

        divisor = divisor.replace(".", "");
        dividendo = dividendo.replace(".", "");
      
        String originalString = dividendo;
        List<List<String>> procedimiento = new ArrayList<List<String>>();
        List<String> cocientes = new ArrayList<String>();
        List<String> linea = null;
        String ayuda = null;
        //= new ArrayList<String>();
        int apuntador = divisor.length();
       int size = 0;
        int subdivisor = 0;
        int cociente = 0;
        int residuo = 0;
        float resultado = Float.valueOf(dividendo) / Float.valueOf(divisor);
        int modulo = Integer.valueOf(dividendo) % Integer.valueOf(divisor);

        String cadena = "" + resultado;
        int original = dividendo.length();


        if (modulo != 0) {
            for (int i = dividendo.length(); i < cadena.length() - 1 + (apuntador); i++) {

                dividendo = dividendo + "0";
            }
        }

        size = dividendo.length();
      
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
            
              if(cantidadDecimalDividendo > cantidadDecimalDivisor){
            	  posicionFinalPunto = original + 1 -(cantidadDecimalDividendo - cantidadDecimalDivisor);
              }
        	 // posicionFinalPunto = original + 1;
          }
          else
        if (dividendoOriginal.indexOf('.') > 0) {
         

            int dividendoSize = dividendoOriginal.length() - 1;
            
            int posPuntoDividendo = dividendoOriginal.indexOf('.');
            posicionFinalPunto = original + 1 - (dividendoSize - posPuntoDividendo);
        
        } 
           
      
        
        subdivisor = Integer.valueOf(dividendo.substring(0, divisor.length()));
        if (subdivisor < Integer.parseInt(divisor)) {
            subdivisor = Integer.valueOf(dividendo.substring(0, (divisor.length() + 1)));
            apuntador = divisor.length() + 1;

        }

        cociente = subdivisor / Integer.valueOf(divisor);
        for (int i = 1; i <= size; i++) {
            cocientes.add("_");
        }
        if(apuntador  > posicionFinalPunto){
      	  
      	   for (int i = 0; i <= apuntador-2; i++) {
      		   if(i == posicionFinalPunto-1){
      			 cocientes.add(i, ".0");
      		   }
      		   else{
      			 cocientes.add(i, "0");
      		   }
                 
                
             }
      	
      	 
         }
        cocientes.add(apuntador - 1, "" + cociente);

        residuo = subdivisor % Integer.valueOf(divisor);

        while (apuntador < size) {
             if (apuntador == posicionFinalPunto) {
              
                cocientes.add(apuntador - 1, "." + cociente);

                // cocientes.remove(size-1);
            }
         
            linea = new ArrayList<String>();
            for (int i = 1; i <= size; i++) {
                linea.add("_");

            }
            
            ayuda = residuo + dividendo.substring(apuntador, apuntador + 1);


            //tamaño del subdivisor
            int talmaSubdivisor = ayuda.length();
            int apuntadorActual = (apuntador + 1) - ayuda.length();
            for (int i = 0; i < talmaSubdivisor; i++) {

                linea.add(apuntadorActual, ayuda.substring(i, i + 1));
                apuntadorActual++;
            }

            subdivisor = (Integer.valueOf("" + residuo + dividendo.substring(apuntador, apuntador + 1)));

            apuntador++;
            cociente = subdivisor / Integer.valueOf(divisor);

            //   cocientes.add(apuntador, "" + cociente);
            //  cocientes.add("" + cociente);
            residuo = subdivisor % Integer.valueOf(divisor);
            if (apuntador == posicionFinalPunto) {
             
                cocientes.add(apuntador - 1, "." + cociente);

                // cocientes.remove(size-1);
            } else {
                cocientes.add(apuntador - 1, "" + cociente);
                //  cocientes.remove(size-1);
            }

            //Elimina los espacios de mas  
            int tempSize = linea.size();
            for (int i = tempSize; i > dividendo.length(); i--) {
                linea.remove(i - 1);
               
            }

            procedimiento.add(linea);

        }
   
        linea = new ArrayList<String>();
        for (int i = 1; i <= size; i++) {
            linea.add("_");
        }
        String residuoString = "" + residuo;

        int talmaSubdivisor = residuoString.length();
        int apuntadorActual = (apuntador) - residuoString.length();
        for (int i = 0; i < talmaSubdivisor; i++) {

            linea.add(apuntadorActual, residuoString.substring(i, i + 1));
            apuntadorActual++;
        }


        //Elimina los espacios de mas  
        int tempSize1 = linea.size();
        for (int i = tempSize1; i > dividendo.length(); i--) {
            linea.remove(i - 1);
          
        }

        procedimiento.add(linea);

        /*
        Eliminar valores de mas
         */
        int tempSize = cocientes.size();
        for (int i = tempSize; i > dividendo.length(); i--) {
            cocientes.remove(i - 1);
           
        }

        procedimiento.add(0, cocientes);


//            linea.add(dividendo.substring(i, i + 1));
//        }
        linea = new ArrayList<String>();
       
        for (int i = 0; i < dividendo.length(); i++) {
         
            linea.add(dividendo.substring(i, i + 1));
        }
        procedimiento.add(1, linea);
     

        Iterator iter = procedimiento.iterator();

        while (iter.hasNext()) {

            System.out.println("Final" + iter.next());

        }

        return procedimiento;
    }

}
