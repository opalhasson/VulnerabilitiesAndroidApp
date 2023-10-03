package com.example.myappstady;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textview_main;
    private RecyclerView recyclerview_main;
    private CVEAdapter itemAdapter;
    private ArrayList<CVE> CVEList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview_main = findViewById(R.id.recyclerview_main);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerview_main.setLayoutManager(layoutManager);

        CVEList = new ArrayList<>();

        itemAdapter = new CVEAdapter(this, R.layout.list_item, CVEList);
        recyclerview_main.setAdapter(itemAdapter);

        getCVEData();
    }


    @SuppressLint("StaticFieldLeak")
    private void getCVEData() {
        new AsyncTask<Void, Void, List<CVE>>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            protected List<CVE> doInBackground(Void... voids) {
                try {
                    String url = "https://services.nvd.nist.gov/rest/json/cves/2.0";
                    ObjectMapper objectMapper = new ObjectMapper();
                    NVD nvd = objectMapper.readValue(new URL(url), NVD.class);

                    if (nvd != null && nvd.getVulnerabilities() != null) {
                        List<CVE> cves = new ArrayList<>();
                        for (NVD.CVEEntry entry : nvd.getVulnerabilities()) {
                            if (entry.getCve() != null) {
                                CVE cve = entry.getCve();
                                cves.add(cve);
                            }
                        }
                        return cves;
                    }
                } catch (IOException e) {
                    Log.e("MainActivity", "Error fetching JSON data: " + e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            protected void onPostExecute(List<CVE> result) {
                if (result != null) {
                    CVEList.addAll(result);
                    itemAdapter.notifyDataSetChanged();
                }
            }
        }.execute();
    }

}

