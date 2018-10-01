package com.example.vlad.asl;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;




public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    private Context mCtx;

    private List<Books> booksList;

    public BooksAdapter(Context mCtx, List<Books> booksList) {
        this.mCtx = mCtx;
        this.booksList = booksList;
    }

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksViewHolder holder, int position) {
        Books book = booksList.get(position);
        holder.textViewTitle.setText(book.getTitle());
        holder.textViewRating.setText(String.valueOf(book.getRating()));
        holder.btnpodr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infobook = new Intent(v.getContext(),
                        info.class);
                mCtx.startActivity(infobook);
            }
        });
    }


    @Override
    public int getItemCount() {
        return booksList.size();
    }


    class BooksViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewRating;
        Button btnpodr;


        public BooksViewHolder(View itemView) {
            super(itemView);
            btnpodr = itemView.findViewById(R.id.btnpodr);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRating = itemView.findViewById(R.id.textViewRating);


        }
    }


}