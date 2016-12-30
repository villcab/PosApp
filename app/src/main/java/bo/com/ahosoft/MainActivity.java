package bo.com.ahosoft;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.ZebraImageAndroid;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;

import bo.com.ahosoft.activitys.CategoryActivity;
import bo.com.ahosoft.activitys.RecordActivity;
import bo.com.ahosoft.activitys.fragments.CategoryFragment;
import bo.com.ahosoft.activitys.fragments.ProductFragment;
import bo.com.ahosoft.activitys.fragments.RecordFragment;
import bo.com.ahosoft.bussiness.BPrint;
import bo.com.ahosoft.utils.App;
import bo.com.ahosoft.utils.DialogConfirmation;
import bo.com.ahosoft.utils.QRUtils;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.nav_home);
        if (savedInstanceState == null) {
            //selectItem(R.menu.nav_menu);
        }

        /* Iniciar record */
        String title = "Record";
        Bundle args = new Bundle();
        Fragment fragment = null;
        args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
        fragment = RecordFragment.newInstance(title);
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Poner ícono del drawer toggle
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        selectItem(menuItem);
                        return true;
                    }
                }
        );
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(MenuItem menuItem) {
        String title = menuItem.getTitle().toString();
        Bundle args = new Bundle();
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
//            case R.id.nav_productos:
//                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
//                fragment = ConceptoFragment.newInstance(title);
//                fragment.setArguments(args);
//                break;
//
            case R.id.nav_categorias:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = CategoryFragment.newInstance(title);
                fragment.setArguments(args);
                break;

            case R.id.nav_record:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = RecordFragment.newInstance(title);
                fragment.setArguments(args);
                break;

            case R.id.nav_product:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = ProductFragment.newInstance(title);
                fragment.setArguments(args);
                break;

            default:
                args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);
                fragment = PlaceholderFragment.newInstance(title);
                fragment.setArguments(args);
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();

        drawerLayout.closeDrawers(); // Cerrar drawer

        setTitle(title); // Setear título actual

    }

    //    public void onclickAddConcepto(View view) {
//        Intent intent = new Intent(this, ConceptoActivity.class);
//        startActivity(intent);
//    }
//
    public void onclickCategory(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void onclickRecord(View view) {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }

    public void onclickDownloadProduct(View view) {
        ProductFragment fragment;
        Bundle args = new Bundle();
        args.putString(PlaceholderFragment.ARG_SECTION_TITLE, "hola");
        fragment = ProductFragment.newInstance("hola");
        fragment.loadProductServices();
        fragment.setArguments(args);
    }

    public void onclickPrintBill(View view) {
        Log.e(App.TAG, "on click print bill");
        dialog_confirmation_print();
    }

    private DialogConfirmation dialog;
    private MainActivity context = this;
    private boolean close_post_print = false;

    public void dialog_confirmation_print() {
        dialog = new DialogConfirmation(this, DialogConfirmation.YES_NO, "Factura", "Desea imprimir la factura");

        dialog.setOnClickPositiveButton(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BPrint printer = new BPrint(context, false);
                printer.print_invoice();
                dialog.cancel();

            }
        });
        dialog.setOnClickNegativeButton(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (close_post_print) {
                    finish();
                } else {
                    close_post_print = true;
                }
                dialog.cancel();

            }
        });
        dialog.show();
    }

    public void printqr(View view) {

        // Value for encoding
        String encode_value = "http://www.google.com/";

// Size of the QR code
        int qr_size = 200 * 3 / 4;

//        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(encode_value,
//                null,
//                Contents.Type.TEXT,
//                BarcodeFormat.QR_CODE.toString(),
//                qr_size);

// Get QR code as bitmap
//        final Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();

        new Thread(new Runnable() {
            public void run() {
                try {

                    // Instantiate connection for given Bluetooth® MAC Address.
                    Connection thePrinterConn = new BluetoothConnection("AC:3F:A4:54:34:92");

                    // Initialize
                    Looper.prepare();

                    // Open the connection - physical connection is established here.
                    thePrinterConn.open();


                    // Print QR code
                    ZebraPrinter printer = ZebraPrinterFactory.getInstance(thePrinterConn);

                    QRUtils qrUtils = new QRUtils("298268029|1|393401600095678|01/04/2016|8.00|8.00|0D-80-01-90-EC|0|0.00|0.00|0.00|0.00", getResources());
                    ZebraImageI img = new ZebraImageAndroid(qrUtils.encodeAsBitmap());
                    int x = 160;
                    int y = 0;
                    int w = 250;
                    int h = 250;
                    printer.printImage(img, x, y, w, h, false);
//                    printer.getGraphicsUtil().printImage(bitmap, 75, 0, 250, 250, false);


                    //Make sure the data got to the printer before closing the connection
                    Thread.sleep(500);

                    // Close the connection to release resources.
                    thePrinterConn.close();

                    Looper.myLooper().quit();

                } catch (Exception e) {

                    // Handle communications error here
                    e.printStackTrace();

                }
            }
        }).start();
    }

}
