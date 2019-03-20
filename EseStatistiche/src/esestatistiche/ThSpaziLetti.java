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
public class ThSpaziLetti extends Thread {

    private DatiCondivisi ptrDati;

    public ThSpaziLetti(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        for (int i = 0; i < ptrDati.vect.size(); i++) {
            if (ptrDati.vect.get(i) == ' ') {
                ptrDati.incNumSpaziLetti();
            }
        }
    }
}
