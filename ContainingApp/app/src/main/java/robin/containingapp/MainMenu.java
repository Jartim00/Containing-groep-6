package robin.containingapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Robin on 12-11-2015.
 */
public class MainMenu extends Activity {
    private Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        final Button grafiek = (Button) findViewById(R.id.grafiek);
        final Button info = (Button) findViewById(R.id.info);

        grafiek.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                grafiek.setBackgroundColor(Color.GRAY);
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        grafiek.setBackgroundColor(Color.BLACK);
                    }
                }.start();
                goToGrafiek();

            }

        });
        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                info.setBackgroundColor(Color.GRAY);
                new CountDownTimer(1000, 50) {

                    @Override
                    public void onTick(long arg0) {
                    }

                    @Override
                    public void onFinish() {
                        info.setBackgroundColor(Color.BLACK);
                    }
                }.start();
                goToInfo();

            }

        });
    }

    private void goToGrafiek() {

        Intent intent = new Intent(MainMenu.this, grafiek.class);
        startActivity(intent);
    }

    private void goToInfo(){
        Intent intents = new Intent(MainMenu.this, MainActivity.class);
        startActivity(intents);
    }
}


