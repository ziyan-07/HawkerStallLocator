package com.example.malaysiahawker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchHawker extends AppCompatActivity {

    public EditText name1;
    public LinearLayout newbox;
    List<HawkerData> hawker = new ArrayList<>();
    DatabaseAccess databaseAccess;
    Button getSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hawker);

        hideNavigationBar();
        newbox = findViewById(R.id.boxes);

        getSearchBtn = findViewById(R.id.my_search);
        getSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getsearch();
            }
            public void getsearch() {
                databaseAccess = new DatabaseAccess(getApplicationContext());
                databaseAccess.open();
                //scroller will go to top every click
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) ((ScrollView) findViewById(R.id.scroll_me)).smoothScrollTo(0, 0);

                //search the hawker by name
                name1 = findViewById(R.id.name);
                String n = name1.getText().toString();
                hawker = databaseAccess.getsearchhawker(n);

                for (HawkerData hd : hawker) {
                    LayoutInflater inflater = getLayoutInflater();
                    View view1 = inflater.inflate(R.layout.boxes, null);
                    TextView show = view1.findViewById(R.id.click_show);

                    TextView nama = view1.findViewById(R.id.namee);
                    ImageView image0 = view1.findViewById(R.id.imagee);
                    ImageView image1 = view1.findViewById(R.id.imagee1);
                    ImageView image2 = view1.findViewById(R.id.imagee2);
                    ImageView image3 = view1.findViewById(R.id.imagee3);
                    ImageView image4 = view1.findViewById(R.id.imagee4);

                    Bitmap bitmapImage = BitmapFactory.decodeByteArray(hd.getPhoto(), 0, hd.getPhoto().length);

                    if (hd.getPhoto1() != null) {
                        Bitmap bitmapImage1 = BitmapFactory.decodeByteArray(hd.getPhoto1(), 0, hd.getPhoto1().length);
                        image1.setImageBitmap(bitmapImage1);
                    } else
                        image1.setVisibility(View.GONE);

                    if (hd.getPhoto2() != null) {
                        Bitmap bitmapImage2 = BitmapFactory.decodeByteArray(hd.getPhoto2(), 0, hd.getPhoto2().length);
                        image2.setImageBitmap(bitmapImage2);
                    } else
                        image2.setVisibility(View.GONE);

                    if (hd.getPhoto3() != null) {
                        Bitmap bitmapImage3 = BitmapFactory.decodeByteArray(hd.getPhoto3(), 0, hd.getPhoto3().length);
                        image3.setImageBitmap(bitmapImage3);
                    } else
                        image3.setVisibility(View.GONE);

                    if (hd.getPhoto4() != null) {
                        Bitmap bitmapImage4 = BitmapFactory.decodeByteArray(hd.getPhoto4(), 0, hd.getPhoto4().length);
                        image4.setImageBitmap(bitmapImage4);
                    } else
                        image4.setVisibility(View.GONE);

                    nama.setText(hd.getName());
                    image0.setImageBitmap(bitmapImage);

                    show.setText("Address: " + hd.getAddress() + "\nDescription: " + hd.getDescription() + "\nRecommends: " + hd.getRecommends() + "\nFavourites: " + hd.getFavourites() + "\nUser Review: \n" + hd.getReview() + "\nPrevious Week Opening Hours: \n" + hd.getOpeninghours());

                    //add NEW search hawker on top
                    newbox.addView(view1, 0);
                }
            }
        });
    }

    public void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
}