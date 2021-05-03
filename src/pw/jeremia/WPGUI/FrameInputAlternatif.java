package pw.jeremia.WPGUI;

import pw.jeremia.WP.Alternatif;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameInputAlternatif {
    JFrame frame;

    FrameInputAlternatif(){
        frame = new JFrame("WP GUI");
        frame.setSize(512,512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);


        JLabel label_judul = new JLabel("Weighted Product");
        label_judul.setFont(new Font("Robot",Font.BOLD,50));
        label_judul.setBounds(30,0,512,60);
        frame.add(label_judul);

        JLabel label_step = new JLabel("Step 1");
        label_step.setFont(new Font("Roboto",Font.PLAIN,35));
        label_step.setBounds(0,85,512,45);
        label_step.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label_step);

        JLabel label_petunjuk = new JLabel("Masukkan Alternatif !");
        label_petunjuk.setFont(new Font("Roboto",Font.PLAIN,35));
        label_petunjuk.setBounds(0,130,512,30);
        label_petunjuk.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label_petunjuk);

        ArrayList<PlaceholderTextField> ArrayTextFieldAlternatif = new ArrayList<PlaceholderTextField>();

        PlaceholderTextField Alternatif1 =new PlaceholderTextField();
        Alternatif1.setPlaceholder("Alternatif 1");
        Alternatif1.setBounds(155,175, 200,35);
        Alternatif1.setFont(new Font("Roboto",Font.PLAIN,25));
        Alternatif1.setHorizontalAlignment(JLabel.CENTER);
        ArrayTextFieldAlternatif.add(Alternatif1);
        frame.add(Alternatif1);

        PlaceholderTextField Alternatif2 =new PlaceholderTextField();
        Alternatif2.setPlaceholder("Alternatif 2");
        Alternatif2.setBounds(155,220, 200,35);
        Alternatif2.setFont(new Font("Roboto",Font.PLAIN,25));
        Alternatif2.setHorizontalAlignment(JLabel.CENTER);
        ArrayTextFieldAlternatif.add(Alternatif2);
        frame.add(Alternatif2);

//        frame.add(new JScrollPane(frame));


        JButton IncreaseButton = new JButton("Tambah");
        IncreaseButton.setBounds(205,265, 100,35);
        IncreaseButton.setFont(new Font("Roboto",Font.PLAIN,15));

        IncreaseButton.addActionListener(

                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JTextField last1 = ArrayTextFieldAlternatif.get(ArrayTextFieldAlternatif.size() - 1);
                        int lastx = (int) last1.getBounds().getX();
                        int lasty = (int) last1.getBounds().getY();

                        JTextField last2 = ArrayTextFieldAlternatif.get(ArrayTextFieldAlternatif.size() - 2);
                        int last2y = (int) last2.getBounds().getY();

                        int offset = lasty - last2y;

                        PlaceholderTextField ElementArrTextField = new PlaceholderTextField();
                        ElementArrTextField.setPlaceholder("Alternatif "+ (ArrayTextFieldAlternatif.size() + 1 ));
                        ElementArrTextField.setBounds(lastx, lasty + offset, 200, 35);
                        ElementArrTextField.setFont(new Font("Roboto", Font.PLAIN, 25));
                        ElementArrTextField.setHorizontalAlignment(JLabel.CENTER);
                        ArrayTextFieldAlternatif.add(ElementArrTextField);
                        frame.add(ElementArrTextField);

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

                ArrayList<Alternatif> Alternatif =  new ArrayList<Alternatif>(ArrayTextFieldAlternatif.size());

                for (int i = 0; i < ArrayTextFieldAlternatif.size(); i++)
                {

                    String namaalternatif = ArrayTextFieldAlternatif.get(i).getText();
                    if(namaalternatif.equals("")){
                        continue;
                    }
                    String kode = "A" + (i+1);
                    Alternatif.add(new Alternatif(namaalternatif,kode));
                }

                if(Alternatif.size() < 2){
                    JOptionPane.showMessageDialog(frame,"Silahkan tambahkan minimal 2 alternatif !", "Error !",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                new WPGUI(Alternatif);
                frame.dispose();
            }
        });
        frame.add(NextButton);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        this.show();

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
