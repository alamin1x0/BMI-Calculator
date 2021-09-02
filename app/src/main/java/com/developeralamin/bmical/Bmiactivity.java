package com.developeralamin.bmical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Bmiactivity extends AppCompatActivity {

    Button mrecalculatebmi;
    TextView bmidisplay,bmicategory,mgender;
    Intent intent;
    ImageView imageView;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        bmidisplay = findViewById(R.id.bmidisplay);
        bmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        imageView = findViewById(R.id.imageview);
        mbackground = findViewById(R.id.contenlayout);
        mrecalculatebmi = findViewById(R.id.recalcuaterbmi);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intweight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);


        intheight = intweight/100;
        intbmi = intheight/(intheight*intheight);

        mbmi = Float.toString(intbmi);
        System.out.println(mbmi);

        if (intbmi<16){
            bmicategory.setText("Savere Thinnes");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);
        }

        else if (intbmi<16.9 && intbmi>16){
            bmicategory.setText("Moderate Thinnes");
            mbackground.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.warning);
        }

        else if (intbmi<18.4 && intbmi>17){
            bmicategory.setText("Mild Thinnes");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }

        else if (intbmi<24.9 && intbmi>18.5){
            bmicategory.setText("Normal");
            //mbackground.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ok);
        }

        else if (intbmi<29.9 && intbmi>25){
            bmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }

        else {
            bmicategory.setText("Obese Class 1");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(mbmi);






        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bmiactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}