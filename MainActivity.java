package com.familyfight.stenb.scoremywar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

//AppCompatActivity
public class MainActivity extends AppCompatActivity implements ReslutDialog.NoticeDialogListener{

    public final String LOG_TEAMS = "Hear is a team: ";
    public final String LOG_TAG = "This was clicked";
    private ArrayList<Team> teams;
    private ArrayList<Partisipent> partisipents;
    ListAdapter teamAdapter;
    ListAdapter parAdapter;
    private ComparePartisipent comparePartisipent = new ComparePartisipent();
    private CompareTimedConstest compareTimedConstest = new CompareTimedConstest();
    public ReslutDialog reslutDialog = new ReslutDialog();
    private int positionOfPar = 0;
    private int typeOfcontest = 0;


    private Team team = new Team("Team Man");
    private Team team1 = new Team("Team Kvinna");


    private Partisipent marcus = new Partisipent("Marcus Stenberg", team);
    private Partisipent anicka = new Partisipent("Anicka Stenberg", team1);
    private Partisipent mariette = new Partisipent("Mariette Nyman", team1);
    private Partisipent jan = new Partisipent("Jan Nyman", team);
    private Partisipent janGide = new Partisipent("Jan Gidebring", team);
    private Partisipent alexander = new Partisipent("Alexander Gidebring", team);
    private Partisipent joakim = new Partisipent("Joakim Stenberg", team);
    private Partisipent daniel = new Partisipent("Daniel Stenberg", team);
    private Partisipent tjanette = new Partisipent("Tjanette Gidebring", team1);
    private Partisipent hanna = new Partisipent("Hanna", team1);//TODO: fixa eftenamn
    private Partisipent josefine = new Partisipent("Josefin", team1);//TODO: fixa eftenamn
    private Partisipent natali = new Partisipent("Natali", team1);//TODO: fixa eftenamn


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teams = new ArrayList<>();
        partisipents = new ArrayList<>();
        teams.add(team);
        teams.add(team1);
        partisipents.add(marcus);
        partisipents.add(anicka);
        partisipents.add(jan);
        partisipents.add(janGide);
        partisipents.add(mariette);
        partisipents.add(tjanette);
        partisipents.add(joakim);
        partisipents.add(josefine);
        partisipents.add(alexander);
        partisipents.add(hanna);
        partisipents.add(daniel);
        partisipents.add(natali);
        ListView listTeam = (ListView)findViewById(R.id.listTeam);
        ListView listPar = (ListView)findViewById(R.id.listaPar);
        teamAdapter = new ArrayAdapter<Team>(this, android.R.layout.simple_list_item_1, teams);
        parAdapter = new ArrayAdapter<Partisipent>(this, android.R.layout.simple_list_item_1, partisipents);

        listPar.setOnItemClickListener(new ListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    final View view,
                                    int position /*The position of the view in the adapter.*/,
                                    long id /* The row id of the item that was clicked */) {
                positionOfPar = position;
                reslutDialog.show(getFragmentManager(), partisipents.get(position).getName());
                Log.d(LOG_TAG, "item clicked, pos:" + position + " id: " + id);
            }
        });
        listTeam.setAdapter(teamAdapter);

        listPar.setAdapter(parAdapter);

    }


    @Override
    public void onDialogPositiveClick(android.app.DialogFragment dialog, String s, int id) {
        Log.d(LOG_TAG, "Value was returned from dialog " + s);
        Log.d(LOG_TAG, "Value of id is "+ id);
        double d = Double.valueOf(s);
        typeOfcontest = id;
        if(id == 0){
            int i = (int)d;
            partisipents.get(positionOfPar).setContestPoint(i);
        }
        else{
            partisipents.get(positionOfPar).setTimeContest(d);
        }

    }

    @Override
    public void onDialogNegativeClick(android.app.DialogFragment dialog) {
        dialog.getDialog().cancel();
    }

    public void onClickUpdate(View v){
        if(typeOfcontest == 0){
            partisipents.sort(comparePartisipent);
            for(int i = 0; i < partisipents.size(); i++){
                partisipents.get(i).updatePoints(i+1);
            }
        }
        else{
            partisipents.sort(compareTimedConstest);
            for (int i = 0; i < partisipents.size(); i++){
                partisipents.get(i).updatePoints(i+1);
            }
        }
        ListView listTeam = (ListView) findViewById(R.id.listTeam);
        listTeam.postInvalidate();
        ListView listPar = (ListView) findViewById(R.id.listaPar);
        listPar.postInvalidate();
        listPar.refreshDrawableState();
    }
}
