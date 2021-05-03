package pw.jeremia.WP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculate {

    List<Alternatif> listAlnternatif ;
    List<Kriteria> listKriteria;
    double normBobot[];

    ArrayList<ArrayList<AlternatifKriteria>> listAlternatifKriteria;

    double vektorS[];
    public double vektorV[];

    public Calculate(List<Alternatif> listAlnternatif, List<Kriteria> listKriteria, ArrayList<ArrayList<AlternatifKriteria>> listAlternatifKriteria){
        this.listAlnternatif = listAlnternatif;
        this.listKriteria = listKriteria;
        this.listAlternatifKriteria = listAlternatifKriteria;
//
//
//        this.listAlnternatif.add(new Alternatif("Nokaya","A1"));
//        this.listAlnternatif.add(new Alternatif("Mato","A2"));
//        this.listAlnternatif.add(new Alternatif("Lenovo","A3"));
//        this.listAlnternatif.add(new Alternatif("BlackBurry","A4"));
//
//        this.listKriteria.add(new Kriteria("Harga", 5, false, "C1"));
//        this.listKriteria.add(new Kriteria("Kualitas", 4, true, "C2"));
//        this.listKriteria.add(new Kriteria("Fitur", 4, true, "C3"));
//        this.listKriteria.add(new Kriteria("Populer", 3, true, "C4"));
//        this.listKriteria.add(new Kriteria("Purna Jual", 2, true, "C5"));
//        this.listKriteria.add(new Kriteria("Keawetan", 2, true, "C6"));


        printAlternatif();
        printKriteria();
        calcNormBobot();
//
//
//        int [] [] listdata = new int [this.listAlnternatif.size()][this.listKriteria.size()];
//        listdata[0][0] = 3500;
//        listdata[0][1] = 70;
//        listdata[0][2] = 10;
//        listdata[0][3] = 80;
//        listdata[0][4] = 3000;
//        listdata[0][5] = 36;
//
//        listdata[1][0] = 4500;
//        listdata[1][1] = 90;
//        listdata[1][2] = 10;
//        listdata[1][3] = 60;
//        listdata[1][4] = 2500;
//        listdata[1][5] = 48;
//
//        listdata[2][0] = 3200;
//        listdata[2][1] = 80;
//        listdata[2][2] = 9;
//        listdata[2][3] = 90;
//        listdata[2][4] = 2000;
//        listdata[2][5] = 48;
//
//        listdata[3][0] = 3000;
//        listdata[3][1] = 70;
//        listdata[3][2] = 8;
//        listdata[3][3] = 50;
//        listdata[3][4] = 1500;
//        listdata[3][5] = 60;

//
//        for ( int i = 0; i < this.listAlnternatif.size();i++){
//            ArrayList<AlternatifKriteria> specAlternatifKriteria = new ArrayList<AlternatifKriteria>();
//
//            for(int j=0;j<this.listKriteria.size();j++){
//
//                specAlternatifKriteria.add(new AlternatifKriteria(this.listAlnternatif.get(i),this.listKriteria.get(j),listdata[i][j]));
//                System.out.println("Loop i="+i+" j="+j+" :"+listdata[i][j]);
//            }
//            this.listAlternatifKriteria.add(specAlternatifKriteria);
//
//            System.out.println("Simpan listalternatif kriteria i="+i);
//        }

        System.out.println(this.listAlternatifKriteria);
////
        this.vektorS = new double[this.listAlternatifKriteria.size()];
        for(int i = 0; i < this.listAlternatifKriteria.size(); i++){
            this.vektorS[i] = (double)(calcVektorS(this.listAlternatifKriteria.get(i)));
            System.out.println("Vektor S dari " + (i +1) + " adalah : " + this.vektorS[i]);
        }
        double jumlahS = 0.0;
        for(int i = 0; i < vektorS.length;i++){
            jumlahS += vektorS[i];
        }

        System.out.println("Jumlah Vektor S : " + jumlahS);

        this.vektorV = new double[this.vektorS.length];
        for(int i = 0; i < vektorS.length;i++){
            this.vektorV[i] = this.vektorS[i] / jumlahS;
            System.out.println("Vektor V dari " + (i +1) + " adalah : " + this.vektorV[i]);
        }
//
//        double max = 0;
//        for(int i = 0; i < vektorV.length;i++){
//            if(max < vektorV[i]){
//                max = vektorV[i];
//            }
//        }
//
//        for(int i = 0; i < vektorV.length;i++){
//            if(max == vektorV[i]){
//                System.out.println("Alternatif yang terbaik adalah : " + (i+1) + " dengan properti : ");
//                printAlternatif(i);
//            }
//        }

    }

    void printAlternatif(int i){
        System.out.print("Nama Alternatif : "+ this.listAlnternatif.get(i).alternatif);
        System.out.println(", Kode Alternatif : "+ this.listAlnternatif.get(i).kode);
        System.out.println();
    }


    void printAlternatif(){
        int i = 0;
        for(Alternatif a : listAlnternatif){
            i++;
            System.out.println("Alternatif "+i);
            System.out.print("Nama Alternatif : "+a.alternatif);
            System.out.println(", Kode Alternatif : "+a.kode);
            System.out.println();
        }
        System.out.println("Jumlah Alternatif : "+this.listAlnternatif.size());
    }

    void printKriteria(){
        int i = 0;
        for(Kriteria a : listKriteria){
            i++;
            System.out.println("Kriteria "+i);
            System.out.print("Kriteria : "+a.kriteria);
            System.out.print(", Bobot : "+a.bobot);
            System.out.print(", Benefit : "+a.benefit);
            System.out.println(", Kode: "+a.kode);
            System.out.println();
        }
        System.out.println("Jumlah Kriteria : "+this.listKriteria.size());
    }

    void calcNormBobot(){
        this.normBobot = new double[this.listKriteria.size()];
        int jlhBobot = 0;
        for(Kriteria a : listKriteria){
            jlhBobot  +=   a.bobot;
        }

        for(int i=0; i< listKriteria.size(); i++){
            this.normBobot[i] = (double) listKriteria.get(i).bobot / (double) jlhBobot;
        }
        System.out.println("Nomalisasi Bobot : "+ Arrays.toString(this.normBobot));
    }

    double calcPangkat(Kriteria kriteria,double normalisasibobot){
        if(kriteria.benefit){
            return normalisasibobot;
        }else{
            return normalisasibobot * -1.0;
        }
    }

    double calcVektorS(List<AlternatifKriteria> listnya){

        float hasil = 1f;

        for (int i = 0; i < listnya.size(); i++){
            hasil *= Math.pow(listnya.get(i).value, calcPangkat(listnya.get(i).kriteria, normBobot[i])) ;
        }
        return hasil;
    }





}
