package bo.com.ahosoft.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import bo.com.ahosoft.R;

public class QRUtils {

    private static final int WIDTH = 500;
    private String qrText;
    private Resources resources;

    public QRUtils(String qrText, Resources resources) {
        this.qrText = qrText;
        this.resources = resources;
    }

    public Bitmap encodeAsBitmap() throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(qrText, BarcodeFormat.QR_CODE, WIDTH, WIDTH, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? resources.getColor(R.color.black) : resources.getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, WIDTH, 0, 0, w, h);
        return bitmap;
    }
}
