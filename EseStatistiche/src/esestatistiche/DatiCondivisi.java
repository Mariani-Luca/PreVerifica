/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mariani_luca
 */
public class DatiCondivisi {

    private int numSpaziInseriti;
    private int numSpaziLetti;
    private int numPuntiInseriti;
    private int numPuntiLetti;

    private int numCaratteri;

    private Semaphore semVisualizzato;
    private Semaphore semDaVisualizzare;
    private Semaphore semPuntiGenera;
    private Semaphore semSpaziGenera;
    private Semaphore semPuntiLetti;
    private Semaphore semSpaziLetti;

    private Vector<Character> vect = new Vector<Character>();

    public DatiCondivisi(int numCaratteri) {
        this.numCaratteri = numCaratteri;

        numSpaziInseriti = 0;
        numSpaziLetti = 0;
        numPuntiLetti = 0;
        numPuntiInseriti = 0;

        semDaVisualizzare = new Semaphore(0);
        semVisualizzato = new Semaphore(0);

        semPuntiGenera = new Semaphore(1);
        semSpaziGenera = new Semaphore(1);
        semSpaziLetti = new Semaphore(0);
        semPuntiLetti = new Semaphore(0);
    }

    public Semaphore getSemVisualizzato() {
        return semVisualizzato;
    }

    public Semaphore getSemPuntiGenera() {
        return semPuntiGenera;
    }

    public Semaphore getSemSpaziGenera() {
        return semSpaziGenera;
    }

    public Semaphore getSemPuntiLetti() {
        return semPuntiLetti;
    }

    public Semaphore getSemSpaziLetti() {
        return semSpaziLetti;
    }

    public synchronized Vector<Character> getVect() {
        return vect;
    }

    public Semaphore getSemDaVisualizzare() {
        return semDaVisualizzare;
    }

    public synchronized int getNumCaratteri() {
        return numCaratteri;
    }

    public synchronized int getNumPuntiInseriti() {
        return numPuntiInseriti;
    }

    public synchronized int getNumSpaziInseriti() {
        return numSpaziInseriti;
    }

    public synchronized int getNumSpaziLetti() {
        return numSpaziLetti;
    }

    public synchronized int getNumPuntiLetti() {
        return numPuntiLetti;
    }

    public void incNumSpaziLetti() {
        numSpaziLetti++;
        semDaVisualizzare.release();                //segnalo che devo visualizzare
        semVisualizzato.acquireUninterruptibly();   //aspetto che visualizzi
    }

    public void incNumPuntiLetti() {
        numPuntiLetti++;
        semDaVisualizzare.release();                //segnalo che devo visualizzare
        semVisualizzato.acquireUninterruptibly();   //aspetto che visualizzi
    }

    public void incNumSpaziInseriti() {
        numSpaziInseriti++;
        semDaVisualizzare.release();                //segnalo che devo visualizzare
        semVisualizzato.acquireUninterruptibly();   //aspetto che visualizzi
    }

    public void incNumPuntiInseriti() {
        numPuntiInseriti++;
        semDaVisualizzare.release();                //segnalo che devo visualizzare
        semVisualizzato.acquireUninterruptibly();   //aspetto che visualizzi
    }

    public void addChar(char carattere) {
        if (carattere == ' ') {
            incNumSpaziInseriti();
        }
        if (carattere == '.') {
            incNumPuntiInseriti();
        }
        vect.add(carattere);
    }

    public synchronized String toString() {
        String ris = "";
        ris = "Punti inseriti: " + numPuntiInseriti
                + "\nSpazi inseriti: " + numSpaziInseriti
                + "\nPunti letti: " + numPuntiLetti
                + "\nSpazi letti: " + numSpaziLetti
                + "\n------------------------------------";
        return ris;
    }
}
