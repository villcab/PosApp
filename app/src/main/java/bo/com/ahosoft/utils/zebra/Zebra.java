package bo.com.ahosoft.utils.zebra;

import android.graphics.Bitmap;

import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.ZebraImageAndroid;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;

import java.io.Serializable;

import bo.com.ahosoft.utils.zebra.Line.Alignment;

@SuppressWarnings("serial")
public class Zebra implements Printer, Serializable {

	public int charactersPerLine = 48;

	private Connection printerConnection;
	// private String macAddress = "AC:3F:A4:14:18:FA";

	private String macAddress = "AC:3F:A4:14:18:03";

	public Zebra(String macAddress) {
		this.macAddress = macAddress;

		// com.zebra.android.printer.ZebraPrinterFactory.getInstance(null);

	}

	@Override
	public boolean getStatus() {
		return printerConnection.isConnected();
	}

	@Override
	public boolean connectPrinter() {
		try {
			printerConnection = new BluetoothConnection(this.macAddress);
			printerConnection.open();
			if (printerConnection.isConnected() != true) {
				return printerConnection.isConnected();
			}
		} catch (Exception e) {
			disconnectPrinter();
		}
		return false;
	}

	@Override
	public boolean disconnectPrinter() {
		try {
			if (printerConnection != null) {
				printerConnection.close();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean print(String textToPrint, Alignment alignment, int fontSize, int linefeed) {
		boolean result = false;
		try {

			if (alignment.name().equals(Alignment.Left.name())) {
				textToPrint = Util.padRight(textToPrint, this.charactersPerLine);
			} else if (alignment.name().equals(Alignment.Right.name())) {
				textToPrint = Util.padLeft(textToPrint, this.charactersPerLine);
			} else {
				textToPrint = Util.padCenter(textToPrint, this.charactersPerLine);
			}

			printerConnection.write(textToPrint.getBytes());

			// ZebraPrinter printer = ZebraPrinterFactory.getInstance(thePrinterConn);
			// printer.getGraphicsUtil().printImage(bitmap, 75, 0, 250, 250, false);
			if (linefeed > 0) {
				while (linefeed > 0) {
					printerConnection.write("\r".getBytes());
					linefeed--;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean print(Line line, int fontSize, int linefeed, boolean saltoLine) {
		boolean result = false;
		try {

			Alignment alignment = line.getTo();
			String textToPrint = line.getText();
			Bitmap bitmap = line.getImage();

			if (bitmap != null) {

				ZebraPrinter printer = ZebraPrinterFactory.getInstance(printerConnection);
				ZebraImageI img = new ZebraImageAndroid(bitmap);
				int x = 140;
				int y = 0;
				int w = 270;
				int h = 270;
				printerConnection.write(("! UTILITIES\r\nIN-MILLIMETERS\r\nSETFF 0 2\r\nPRINT\r\n").getBytes());
				printer.printImage(img, x, y, w, h, false);

			} else {
				if (alignment.name().equals(Alignment.Left.name())) {
					textToPrint = Util.padRight(textToPrint, this.charactersPerLine);
				} else if (alignment.name().equals(Alignment.Right.name())) {
					textToPrint = Util.padLeft(textToPrint, this.charactersPerLine);
				} else {
					textToPrint = Util.padCenter(textToPrint, this.charactersPerLine);
				}

				printerConnection.write(textToPrint.getBytes());

			}

			if (saltoLine) {
				if (linefeed > 0) {
					while (linefeed > 0) {
						printerConnection.write("\r".getBytes());
						linefeed--;
					}
				}
			}

//			 ZebraPrinter printer = ZebraPrinterFactory.getInstance(thePrinterConn);
//			 printer.getGraphicsUtil().printImage(bitmap, 75, 0, 250, 250, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
