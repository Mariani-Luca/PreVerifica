/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariani_luca
 */
public class ThGenera extends Thread {

    private DatiCondivisi ptrDati;

    public ThGenera(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ. ";
        int lung = s.length();
        int caratteriDaGenerare = ptrDati.getNumCaratteri();
        Random rn = new Random();

        while (caratteriDaGenerare > 0) {
            
            ptrDati.getSemPuntiLetti().acquireUninterruptibly();
            ptrDati.getSemSpaziLetti().acquireUninterruptibly();
            
            ptrDati.getVect().clear(); //pulisce il vettore dopo essersi accertato che abbia letto
            
            for (int i = 0; i < 10 && caratteriDaGenerare > 0; i++) {
                caratteriDaGenerare--;
                ptrDati.addChar(s.charAt(rn.nextInt(lung)));
            }
            
            ptrDati.getSemPuntiGenera().release();
            ptrDati.getSemSpaziGenera().release();
        }
    }
}
