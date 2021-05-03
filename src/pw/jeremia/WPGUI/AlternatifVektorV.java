package pw.jeremia.WPGUI;

import pw.jeremia.WP.Alternatif;

public class AlternatifVektorV implements Comparable<AlternatifVektorV> {
    public Alternatif alternatif;
    public double vektorv;

    AlternatifVektorV(Alternatif alternatif, double vektorv){
        this.alternatif = alternatif;
        this.vektorv = vektorv;
    }

    public double getVektorv() {
        return vektorv;
    }

    @Override
    public int compareTo(AlternatifVektorV alternatifVektorV) {
        double othervektorv = alternatifVektorV.vektorv;

        if (vektorv == othervektorv)
            return 0;
        else if (vektorv > othervektorv)
            return 1;
        else
            return -1;
    }
}
