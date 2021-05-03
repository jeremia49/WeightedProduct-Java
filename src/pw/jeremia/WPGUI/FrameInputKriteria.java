package pw.jeremia.WPGUI;

import pw.jeremia.WP.Alternatif;
import pw.jeremia.WP.Kriteria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FrameInputKriteria {
    JFrame frame;
    String[] list_combo_box = {"Benefit","Cost"};
    ArrayList<Alternatif> alternatif;

    FrameInputKriteria(ArrayList<Alternatif> alternatif){
        this.alternatif = alternatif;

        frame = new JFrame("WP GUI");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);


        JLabel label_judul = new JLabel("Weighted Product");
        label_judul.setFont(new Font("Robot",Font.BOLD,50));
        label_judul.setBounds(30,0,512,60);
        frame.add(label_judul);

        JLabel label_step = new JLabel("Step 2");
        label_step.setFont(new Font("Roboto",Font.PLAIN,35));
        label_step.setBounds(0,85,512,45);
        label_step.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label_step);

        JLabel label_petunjuk = new JLabel("Masukkan Kriteria !");
        label_petunjuk.setFont(new Font("Roboto",Font.PLAIN,35));
        label_petunjuk.setBounds(0,130,512,30);
        label_petunjuk.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label_petunjuk);

        ArrayList<PlaceholderTextField> ArrayTextFieldKriteria_nama = new ArrayList<PlaceholderTextField>();
        ArrayList<PlaceholderTextField> ArrayTextFieldKriteria_bobot = new ArrayList<PlaceholderTextField>();
        ArrayList<JComboBox> ArrayTextFieldKriteria_benefit = new ArrayList<JComboBox>();


        // Kriteria1
        PlaceholderTextField Kriteria1_nama =new PlaceholderTextField();
        Kriteria1_nama.setPlaceholder("Kriteria 1");
        Kriteria1_nama.setBounds(30,180, 200,35);
        Kriteria1_nama.setFont(new Font("Roboto",Font.PLAIN,25));
        Kriteria1_nama.setHorizontalAlignment(JLabel.CENTER);
        ArrayTextFieldKriteria_nama.add(Kriteria1_nama);
        frame.add(Kriteria1_nama);

        PlaceholderTextField Kriteria1_bobot =new PlaceholderTextField();
        Kriteria1_bobot.setPlaceholder("Bobot");
        Kriteria1_bobot.setBounds(240,180, 100,35);
        Kriteria1_bobot.setFont(new Font("Roboto",Font.PLAIN,25));
        Kriteria1_bobot.setHorizontalAlignment(JLabel.CENTER);
        ArrayTextFieldKriteria_bobot.add(Kriteria1_bobot);
        frame.add(Kriteria1_bobot);

        JComboBox Kriteria1_benefit = new JComboBox(list_combo_box);
        Kriteria1_benefit.setBounds(350,180, 120,35);
        Kriteria1_benefit.setFont(new Font("Roboto",Font.PLAIN,25));
        ArrayTextFieldKriteria_benefit.add(Kriteria1_benefit);
        frame.add(Kriteria1_benefit);
        //.Kriteria 1

        //Kriteria 2
        PlaceholderTextField Kriteria2_nama =new PlaceholderTextField();
        Kriteria2_nama.setPlaceholder("Kriteria 2");
        Kriteria2_nama.setBounds(30,220, 200,35);
        Kriteria2_nama.setFont(new Font("Roboto",Font.PLAIN,25));
        Kriteria2_nama.setHorizontalAlignment(JLabel.CENTER);
        ArrayTextFieldKriteria_nama.add(Kriteria2_nama);
        frame.add(Kriteria2_nama);

        PlaceholderTextField Kriteria2_bobot =new PlaceholderTextField();
        Kriteria2_bobot.setPlaceholder("Bobot");
        Kriteria2_bobot.setBounds(240,220, 100,35);
        Kriteria2_bobot.setFont(new Font("Roboto",Font.PLAIN,25));
        Kriteria2_bobot.setHorizontalAlignment(JLabel.CENTER);
        ArrayTextFieldKriteria_bobot.add(Kriteria2_bobot);
        frame.add(Kriteria2_bobot);

        JComboBox Kriteria2_benefit = new JComboBox(list_combo_box);
        Kriteria2_benefit.setBounds(350,220, 120,35);
        Kriteria2_benefit.setFont(new Font("Roboto",Font.PLAIN,25));
        ArrayTextFieldKriteria_benefit.add(Kriteria2_benefit);
        frame.add(Kriteria2_benefit);
        //.Kriteria2



        JButton IncreaseButton = new JButton("Tambah");
        IncreaseButton.setBounds(205,265, 100,35);
        IncreaseButton.setFont(new Font("Roboto",Font.PLAIN,15));

        IncreaseButton.addActionListener(

                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JTextField last1 = ArrayTextFieldKriteria_nama.get(ArrayTextFieldKriteria_nama.size() - 1);
                        int lasty = (int) last1.getBounds().getY();

                        JTextField last2 = ArrayTextFieldKriteria_nama.get(ArrayTextFieldKriteria_nama.size() - 2);
                        int last2y = (int) last2.getBounds().getY();

                        int offset = lasty - last2y;

                        PlaceholderTextField Temp_nama =new PlaceholderTextField();
                        Temp_nama.setPlaceholder("Kriteria "+ (ArrayTextFieldKriteria_nama.size() + 1 ));
                        Temp_nama.setBounds(30,lasty + offset, 200,35);
                        Temp_nama.setFont(new Font("Roboto",Font.PLAIN,25));
                        Temp_nama.setHorizontalAlignment(JLabel.CENTER);
                        ArrayTextFieldKriteria_nama.add(Temp_nama);
                        frame.add(Temp_nama);

                        PlaceholderTextField Temp_bobot =new PlaceholderTextField();
                        Temp_bobot.setPlaceholder("Bobot");
                        Temp_bobot.setBounds(240,lasty + offset, 100,35);
                        Temp_bobot.setFont(new Font("Roboto",Font.PLAIN,25));
                        Temp_bobot.setHorizontalAlignment(JLabel.CENTER);
                        ArrayTextFieldKriteria_bobot.add(Temp_bobot);
                        frame.add(Temp_bobot);

                        JComboBox Temp_benefit = new JComboBox(list_combo_box);
                        Temp_benefit.setBounds(350,lasty + offset, 120,35);
                        Temp_benefit.setFont(new Font("Roboto",Font.PLAIN,25));
                        ArrayTextFieldKriteria_benefit.add(Temp_benefit);
                        frame.add(Temp_benefit);

                        IncreaseButton.setBounds((int) IncreaseButton.getBounds().getX(), (int) IncreaseButton.getBounds().getY() + 45, (int) IncreaseButton.getBounds().getWidth(), (int) IncreaseButton.getBounds().getHeight());

                        frame.revalidate();
                        frame.repaint();

                    }
                }

        );
        frame.add(IncreaseButton);

        JButton NextButton = new JButton(">");
        NextButton.setBounds(320,90, 50,35);
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                ArrayList<Kriteria> kriteria =  new ArrayList<Kriteria>(ArrayTextFieldKriteria_nama.size());

                for (int i = 0; i < ArrayTextFieldKriteria_nama.size(); i++)
                {


                    String namakriteria = ArrayTextFieldKriteria_nama.get(i).getText();
                    String bobotkriteriaString = ArrayTextFieldKriteria_bobot.get(i).getText();
                    boolean benefit = (ArrayTextFieldKriteria_benefit.get(i).getSelectedIndex() == 0) ? true : false;



                    if(namakriteria.equals("") || bobotkriteriaString.equals("")) {
                        continue;
                    }

                    if(!Helpers.isNumeric(bobotkriteriaString)){
                        JOptionPane.showMessageDialog(frame,"Mohon masukkan angka di cell Bobot !", "Error !",JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int bobotkriteria = Integer.parseInt(bobotkriteriaString);
                    String kode = "K" + (i+1);


                    kriteria.add(new Kriteria(namakriteria,bobotkriteria,benefit,kode));

                }

                if(kriteria.size() < 1){
                    JOptionPane.showMessageDialog(frame,"Silahkan tambahkan minimal 1 Kriteria !", "Error !",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                frame.dispose();
                new WPGUI(alternatif,kriteria);


            }
        });
        frame.add(NextButton);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        this.show();

        Kriteria1_nama.requestFocusInWindow();
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



}
