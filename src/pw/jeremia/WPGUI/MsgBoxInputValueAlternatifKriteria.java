package pw.jeremia.WPGUI;


import pw.jeremia.WP.Alternatif;
import pw.jeremia.WP.AlternatifKriteria;
import pw.jeremia.WP.Kriteria;

import javax.swing.*;
import java.util.ArrayList;


public class MsgBoxInputValueAlternatifKriteria {
    JFrame frame;
    ArrayList<Alternatif> alternatif;
    ArrayList<Kriteria> kriteria;


    MsgBoxInputValueAlternatifKriteria(ArrayList<Alternatif> alternatif, ArrayList<Kriteria> kriteria){
        this.alternatif = alternatif;
        this.kriteria = kriteria;

        frame = new JFrame("WP GUI");
        frame.setSize(0,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setLayout(null);
        show();

        tanyain();
        dispose();
    }

    public void show(){
        frame.setVisible(true);
    }

    public void hide(){
        frame.setVisible(false);
    }

    public void dispose(){
        frame.dispose();
    }

    public int ask(String alternatif,String kriteria){
        String value = JOptionPane.showInputDialog("Masukkan Nilai untuk \nAlternatif : "+alternatif+"\nKriteria : "+kriteria );
        if(!Helpers.isNumeric(value)){
            JOptionPane.showMessageDialog(frame,"Mohon masukkan angka !", "Error !",JOptionPane.ERROR_MESSAGE);
            return ask(alternatif,kriteria);
        }
        int val = Integer.valueOf(value);
        return val;
    }

    public void tanyain(){
        ArrayList<ArrayList<AlternatifKriteria>> listAlternatifKriteria = new ArrayList<ArrayList<AlternatifKriteria>>();

        for ( int i = 0; i < this.alternatif.size();i++){
            ArrayList<AlternatifKriteria> specAlternatifKriteria = new ArrayList<AlternatifKriteria>();

            for(int j=0;j<this.kriteria.size();j++){

                specAlternatifKriteria.add(new AlternatifKriteria(this.alternatif.get(i),this.kriteria.get(j),ask(this.alternatif.get(i).alternatif, this.kriteria.get(j).kriteria)));
//                System.out.println("Loop i="+i+" j="+j+" :"+listdata[i][j]);
            }

            listAlternatifKriteria.add(specAlternatifKriteria);
//            System.out.println("Simpan list alternatif kriteria i="+i);
        }

        new WPGUI(alternatif,kriteria,listAlternatifKriteria);

    }

}
