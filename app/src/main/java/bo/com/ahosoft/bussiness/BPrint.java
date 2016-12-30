package bo.com.ahosoft.bussiness;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import bo.com.ahosoft.R;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.QRUtils;
import bo.com.ahosoft.utils.zebra.Line.Alignment;
import bo.com.ahosoft.utils.zebra.Report;
import bo.com.ahosoft.utils.zebra.Util;
import bo.com.ahosoft.utils.zebra.Zebra;

public class BPrint extends AsyncTask<Integer, Void, Integer> {

    public static final int PRINT_UNDEFINED = 0;
    public static final int PRINT_INVOICE = 1;

    private int impresion_type = PRINT_UNDEFINED;

    private ProgressDialog dialog;
    private Activity context;
    //    private User objUser;
//    private Customer customer;
//    private Sale sale;
//    private Company objCompany;
//    private Payment objPayment;
//    private Invoice objAccount;
//    private List<Invoice> lstInvoice;
//    private double balance;
    private boolean close_post_print = false;

    public BPrint(Activity context, boolean close_post_print) {
        this.context = context;
        this.close_post_print = close_post_print;
    }

//    public BPrint(ValidateActivity context, User objUser, Customer objCustomer, Company objCompany, boolean close_post_print) {
//        this.context = context;
//        this.objUser = objUser;
//        this.customer = objCustomer;
//        this.objCompany = objCompany;
//        this.close_post_print = close_post_print;
//    }
//
//    public BPrint(ValidateActivity context, User objUser, Customer objCustomer, Company objCompany) {
//        this.context = context;
//        this.objUser = objUser;
//        this.customer = objCustomer;
//        this.objCompany = objCompany;
//    }

    public void setImpresion_type(int impresion_type) {
        this.impresion_type = impresion_type;
    }

    public void setClose_post_print(boolean close_post_print) {
        this.close_post_print = close_post_print;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog = ProgressDialog.show(context, null, "Imprimiendo...");
    }

    @Override
    protected Integer doInBackground(Integer... arg0) {
        Report objReport = new Report(48);
        try {
            switch (impresion_type) {
                case PRINT_INVOICE:
                    write_invoice(objReport);
                    break;
                default:
                    break;
            }
            if (objReport.print(new Zebra("AC:3F:A4:54:34:92"))) {
                return 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    protected void onPostExecute(Integer result) {
        dialog.cancel();
        if (result == 1) {
            Toast.makeText(context, "Impresion Finalizada.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ocurio un problema al imprimir, por favor revise que la impresora este disponible y el bluetooth funcionando.", Toast.LENGTH_LONG).show();
        }

        if (close_post_print) {
            context.finish();
        }
    }

    public void print_invoice() {
        impresion_type = PRINT_INVOICE;
        execute();
    }

    private void write_invoice(Report objReport) {
        objReport.addLine("BRASAS Y CARNE S.R.L.", Alignment.Center);
        objReport.addLine(" ");
        objReport.addLine("SUCURSAL NRO. 0", Alignment.Center);
        objReport.addLine("1ER ANILLO FRENTE AL AVION PIRATA", Alignment.Center);
        objReport.addLine("TELEFONO 33-212-775", Alignment.Center);
        objReport.addLine("SANTA CRUZ - BOLIVIA", Alignment.Center);
        objReport.addLine(" ");
        objReport.addLine("FACTURA", Alignment.Center);
        objReport.addSeparator();
        objReport.addLine("NIT: 298268028", Alignment.Center);
        objReport.addLine("NRO. FACTURA: 52", Alignment.Center);
        objReport.addLine("NRO. AUTORIZACION: 393401600095678", Alignment.Center);
        objReport.addSeparator();
        objReport.addLine("SERVICIO DE COMIDA CHURRASQUERIA", Alignment.Center);
        objReport.addLine(" ");
        objReport.addLine("FECHA: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US).format(new Date()), Alignment.Left);
        objReport.addLine("NIT/CI: 7800725", Alignment.Left);
        objReport.addLine("SENOR(ES): BISMARCK VILLCA SOLIZ", Alignment.Left);
        objReport.addSeparator();

        /** DEBE CONTENER 48 CARACTERES **/
        String cabecera = Util.padRight("CANT.", 10) + Util.padRight("DETALLE", 18) + Util.padLeft("P/U", 10) + Util.padLeft("SUBTOTAL", 10);
        objReport.addLine(cabecera, Alignment.Left);
        objReport.addSeparator();

        /** DETALLE **/
        String lineDetail = Util.padCenter("2" + " ", 10) + Util.padRight("COCA COLA 2L", 18) + Util.padLeft("15.00", 10)  + Util.padLeft("30.00", 10);
        objReport.addLine(lineDetail, Alignment.Left);
        lineDetail = Util.padCenter("1" + " ", 10) + Util.padRight("LIMINADA X JAR", 18) + Util.padLeft("30.00", 10)  + Util.padLeft("30.00", 10);
        objReport.addLine(lineDetail, Alignment.Left);
        lineDetail = Util.padCenter("1" + " ", 10) + Util.padRight("LIMINADA X MEJ", 18) + Util.padLeft("25.00", 10)  + Util.padLeft("25.00", 10);
        objReport.addLine(lineDetail, Alignment.Left);
        objReport.addLine("TOTAL Bs.    85.00", Alignment.Right);
        objReport.addSeparator();
        objReport.addLine("SON: OCHENTA Y CINCO 0/100 BOLIVIANOS.", Alignment.Left);
        objReport.addSeparator();
        objReport.addLine("CODIGO DE CONTROL: 88-44-86-89-E7", Alignment.Left);
        objReport.addLine("FECHA LIMITE DE EMISION: 16/08/2016", Alignment.Left);

        /** Qr code **/
        try {
            QRUtils qrUtils = new QRUtils("298268029|1|393401600095678|01/04/2016|8.00|8.00|0D-80-01-90-EC|0|0.00|0.00|0.00|0.00", context.getResources());
            objReport.addLine(qrUtils.encodeAsBitmap());

        } catch (Exception e) {
            Log.e(App.TAG, "Error al colocar el QR", e);
        }


        objReport.addLine("ESTA FACTURA CONTRIBUYE AL DESARROLLO", Alignment.Center);
        objReport.addLine("DEL PAIS.EL USO ILICITO DE ESTA SERA", Alignment.Center);
        objReport.addLine("SANCIONADO DE ACUERDO A LEY.", Alignment.Center);
        objReport.addSeparator();
        objReport.addLine("USUARIO: ADMIN CASA MATRIZ", Alignment.Left);
        objReport.addLine(" ");
        objReport.addLine("Ley Nro. 453: Los servicios deben", Alignment.Left);
        objReport.addLine("suministrarse en condiciones de", Alignment.Left);
        objReport.addLine("inocuidad, calidad y seguridad.", Alignment.Left);
        objReport.addLine(" ");
        objReport.addLine(" ");
    }

//    private void write_invoice(Report objReport) {
//        objReport.addLine(" ");
//        objReport.addSeparator();
//        objReport.addLine("  Ingresa a www." + objCompany.getsName() + ".com y conoce", Alignment.Left);
//        objReport.addLine("  mas sobre de nosotros.", Alignment.Left);
//        objReport.addSeparator();
//        objReport.addLine(objCompany.getsName(), Alignment.Center);
//        objReport.addLine(objCompany.getsAddress(), Alignment.Center);
//        objReport.addLine("TELEFONO: " + objCompany.getsTelephone(), Alignment.Center);
//        objReport.addLine("SANTA CRUZ - BOLIVIA", Alignment.Center);
//        objReport.addLine(" ");
//        objReport.addLine("FACTURA", Alignment.Center);
//        objReport.addLine("original", Alignment.Center);
//        objReport.addLine(" Vendedor: " + objUser.getsUserCode() + " - " + objUser.getsName(), Alignment.Left);
//        objReport.addSeparator();
//        objReport.addLine("NIT: " + objCompany.getsNit(), Alignment.Center);
//        objReport.addLine("Factura Nro: " + objCompany.getiNextNumber(), Alignment.Center);
//        objReport.addLine("Autorizacion Nro.: " + objCompany.getsAutorizationNumber(), Alignment.Center);
//        // objReport.addLine(objCompany.getsPC(), Alignment.Center);
//        objReport.addSeparator();
//        objReport.addLine(" Fecha: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US).format(sale.getdSaleDate()), Alignment.Left);
//        objReport.addLine(" Srs.: " + sale.getsCorporateName(), Alignment.Left);
//        if (sale.getsNIT() != null && !sale.getsNIT().isEmpty())
//            objReport.addLine(" NIT/CI.: " + sale.getsNIT(), Alignment.Left);
//        else {
//            objReport.addLine(" NIT/CI.: " + sale.getCustomer().getsCI(), Alignment.Left);
//        }
//        objReport.addSeparator();
//        objReport.addLine("DETALLE", Alignment.Center);
//        objReport.addSeparator();
//        String cabecera = Util.padRight("COD.", 11) + Util.padRight("PRODUCTO", 15) + Util.padLeft("CANT.", 6) + Util.padLeft("P/U", 6) + Util.padLeft("TOTAL", 10);
//        objReport.addLine(cabecera, Alignment.Left);
//        for (SaleDetail sd : sale.getListSaleDetail()) {
//            String description = sd.getPriceListProduct().getProduct().getsDescription();
//            String codigo = sd.getPriceListProduct().getProduct().getsCode();
//            if (description.length() > 15) {
//                description = description.substring(0, 14);
//            }
//            if (codigo.length() > 10) {
//                codigo = codigo.substring(0, 10);
//            }
//            String lineDetail = Util.padRight(codigo + " ", 11) + Util.padRight(description, 15) + Util.padLeft(String.valueOf(sd.getdQuantity()), 6)
//                    // + Util.padLeft(formatDouble(sd.getdQuantity()), 6)
//                    + Util.padLeft(formatDouble(sd.getdUnitCostCurrencyTransactional()), 6) + Util.padLeft(formatDouble(sd.getdPartialTotalCurrencyTransactional()), 10);
//            objReport.addLine(lineDetail, Alignment.Left);
//        }
//        objReport.addLine(" ");
//        String lineTotal4 = Util.padRight(" SUBTOTAL", 38) + Util.padLeft(formatDouble(sale.getdTotalAmount()), 10);
//        objReport.addLine(lineTotal4, Alignment.Left);
//        objReport.addSeparator();
//        String lineTotal2 = Util.padRight(" IVA", 38) + Util.padLeft(formatDouble(sale.getdTotalAmount() * 0.13), 10);
//        objReport.addLine(lineTotal2, Alignment.Left);
//        String lineTotal = Util.padRight(" TOTAL", 38) + Util.padLeft(formatDouble(sale.getdTotalAmount() + sale.getdTotalAmount() * 0.13), 10);
//        objReport.addLine(lineTotal, Alignment.Left);
//
//        objReport.addLine(" Son: " + Functions.AmountToLiteral(Functions.Round(sale.getdTotalAmount() + sale.getdTotalAmount() * 0.13, 2)), Alignment.Left);
//        try {
//            objReport.addLine(" Codigo de Control: " + SinV7.getCode(objCompany.getsAutorizationNumber(), String.valueOf(objCompany.getiNextNumber()), sale.getsNIT(), sale.getdSaleDate(), sale.getdTotalAmount(), objCompany.getsDosificationKey()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            objReport.addLine(" Fecha Limite de Emision: " + new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(objCompany.getdLimitDate()), Alignment.Left, 2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        objReport.addLine(" La reproduccion total o parcia y/o el uso no");
//        objReport.addLine(" autorizado de esta Nota Fiscal, constituye un ");
//        objReport.addLine(" delito a ser sancionado conforme a ley.");
//        objReport.addSeparator();
//
//        // objReport.addLine(" Vendedor: " + objUser.getsName(),
//        // Alignment.Left);
//        objReport.addLine(" Nro. Int: " + sale.getlId(), Alignment.Left);
//        objReport.addLine(" Compa" + normalizerText("�") + "ia : " + objCompany.getsName(), Alignment.Left);
//
//        objReport.addLine("! 200 0 0 200 1\r\n" + "B QR 0 0 M 2 U 6\r\n" + "MA,Nombre1: " + customer.getsName() + "\n" + "Compania: " + customer.getsCorporateName() + "\n" + "Nit: " + customer.getsNit() + "\r\n" + "ENDQR\r\0\r\nPRINT\r\n", Alignment.Center);
//
//        objReport.addLine(objCompany.getsTextFooter(), Alignment.Center, 2);
//    }

    public String formatDouble(double dbl) {
        String doubleString = "";
        DecimalFormat format = new DecimalFormat("#.00");
        doubleString = format.format(Math.round(dbl * 100) / 100d);

        if (dbl < 1) {
            doubleString = "0" + doubleString;
        }
        return doubleString;
    }

    public Date getDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    private String normalizerText(String value) {
        return Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
