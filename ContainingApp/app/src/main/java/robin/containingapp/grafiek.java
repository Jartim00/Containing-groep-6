package robin.containingapp;

//imports
import java.util.ArrayList;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.logging.Handler;


public class grafiek extends Activity {
    //variabelen
    public static int agvz;
    public static int binns;
    public static int vracht;
    public static int zschip;
    public static int opsl;
    public static int trei;
    public static int divers;
    int counter = 0;
    //url-string
    String loginURL="http://217.120.103.158/test.php";
    //volley RequestQueue
    RequestQueue requestQueue;
    //context aanmaken voor in de for-loop
    Context mContext = this;
    //het initialiseren van een Barchart, een grafiek
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafiek);
        /*if(savedInstanceState!=null){
            Log.d("STATE", savedInstanceState.toString());
        }*/

        //requestqueue initialiseren
        requestQueue = Volley.newRequestQueue(this);
        //Barchart aan het id van de XML koppelen
        chart = (BarChart) findViewById(R.id.chart);
        //JSONObjectRequest maken voor het parsen van JSONdata
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, loginURL, null,
                //Responselistener aanmaken voor de JSONobjecten
                new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //JSON-structuur = {[{}]} waarvan de eerste "{}" als is gebruikt in de request.
                            try {
                                //het eerste object is al geinitialiseerd, wat volgt is een Array, een JSONArray
                                JSONArray ja = response.getJSONArray("result");
                                //in de array staan alle gegevens, dus loop je deze eruit.
                                for (int i = 0; i < ja.length(); i++) {
                                    //in de array zit nog een JSONObject, hieruit loop je de gegevens met index i.
                                    JSONObject jsonObject = ja.getJSONObject(i);
                                    //alle JSON-gegevens worden opgeslagen als strings.
                                    String agv = jsonObject.getString("agv");
                                    String binnenschip = jsonObject.getString("binnenschip");
                                    String vrachtwagen = jsonObject.getString("vrachtwagen");
                                    String zeeschip = jsonObject.getString("zeeschip");
                                    String opslag = jsonObject.getString("opslag");
                                    String trein = jsonObject.getString("trein");
                                    String diversen = jsonObject.getString("diversen");
                                    //hier worden de variabelen die boven zijn aangegeven opgeroepen, dit zet de bovenstaande Strings om naar int's
                                    agvz = Integer.parseInt(agv);
                                    binns = Integer.parseInt(binnenschip);
                                    vracht = Integer.parseInt(vrachtwagen);
                                    zschip = Integer.parseInt(zeeschip);
                                    opsl = Integer.parseInt(opslag);
                                    trei = Integer.parseInt(trein);
                                    divers = Integer.parseInt(diversen);
                                    // de variabelen worden ingeladen in een Arraylist, de constructor kan alleen int lezen!
                                    ArrayList<BarEntry> entries = new ArrayList<>();
                                    entries.add(new BarEntry(agvz, 0));
                                    entries.add(new BarEntry(binns, 1));
                                    entries.add(new BarEntry(vracht, 2));
                                    entries.add(new BarEntry(zschip, 3));
                                    entries.add(new BarEntry(opsl, 4));
                                    entries.add(new BarEntry(trei, 5));
                                    entries.add(new BarEntry(divers, 6));
                                    //alle entries worden in een dataset gepusht.
                                    BarDataSet dataset = new BarDataSet(entries, "Aantal containers");
                                    //dit is om alle namen boven de lijnen van de grafiek te zetten.
                                    ArrayList<String> labels = new ArrayList<String>();
                                    labels.add("AGV");
                                    labels.add("Binnenschip");
                                    labels.add("Vrachtwagen");
                                    labels.add("Zeeschip");
                                    labels.add("Opslag");
                                    labels.add("Trein");
                                    labels.add("Diversen");
                                    //hier wordt de grafiek, de Barchart geinitialiseerd.
                                    chart = new BarChart(mContext);
                                    //content setten
                                    setContentView(chart);
                                    //data in de grafiek laden
                                    BarData data = new BarData(labels, dataset);
                                    chart.setData(data);
                                    chart.setDescription("");
                                    //de grafiek opkleuren met willekeurige kleuren.
                                    dataset.setColors(ColorTemplate.COLORFUL_COLORS);
                                    //leuke animatie toepassen, duurt 2.5 seconden voordat de animatie klaar is.

                                    if(counter == 0) {
                                        chart.animateY(2500);
                                        counter++;
                                    }


                                }

                            }
                            //exceptions opvangen
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //error's loggen
                            Log.e("Volley", "Error");

                        }
                    }
                );
                //objectrequest toevoegen aan de JSONObjectRequest
                requestQueue.add(jor);
    }
}




