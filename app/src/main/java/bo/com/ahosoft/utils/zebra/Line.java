package bo.com.ahosoft.utils.zebra;

import android.graphics.Bitmap;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Line implements Serializable {

	private String Text;
	private Alignment To;
	private int FontSize = 1;
	private int LineFeed = 1;
	private Bitmap image;

	public static enum Alignment {
		Left, Right, Center
	}

	public Line(String text, Alignment alignment) {
		Text = text;
		To = alignment;
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	public Line(String text, Alignment alignment, int lineFeed) {
		Text = text;
		To = alignment;
		LineFeed = lineFeed;
	}

	public Line(String text, Alignment alignment, int fontSize, int lineFeed) {
		Text = text;
		To = alignment;
		FontSize = fontSize;
		LineFeed = lineFeed;
	}

	public Line(Bitmap bitmap) {
		image = bitmap;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return Text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		Text = text;
	}

	/**
	 * @return the to
	 */
	public Alignment getTo() {
		return To;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(Alignment to) {
		To = to;
	}

	/**
	 * @return the fontSize
	 */
	public int getFontSize() {
		return FontSize;
	}

	/**
	 * @param fontSize
	 *            the fontSize to set
	 */
	public void setFontSize(int fontSize) {
		FontSize = fontSize;
	}

	/**
	 * @return the lineFeed
	 */
	public int getLineFeed() {
		return LineFeed;
	}

	/**
	 * @param lineFeed
	 *            the lineFeed to set
	 */
	public void setLineFeed(int lineFeed) {
		LineFeed = lineFeed;
	}
	
}
