package robin.containingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONObject;

import java.util.ArrayList;


public class grafiek extends AppCompatActivity {


    int aantalAgv;
    int aantalBinnenschip;
    int aantalVrachtwagen;
    int aantalZeeschip;
    int aantalOpslag;
    int aantalTrein;
    int aantalDiversen;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafiek);


        aantalAgv = 32;
        aantalBinnenschip = 55;
        aantalVrachtwagen = 120;
        aantalZeeschip = 550;
        aantalOpslag = 200;
        aantalTrein = 30;
        aantalDiversen = 5;

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(aantalAgv, 0));
        entries.add(new BarEntry(aantalBinnenschip, 1));
        entries.add(new BarEntry(aantalVrachtwagen, 2));
        entries.add(new BarEntry(aantalZeeschip, 3));
        entries.add(new BarEntry(aantalOpslag, 4));
        entries.add(new BarEntry(aantalTrein, 5));
        entries.add(new BarEntry(aantalDiversen, 6));
        BarDataSet dataset = new BarDataSet(entries, "Aantal containers");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("AGV");
        labels.add("Binnenschip");
        labels.add("Vrachtwagen");
        labels.add("Zeeschip");
        labels.add("Opslag");
        labels.add("Trein");
        labels.add("Diversen");

        BarChart chart = new BarChart(this);
        setContentView(chart);

        BarData data = new BarData(labels, dataset);
        chart.setData(data);

        chart.setDescription("Aantal containers per platform");

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        if(counter == 0) {
        chart.animateY(2500);
        counter++;
        }
//        new CountDownTimer(5000, 50) {
//
//            @Override
//            public void onTick(long arg0) {}
//
//            @Override
//            public void onFinish() {
//                finish();
//                startActivity(getIntent());
//            }
//        }.start();
    }
}

