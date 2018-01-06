package com.mobileapps.ark.teammaker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ArK on 1/5/2018.
 */

public class RecyclerAdapterMain extends RecyclerView.Adapter<RecyclerAdapterMain.ViewHolder>{


    private final List<PlayerObject> mitems;
    private Context mcontext;

    public RecyclerAdapterMain(List<PlayerObject> mitems, Context mcontext) {
        this.mitems = mitems;
        this.mcontext = mcontext;
    }
    public Context getContext(){
        return mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemsView = inflater.inflate(R.layout.recycler_layout_main,parent,false);

        ViewHolder viewHolder = new ViewHolder(itemsView);

        return viewHolder;
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView PlayerNumber;
        public Button clickMebutton;



        public ViewHolder(View itemView) {
            super(itemView);

            PlayerNumber = (TextView)itemView.findViewById(R.id.textview_recycler_playerNumber);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

//            int position = getAdapterPosition();
//            if(position != RecyclerView.NO_POSITION){
//
//                 Log.d("democlick","enetred click");
//                final PlayerObject  items = mitems.get(position);
//                Log.d("demoitemsbfore",items.toString());
//                items.setShowStatus("show");
//                Log.d("demoitemsaftre",items.toString());
//
//
//
//            }

        }
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterMain.ViewHolder viewHolder, final int position)  {




        final PlayerObject  items = mitems.get(position);
        final TextView titletext = viewHolder.PlayerNumber;

        titletext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.setShowStatus("show");
                titletext.setText("number= "+ items.getPlayerNumber());
            }
        });

        if(items.getShowStatus().equals("hide")){

            titletext.setText("click For Ur Number");
        }else{

            titletext.setText("number= "+ items.getPlayerNumber());
        }





    }

    @Override
    public int getItemCount() {
        return mitems.size();
    }
}
