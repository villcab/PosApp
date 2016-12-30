package bo.com.ahosoft.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import bo.com.ahosoft.R;

public class DialogConfirmation extends Dialog {

    public static final int ACEPT_CANCEL = 0;
    public static final int YES_NO = 1;
    public static final int ALERT = 2;

    private Activity context;
    public Dialog dialog;

    private TextView tvTitleExit;
    private TextView tvDescriptionExit;
    private Button btnNegative;
    private Button btnPositive;

    public DialogConfirmation(Activity context, int type, String title, String description) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.context = context;
        dialog = this;
        setContentView(R.layout.dialog_confirmation);

		/*Window window = this.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
		WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);*/
        setCanceledOnTouchOutside(false);

        tvTitleExit = (TextView) findViewById(R.id.tvConfirmationTitle);
        tvDescriptionExit = (TextView) findViewById(R.id.tvConfirmationDescription);
        btnPositive = (Button) findViewById(R.id.btnConfirmationPositive);
        btnNegative = (Button) findViewById(R.id.btnConfirmationCancel);

        tvTitleExit.setText(title);
        tvDescriptionExit.setText(description);
        if (type == ACEPT_CANCEL) {
            btnPositive.setText("ACEPTAR");
            btnNegative.setText("CANCELAR");
        } else if (type == YES_NO) {
            btnPositive.setText("SI");
            btnNegative.setText("NO");
        } else if (type == ALERT) {
            btnPositive.setText("ACEPTAR");
            btnNegative.setVisibility(View.GONE);
        }

    }


    public DialogConfirmation(Activity context, int type) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.context = context;
        dialog = this;
        setContentView(R.layout.dialog_confirmation);

        tvTitleExit = (TextView) findViewById(R.id.tvConfirmationTitle);
        tvDescriptionExit = (TextView) findViewById(R.id.tvConfirmationDescription);
        btnPositive = (Button) findViewById(R.id.btnConfirmationPositive);
        btnNegative = (Button) findViewById(R.id.btnConfirmationCancel);

        tvTitleExit.setText("Titulo");
        tvDescriptionExit.setText("Descripcion");
        if (type == ACEPT_CANCEL) {
            btnPositive.setText("ACEPTAR");
            btnNegative.setText("CANCELAR");
        } else if (type == YES_NO) {
            btnPositive.setText("SI");
            btnNegative.setText("NO");
        } else if (type == ALERT) {
            btnPositive.setText("ACEPTAR");
            btnNegative.setVisibility(View.GONE);
        }
    }

    public void setTitle(String title) {
        tvTitleExit.setText(title);
    }

    public void setDescription(String description) {
        tvDescriptionExit.setText(description);
    }

    public void setOnClickPositiveButton(View.OnClickListener listener) {
        btnPositive.setOnClickListener(listener);
    }

    public void setOnClickNegativeButton(View.OnClickListener listener) {
        btnNegative.setOnClickListener(listener);
    }

}
