package com.mobileapps.ark.teammaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText EditTextNumberOfPlayers;
    Button buttonGoMain;
    RecyclerView recyclerView_main;
    RecyclerAdapterMain recyclerAdapterMain;
    ArrayList<PlayerObject> emptydatalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTextNumberOfPlayers = (EditText)findViewById(R.id.editText_main_no_of_players);
        buttonGoMain = (Button)findViewById(R.id.button_main_Go);
        recyclerView_main = (RecyclerView)findViewById(R.id.recyclerview_main_playernumbers);




        buttonGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EditTextNumberOfPlayers.getText().equals("")){
                    Toast.makeText(MainActivity.this,"enter no.of players",Toast.LENGTH_SHORT).show();
                }else{

                    Log.d("demo",EditTextNumberOfPlayers.getText().toString());
                    generatePlayerNumbersList(Integer.parseInt(EditTextNumberOfPlayers.getText().toString()));

                }
            }
        });








    }

    public void generatePlayerNumbersList(int NumberOfPlayers){

        List<Integer> SequenceNumberList = new ArrayList<>();
        ArrayList<PlayerObject> ShuffledNumberList = new ArrayList<>();

        for(int i=0;i<NumberOfPlayers;i++){


            SequenceNumberList.add(i);

        }

        Collections.shuffle(SequenceNumberList);

        Log.d("demolist",SequenceNumberList.toString());

        for(int i=0;i<SequenceNumberList.size();i++){

            PlayerObject playerObject = new PlayerObject();
            playerObject.setPlayerNumber(SequenceNumberList.get(i));
            playerObject.setShowStatus("hide");

            ShuffledNumberList.add(playerObject);

        }

        Log.d("demolis1t",ShuffledNumberList.toString());

        recyclerAdapterMain = new RecyclerAdapterMain(ShuffledNumberList,MainActivity.this);
        recyclerView_main.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView_main.setAdapter(recyclerAdapterMain);
        recyclerView_main.setHasFixedSize(true);



    }
}
