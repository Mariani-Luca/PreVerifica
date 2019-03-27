/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariani_luca
 */
public class ThVisualizza extends Thread {

    private DatiCondivisi ptrDati;

    public ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                ptrDati.getSemDaVisualizzare().acquire();

                System.out.println(ptrDati.toString());

                ptrDati.getSemVisualizzato().release();
            }
        } catch (InterruptedException ex) {
        }
    }
}

