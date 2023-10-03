package com.example.myappstady;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CVEAdapter extends RecyclerView.Adapter<CVEAdapter.HolderView> {
    private Context context;

    private int layoutID;
    private ArrayList<CVE> CVEs;
    private LinearLayoutCompat linearLayoutCompat;

    public class HolderView extends RecyclerView.ViewHolder {
        private TextView text_item;

        public HolderView(View itemView) {
            super(itemView);
            text_item = itemView.findViewById(R.id.text_item);
            linearLayoutCompat = itemView.findViewById(R.id.item_item);
        }
    }

    public CVEAdapter(Context context, int layoutID, ArrayList<CVE> CVEs) {
        this.context = context;
        this.layoutID = layoutID;
        this.CVEs = CVEs;
    }

    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutID,parent,false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(HolderView holder, int position) {
        CVE cve = CVEs.get(position);
        holder.text_item.setText(cve.getId());

        linearLayoutCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("CVEid",cve.getId());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return CVEs.size();
    }


}
