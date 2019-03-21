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
public class ThVisualizza extends Thread {

    private DatiCondivisi ptrDati;

    public ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        int numPuntiI = ptrDati.getNumPuntiInseriti();
        int numSpaziI = ptrDati.getNumSpaziInseriti();
        int numPuntiL = ptrDati.getNumPuntiLetti();
        int numSpaziL = ptrDati.getNumSpaziLetti();

        for (int i = 0; i < ptrDati.getVect().size(); i++) {
            if (numPuntiI != ptrDati.getNumPuntiInseriti()
                    && numSpaziI != ptrDati.getNumSpaziInseriti()
                    && numPuntiL != ptrDati.getNumPuntiLetti()
                    && numSpaziL != ptrDati.getNumSpaziLetti()) {
                System.out.println(ptrDati.toString());
            }
        }
    }
}
