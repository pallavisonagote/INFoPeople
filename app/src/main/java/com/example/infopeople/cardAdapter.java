package com.example.infopeople;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class cardAdapter extends FirestoreRecyclerAdapter <card,cardAdapter.CardHolder>{


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public cardAdapter(@NonNull FirestoreRecyclerOptions<card> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CardHolder holder, int position, @NonNull card model) {
        holder.tv1name.setText(model.getName());
        holder.tv2age.setText(String.valueOf(model.getAge()));
        holder.tv3date.setText(String.valueOf(model.getDate()));
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);

        return new CardHolder(view);

    }

    public class  CardHolder extends RecyclerView.ViewHolder{

    TextView tv1name;
    TextView tv2age;
    TextView tv3date;

    public CardHolder(@NonNull View itemView) {
        super(itemView);

        tv1name=itemView.findViewById(R.id.text1);
        tv2age=itemView.findViewById(R.id.text2);
        tv3date=itemView.findViewById(R.id.priority_text);

    }
}
}
