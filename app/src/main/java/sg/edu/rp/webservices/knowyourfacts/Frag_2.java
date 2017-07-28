package sg.edu.rp.webservices.knowyourfacts;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_2 extends Fragment {
    Button btnColor;
    CardView cv;
    int color;


    public Frag_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_2, container, false);

        btnColor = (Button) view.findViewById(R.id.color2);
        cv = (CardView) view.findViewById(R.id.card2);
        final SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
        cv.setCardBackgroundColor(settings.getInt("Color2", 0));
        btnColor.setBackgroundColor(settings.getInt("Color2", 0));

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicker();
            }
        });

        cv.setOnClickListener(new View.OnClickListener() {
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
        editor.putInt("Color2", color);
        editor.commit();
    }

}
