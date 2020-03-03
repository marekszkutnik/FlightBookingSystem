package SystemRezerwacjiLotow;

import java.util.Date;

public class Lot {
    private String miejsceWylotu;
    private String miejsceWylotuSymbol;
    private String miejscePrzylotu;
    private String miejscePrzylotuSymbol;
    private Date dataWylotu;
    private Date dataPowrotu;
    private double dlugoscLotu;
    private int iloscPasazerow;
    private double cenaBazowa;

    public Lot(String miejsceWylotu, String miejsceWylotuSymbol, String miejscePrzylotu, String miejscePrzylotuSymbol, Date dataWylotu, Date dataPowrotu, double dlugoscLotu, int iloscPasazerow, double cenaBazowa) {
        this.miejsceWylotu = miejsceWylotu;
        this.miejsceWylotuSymbol = miejsceWylotuSymbol;
        this.miejscePrzylotu = miejscePrzylotu;
        this.miejscePrzylotuSymbol = miejscePrzylotuSymbol;
        this.dataWylotu = dataWylotu;
        this.dataPowrotu = dataPowrotu;
        this.dlugoscLotu = dlugoscLotu;
        this.iloscPasazerow = iloscPasazerow;
        this.cenaBazowa = cenaBazowa;
    }

    public Lot() {

    }

    public String getMiejsceWylotu() {
        return miejsceWylotu;
    }

    public void setMiejsceWylotu(String miejsceWylotu) {
        this.miejsceWylotu = miejsceWylotu;
    }

    public String getMiejsceWylotuSymbol() {
        return miejsceWylotuSymbol;
    }

    public void setMiejsceWylotuSymbol(String miejsceWylotuSymbol) {
        this.miejsceWylotuSymbol = miejsceWylotuSymbol;
    }

    public String getMiejscePrzylotu() {
        return miejscePrzylotu;
    }

    public void setMiejscePrzylotu(String miejscePrzylotu) {
        this.miejscePrzylotu = miejscePrzylotu;
    }

    public String getMiejscePrzylotuSymbol() {
        return miejscePrzylotuSymbol;
    }

    public void setMiejscePrzylotuSymbol(String miejscePrzylotuSymbol) {
        this.miejscePrzylotuSymbol = miejscePrzylotuSymbol;
    }

    public Date getDataWylotu() {
        return dataWylotu;
    }

    public void setDataWylotu(Date dataWylotu) {
        this.dataWylotu = dataWylotu;
    }

    public Date getDataPowrotu() {
        return dataPowrotu;
    }

    public void setDataPowrotu(Date dataPowrotu) {
        this.dataPowrotu = dataPowrotu;
    }

    public double getDlugoscLotu() {
        return dlugoscLotu;
    }

    public void setDlugoscLotu(double dlugoscLotu) {
        this.dlugoscLotu = dlugoscLotu;
    }

    public int getIloscPasazerow() {
        return iloscPasazerow;
    }

    public void setIloscPasazerow(int iloscPasazerow) {
        this.iloscPasazerow = iloscPasazerow;
    }

    public double getCenaBazowa() {
        return cenaBazowa;
    }

    public double setCenaBazowa(double cenaBazowa) {
        this.cenaBazowa = cenaBazowa;
        return cenaBazowa;
    }

    public double nowaCena1_1(){
        double nowaCena;
        nowaCena=cenaBazowa*1.1;
        return nowaCena;
    }

    public double nowaCena1_25(){
        double nowaCena;
        nowaCena=cenaBazowa*1.25;
        return nowaCena;
    }

    public double nowaCena1_65(){
        double nowaCena;
        nowaCena=cenaBazowa*1.65;
        return nowaCena;
    }

    @Override
    public String toString() {
        return "LOT: " +
                "Miejsce wylotu: '" + miejsceWylotu + '\'' +
                ", Miejsce przylotu: '" + miejscePrzylotu + '\'' +
                ", Data wylotu: " + dataWylotu +
                ", Data powrotu: " + dataPowrotu +
                ", Przewidywana dlugość lotu: " + dlugoscLotu +
                ", Aktualna ilosc pasażerów: " + iloscPasazerow +
                ", Cena: " + cenaBazowa +
                '.';
    }

}
