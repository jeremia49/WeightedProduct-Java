package pw.jeremia.WPGUI;

import pw.jeremia.WP.Alternatif;
import pw.jeremia.WP.AlternatifKriteria;
import pw.jeremia.WP.Calculate;
import pw.jeremia.WP.Kriteria;

import java.util.ArrayList;
import java.util.Collections;

public class WPGUI {
    private static ArrayList<Alternatif> alternatif;
    private ArrayList<Kriteria> kriteria;
    private ArrayList<ArrayList<AlternatifKriteria>> listAlternatifKriteria;

    WPGUI(ArrayList<Alternatif> alternatif){
        this.alternatif = alternatif;

        int i = 0;
        for(Alternatif a : alternatif){
            i++;
            System.out.println("Alternatif "+i);
            System.out.print("Nama Alternatif : "+a.alternatif);
            System.out.println(", Kode Alternatif : "+a.kode);
            System.out.println();
        }
        System.out.println("Jumlah Alternatif : "+this.alternatif.size());

        inputKriteria();
    }

    WPGUI(ArrayList<Alternatif> alternatif, ArrayList<Kriteria> kriteria){
        this.alternatif = alternatif;
        this.kriteria = kriteria;

        int i = 0;
        for(Kriteria a : kriteria){
            i++;
            System.out.println("Kriteria "+i);
            System.out.print("Kriteria : "+a.kriteria);
            System.out.print(", Bobot : "+a.bobot);
            System.out.print(", Benefit : "+a.benefit);
            System.out.println(", Kode: "+a.kode);
            System.out.println();
        }
        System.out.println("Jumlah Kriteria : "+this.kriteria.size());

        inputNilai();
    }

    WPGUI(ArrayList<Alternatif> alternatif, ArrayList<Kriteria> kriteria, ArrayList<ArrayList<AlternatifKriteria>> listAlternatifKriteria){
        this.alternatif = alternatif;
        this.kriteria = kriteria;
        this.listAlternatifKriteria = listAlternatifKriteria;

//        System.out.println(listAlternatifKriteria);
        proses();
    }


    public static void  main(String[] args){
        new FrameInputAlternatif();

//        new Output();

    }

    public void inputKriteria(){
        new FrameInputKriteria(alternatif);
    }

    public void inputNilai(){
        new MsgBoxInputValueAlternatifKriteria(alternatif,kriteria);
    }

    public void proses(){
        Calculate clc = new Calculate(alternatif,kriteria,listAlternatifKriteria);
        double[] VektorV = clc.vektorV;

        ArrayList<AlternatifVektorV> listalternatifvektorv = new ArrayList<>();
        int i = 0;
        for (Alternatif a : alternatif){
            listalternatifvektorv.add(new AlternatifVektorV(a,VektorV[i]));
            i++;
        }

//        Collections.sort(listalternatifvektorv,Collections.reverseOrder());
        Collections.sort(listalternatifvektorv);


        new Output(listalternatifvektorv);


    }


}
