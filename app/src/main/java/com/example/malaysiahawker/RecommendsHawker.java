package com.example.malaysiahawker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RecommendsHawker extends AppCompatActivity {

    public LinearLayout newRecombox;
    List<HawkerData> hawker = new ArrayList<>();
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommends_hawker);

        hideNavigationBar();
        newRecombox = findViewById(R.id.recombox);

        databaseAccess = new DatabaseAccess(getApplicationContext());
        databaseAccess.open();
        hawker = databaseAccess.getrecommendshawker();

        for (HawkerData hd : hawker) {
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.recombox, null);
            TextView showme = view1.findViewById(R.id.show_me);

            TextView nama = view1.findViewById(R.id.namee0);
            TextView suka = view1.findViewById(R.id.favouritese0);
            TextView sangatsuka = view1.findViewById(R.id.recommendse0);

            ImageView image0 = view1.findViewById(R.id.imagee0);
            ImageView image1 = view1.findViewById(R.id.imagee10);
            ImageView image2 = view1.findViewById(R.id.imagee20);
            ImageView image3 = view1.findViewById(R.id.imagee30);
            ImageView image4 = view1.findViewById(R.id.imagee40);

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

            image0.setImageBitmap(bitmapImage);
            nama.setText(hd.getName());
            sangatsuka.setText("Recommends: " + hd.getRecommends());
            suka.setText("Favourites: " + hd.getFavourites());

            showme.setText("Address: " + hd.getAddress() + "\nDescription: " + hd.getDescription() + "\nDisplay Phone No.: " + hd.getDisplayphoneno() + "\nIs Open: " + hd.getIsopen() + "\nPhone: " + hd.getPhone() + "\nUser Review: \n" + hd.getReview() + "\nPrevious Week Opening Hours: \n" + hd.getOpeninghours());

            newRecombox.addView(view1);
        }
    }

    public void toastMe(String me) {
        Toast toast = Toast.makeText(this, me, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void displayToastRecom(View v) {
        toastMe("You have recommended this hawker!");
    }

    public void displayToastFav(View v) {
        toastMe("Added to favourites list.");
    }

    public void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
}