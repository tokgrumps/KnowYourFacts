package sg.edu.rp.webservices.knowyourfacts;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_1 extends Fragment {
    Button btnColor;
    CardView cv;
    int color;
    ImageView iv;




    public Frag_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_1, container, false);

        btnColor = (Button) view.findViewById(R.id.color1);
        cv = (CardView) view.findViewById(R.id.card1);
        final SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
        cv.setCardBackgroundColor(settings.getInt("Color1", 0));
        btnColor.setBackgroundColor(settings.getInt("Color1", 0));


        iv = (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(R.mipmap.ic_launcher);
        String imageUrl = "http://68.media.tumblr.com/bb23aa86d35fc9e1636268bb5e43e720/tumblr_otridkBR9v1roqv59o1_500.png";
        Picasso.with(getActivity()).load(imageUrl).into(iv);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicker();
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicker();

            }
        });

        return view;
    }

    public void onClicker() {
        Random rnd = new Random();
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        cv.setCardBackgroundColor(color);
        btnColor.setBackgroundColor(color);
        SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Color1", color);
        editor.commit();
    }

}
