/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariani_luca
 */
public class EseStatistiche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        int numCaratteri = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire il numero di caratteri da generare:");
        numCaratteri = getInt(sc);

        DatiCondivisi datiC = new DatiCondivisi(numCaratteri);

        ThGenera thGenera = new ThGenera(datiC);
        ThSpaziLetti thSpaziLetti = new ThSpaziLetti(datiC);
        ThPuntiLetti thPuntiLetti = new ThPuntiLetti(datiC);
        ThVisualizza thVisualizza = new ThVisualizza(datiC);

        thGenera.start();
        thSpaziLetti.start();
        thPuntiLetti.start();
        thVisualizza.start();

        try {
            thGenera.join();
            
            datiC.getSemPuntiLetti().acquireUninterruptibly();
            datiC.getSemSpaziLetti().acquireUninterruptibly();
            
            thSpaziLetti.interrupt();
            thPuntiLetti.interrupt();
            
            thSpaziLetti.join();
            thPuntiLetti.join();
            
            thVisualizza.interrupt();
            thVisualizza.join();
            
            System.out.println(datiC);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(EseStatistiche.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static int getInt(Scanner sc) {
        do {
            String l = sc.next();
            try {
                return Integer.parseInt(l);
            } catch(NumberFormatException ex) {
            }
            System.out.println("Inserire un numero: ");
        } while(true);
    }
    
}
