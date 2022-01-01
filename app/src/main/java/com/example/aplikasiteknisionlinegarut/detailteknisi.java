package com.example.aplikasiteknisionlinegarut;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class detailteknisi extends AppCompatActivity {

    public static Double latitude, longitude;
    private TextView teknisiName, teknisiAddress, teknisiKeahlian;
    private RatingBar rating;
    private ImageView imgTeknisi;
    private ImageView callPhone, callShare;

    public static String id, namaTeknisi, alamat, keahlian, gambar,
            callSave, ratingTmpt;

    private static final String TAG = "ListDislay";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailteknisi);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        rating = (RatingBar) findViewById(R.id.rating);

        rating.setRating(Float.parseFloat(ratingTmpt));

        imgTeknisi = (ImageView) findViewById(R.id.imgteknisi);
        teknisiName = (TextView) findViewById(R.id.teknisiname);
        teknisiAddress = (TextView) findViewById(R.id.teknisi_address);
        teknisiKeahlian = (TextView) findViewById(R.id.txtkeahlian);


        Glide.with(getApplicationContext())
                .load(gambar)
                .into(imgTeknisi);
        teknisiName.setText(namaTeknisi);
        teknisiAddress.setText(alamat);
        teknisiKeahlian.setText(keahlian);


        callPhone = (ImageView) findViewById(R.id.call_button);
        callPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(detailteknisi.this);
                builder.setMessage("Call " + callSave + " ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + callSave));
                        try {
                            startActivity(i);
                        } catch (SecurityException se) {
                            Toast.makeText(detailteknisi.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //Button SHARE
        callShare = (ImageView) findViewById(R.id.share_button);
        callShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = namaTeknisi + "\n\n"
                        + " "
                        + "Alamat:" + "\n" + alamat + "\n\n"
                        + " "
                        + "Alat Musik:" + "\n" + keahlian + "\n\n"
                        + " "
                        + "No Telepon:" + "\n" + callSave + "\n\n"
                        + " "
                        + "Lokasi Studio Musik:" + "\n" +
                        "http://maps.google.com/?q=" + latitude + "," + longitude + "\n\n"
                        + " "
                        + "'Find Your Music Studio!'";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Pilih Aplikasi"));
            }
        });


    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    //untuk tombol back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MapsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
