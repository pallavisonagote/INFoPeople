package com.example.infopeople;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference cardref= db.collection("USER");
    private cardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Query query;
        query = cardref.orderBy("date", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<card> options= new FirestoreRecyclerOptions.Builder<card>()
                .setQuery(query,card.class)
                .build();

        cardAdapter =new cardAdapter(options);
        RecyclerView recyclerView= findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cardAdapter);



    }
    @Override
    protected   void onStart(){
        super.onStart();
        cardAdapter.startListening();
    }
    @Override
    protected   void onStop() {
        super.onStop();
        cardAdapter.stopListening();

    }
}

