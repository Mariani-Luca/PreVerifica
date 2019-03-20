/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Random;

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
        for (int i = 0; i < ptrDati.getNumCaratteri(); i++) {
            Random rn = new Random();
            ptrDati.addChar(s.charAt(rn.nextInt(lung)));
        }

    }
}
