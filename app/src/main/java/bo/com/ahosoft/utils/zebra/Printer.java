package bo.com.ahosoft.utils.zebra;

import bo.com.ahosoft.utils.zebra.Line.Alignment;

public interface Printer {

	public int charactersPerLine = 0;

	public boolean getStatus();

	public boolean connectPrinter();

	public boolean disconnectPrinter();

	public boolean print(String textToPrint, Alignment alignment, int fontSize, int linefeed);

	public boolean print(Line line, int fontSize, int linefeed, boolean saltoLinea);
	
}
