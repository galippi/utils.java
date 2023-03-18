package lippiWare.utils;

import java.awt.Component;

import javax.swing.ProgressMonitor;

public class BusyDialog {
    ProgressMonitor pm;

    public BusyDialog(Component parent, String message, String note) {
        open(parent, message, note);
    }

    public BusyDialog(Component parent) {
        open(parent, "Please wait 1", "Please wait 2");
    }

    void open(Component parent, String message, String note) {
        pm = new ProgressMonitor(parent, message, note, 0, 100);
        pm.setMillisToDecideToPopup(0);
        pm.setProgress(0);
    }

    public boolean isCanceled() {
        return pm.isCanceled();
    }

    public void close() {
        pm.close();
        pm = null;
    }
}
