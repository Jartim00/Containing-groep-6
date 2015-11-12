package robin.containingtest2;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Robin on 12-11-2015.
 */
public class MainMenu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Button grafiek = (Button) findViewById(R.id.grafiek);

        grafiek.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                goToGrafiek();

            }

        });
    }
    private void goToGrafiek() {

        Intent intent = new Intent(MainMenu.this, grafiek.class);

        startActivity(intent);

    }
}


