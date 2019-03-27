package com.midterm.lasalle.projectsoccerteams;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import module.Rating;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonReturn;

    TextView textViewTeamRate1, textViewTeamRate2, textViewTeamRate3, textViewTeamRate4,
    textViewPercentage1, textViewPercentage2, textViewPercentage3, textViewPercentage4;


    ArrayList<Rating> myList = new ArrayList<>();


    float rating=0, realmadridRating=0, liverpoolRating=0, barcelonaRating=0, bayernmunichRating=0;
    float realmadridPercent=0, liverpoolPercent=0, barcelonaPercent=0, bayernmunichPercent=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
    }

    private void initialize() {

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        myList = (ArrayList<Rating>) getIntent().getSerializableExtra("myList");

       buttonReturn = findViewById(R.id.buttonReturn);
       buttonReturn.setOnClickListener(this);

       textViewTeamRate1 = findViewById(R.id.textViewTeamRate1);
       textViewTeamRate2 = findViewById(R.id.textViewTeamRate2);
       textViewTeamRate3 = findViewById(R.id.textViewTeamRate3);
       textViewTeamRate4 = findViewById(R.id.textViewTeamRate4);

        textViewPercentage1 = findViewById(R.id.textViewPercentage1);
        textViewPercentage2 = findViewById(R.id.textViewPercentage2);
        textViewPercentage3 = findViewById(R.id.textViewPercentage3);
        textViewPercentage4 = findViewById(R.id.textViewPercentage4);

        fillTable();

    }

    @Override
    public void onClick(View v) {
        goBack();

    }

    private void goBack() {



        Intent intent = new Intent(this, FirstActivity.class);
        this.startActivity(intent);
        finish();

    }

    private void fillTable(){
        for (int i =0 ; i < myList.size() ; i++) {
            String team = myList.get(i).getTeamName();
            rating = myList.get(i).getRating();

            if (team.equals("Real Madrid")) {
                realmadridRating = realmadridRating + rating;
                realmadridPercent++;
            }
            if (team.equals("Liverpool")) {
               liverpoolRating =  liverpoolRating + rating;
               liverpoolPercent++;
            }
            if (team.equals("Barcelona")) {
               barcelonaRating = barcelonaRating + rating;
               barcelonaPercent++;
            }
            if (team.equals("Bayern Munich")) {
                bayernmunichRating = bayernmunichRating + rating;
                bayernmunichPercent++;
            }

        }


        String r1=String.format("%.1f",(realmadridRating/realmadridPercent)),
        r2=String.format("%.1f",(liverpoolRating/liverpoolPercent)),
        r3=String.format("%.1f",(barcelonaRating/barcelonaPercent)),
                r4=String.format("%.1f",bayernmunichRating/bayernmunichPercent);

        textViewTeamRate1.setText("Real Madrid/"+String.valueOf(r1));
        textViewTeamRate2.setText("Liverpool/"+String.valueOf(r2));
        textViewTeamRate3.setText("Barcelona/"+String.valueOf(r3));
        textViewTeamRate4.setText("Bayern Munich/"+String.valueOf(r4));

        calculatePercentage();



    }

    private void calculatePercentage(){

        String p1=String.format("%.2f",(realmadridPercent/myList.size())*100),
        p2=String.format("%.2f",(liverpoolPercent/myList.size())*100),
        p3=String.format("%.2f",(barcelonaPercent/myList.size())*100),
        p4=String.format("%.2f",(bayernmunichPercent/myList.size())*100);



        textViewPercentage1.setText(String.valueOf(p1)+"%");
        textViewPercentage2.setText(String.valueOf(p2)+"%");
        textViewPercentage3.setText(String.valueOf(p3)+"%");
        textViewPercentage4.setText(String.valueOf(p4)+"%");

    }
}
