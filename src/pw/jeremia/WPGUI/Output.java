package pw.jeremia.WPGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.SwingConstants.CENTER;

public class Output {
    JFrame frame;

    public Output(ArrayList<AlternatifVektorV> alternatifVektorV)
    {

        frame = new JFrame("WP GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

//        JLabel label_judul = new JLabel("Weighted Product");
//        label_judul.setFont(new Font("Robot",Font.BOLD,50));
//        label_judul.setHorizontalAlignment(SwingConstants.TOP);
//        label_judul.setVerticalAlignment(SwingConstants.CENTER);
//        frame.add(label_judul);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("No.");
        tableModel.addColumn("Kode Alternatif");
        tableModel.addColumn("Alternatif");
        tableModel.addColumn("Vektor V");


        int z = 0;
        for(AlternatifVektorV av : alternatifVektorV){
            z++;
            tableModel.insertRow(0, new Object[]{  alternatifVektorV.size() - z + 1, av.alternatif.kode, av.alternatif.alternatif,av.vektorv });
//            System.out.println("Nomor : " + z + " | Nama Alternatif : " + av.alternatif.alternatif + "| Kode Alternatif : "+ av.alternatif.kode +" | Vektor V : " + av.vektorv);
        }

        JTable table = new JTable(tableModel);

        setCellsAlignment(table,CENTER);

        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20); //third column is bigger
            } else if(i==1){
                column.setPreferredWidth(50);
            }
        }

        frame.add(new JScrollPane(table));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

}
