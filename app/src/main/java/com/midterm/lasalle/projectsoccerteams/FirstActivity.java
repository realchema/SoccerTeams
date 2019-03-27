package com.midterm.lasalle.projectsoccerteams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import module.Rating;
import module.Team;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText editTextCountry, editTextClientNumber;
    Spinner spinnerTeams;
    ImageView imageViewFlag;
    RatingBar ratingBar;
    Button buttonRate, buttonShow;

    ArrayList<Team> myListOfTeams = new ArrayList<>();
    ArrayList<Rating> myListOfRatings = new ArrayList<>();
    ArrayAdapter<Team> teamAdapter ;

    int countID=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initialize();
    }

    private void initialize() {
        editTextClientNumber = findViewById(R.id.editTextClientNumber);
        editTextCountry = findViewById(R.id.editTextCountry);
        spinnerTeams = findViewById(R.id.spinnerTeams);
        imageViewFlag = findViewById(R.id.imageViewFlag);
        ratingBar = findViewById(R.id.ratingBar);
        buttonRate = findViewById(R.id.buttonRate);
        buttonShow = findViewById(R.id.buttonShow);


        buttonShow.setOnClickListener(this);
        buttonRate.setOnClickListener(this);
        spinnerTeams.setOnItemSelectedListener(this);

        fillTeams();

        // Define the adapter

        teamAdapter = new ArrayAdapter<Team>(this, android.R.layout.simple_spinner_dropdown_item, myListOfTeams);

        //Set the adapter

        spinnerTeams.setAdapter(teamAdapter);

        editTextClientNumber.setText(String.valueOf(countID));
        ratingBar.setNumStars(0);

    }

    private void fillTeams()
    {
        myListOfTeams.clear();

        String[] teamsArray = {"Real Madrid","Liverpool","Barcelona","Bayern Munich"};
        String[] countriesArray = {"Spain", "England", "Spain", "Germany"};
        int [] flagsArray = {R.drawable.realmadrid, R.drawable.liverpool, R.drawable.barcelona, R.drawable.bayernmunchen};

       for(int i=0; i<teamsArray.length; i++)
       {
           Team myTeam = new Team();
           myTeam.setTeamName(teamsArray[i]);
           myTeam.setCountry(countriesArray[i]);
           myTeam.setFlag(flagsArray[i]);
           myListOfTeams.add(myTeam);
       }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonRate:

                Rating myRating = new Rating();
                myRating.setClientNumber(Integer.valueOf(editTextClientNumber.getText().toString()));
                myRating.setTeamName(spinnerTeams.getSelectedItem().toString());
                //myRating.setCountry(editTextCountry.getText().toString());
                //myRating.setFlag(imageViewFlag.getId());
                myRating.setRating(ratingBar.getRating());
                myListOfRatings.add(myRating);
                Toast.makeText(this, "Rate has been added!", Toast.LENGTH_LONG).show();

                countID++;

                editTextClientNumber.setText(String.valueOf(countID));




                break;

            case R.id.buttonShow:

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("myList", myListOfRatings);
                this.startActivity(intent);


                break;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Team myTeam = myListOfTeams.get(position);
          editTextCountry.setText(String.valueOf(myTeam.getCountry()));
          imageViewFlag.setImageResource(myTeam.getFlag());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
