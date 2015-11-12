package robin.containingtest2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class grafiek extends AppCompatActivity {
    int aantalAgv;
    int aantalKraan;
    int aantalVrachtwagen;
    int aantalBoot;
    int aantalOpslag;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafiek);



        aantalAgv = 45;
        aantalKraan = 55;
        aantalVrachtwagen = 120;
        aantalBoot = 550;
        aantalOpslag = 200;

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(aantalAgv, 0));
        entries.add(new BarEntry(aantalKraan, 1));
        entries.add(new BarEntry(aantalVrachtwagen, 2));
        entries.add(new BarEntry(aantalBoot, 3));
        entries.add(new BarEntry(aantalOpslag, 4));
        BarDataSet dataset = new BarDataSet(entries, "Aantal containers");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("AGV");
        labels.add("Kraan");
        labels.add("Vrachtwagen");
        labels.add("Boot");
        labels.add("Opslag");

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
