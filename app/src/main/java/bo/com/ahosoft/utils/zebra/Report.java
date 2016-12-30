package bo.com.ahosoft.utils.zebra;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class Report implements Serializable {

    private List<Line> lstLines = new ArrayList<Line>();
    private String separator = "-";
    private int charactersPerLine = 42;

    public Report() {
        this.createSeparator();
    }

    public Report(int charactersPerLine) {
        this.charactersPerLine = charactersPerLine;
        this.createSeparator();
    }

    private void createSeparator() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < this.charactersPerLine; i++) {
            buffer.append(this.separator);
        }
        this.separator = buffer.toString();
    }

    public void addSeparator() {
        lstLines.add(new Line(this.separator, Line.Alignment.Center));
    }

    public void addSeparator(String separator) {
        this.separator = this.separator.replace(this.separator.substring(0, 1), separator);
        lstLines.add(new Line(this.separator, Line.Alignment.Center));
    }

    public void addLine(String line) {
        lstLines.add(new Line(line, Line.Alignment.Left));
    }

    public void addLine(Bitmap bitmap) {
        lstLines.add(new Line(bitmap));
    }

    public void addLine(String line, Line.Alignment to) {
        lstLines.add(new Line(line, to));
    }

    public void addLine(String line, Line.Alignment to, int lineFeed) {
        lstLines.add(new Line(line, to, lineFeed));
    }


    public boolean print(Printer printer) throws InterruptedException {
        System.gc();
        printer.connectPrinter();
        if (printer.getStatus()) {
            for (int i = 0; i < lstLines.size(); i++) {

                Line line = lstLines.get(i);

                //printer.print(line.getText(), line.getTo(), line.getFontSize(), line.getLineFeed());

                /** Verficar si salta de linea **/
                boolean saltoLinea = true;
                Line sig = lstLines.get(i + 1);
                if ((sig != null && sig.getImage() != null) || line.getImage() != null) {
                    saltoLinea = false;
                }

                printer.print(line, line.getFontSize(), line.getLineFeed(), saltoLinea);

            }
            printer.disconnectPrinter();
            return true;
        }
        return false;
    }
}
