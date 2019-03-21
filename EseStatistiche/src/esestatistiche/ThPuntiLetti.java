/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

/**
 *
 * @author mariani_luca
 */
public class ThPuntiLetti extends Thread {

    private DatiCondivisi ptrDati;

    public ThPuntiLetti(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        for (int i = 0; i < ptrDati.getVect().size(); i++) {
            if (ptrDati.getVect().get(i) == '.') {
                ptrDati.incNumPuntiLetti();
            }
        }
    }
}
