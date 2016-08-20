package ir.adicom.app.talacalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalc;
    TextView txtResult;
    EditText edtWeight, edtPrice, edtGoldPrice;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    int percentSaller,percentTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        percentSaller = prefs.getInt("percent", -1);
        if (percentSaller == -1) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("percent", 7);
            editor.putInt("tax", 8);
            editor.commit();
            percentSaller = 7;
            percentTax = 8;
        }

        btnCalc = (Button) findViewById(R.id.btnCalc);
        txtResult = (TextView) findViewById(R.id.txtResult);

        edtWeight = (EditText) findViewById(R.id.editText);
        edtGoldPrice = (EditText) findViewById(R.id.editText2);
        edtPrice = (EditText) findViewById(R.id.editText3);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setVisibility(View.VISIBLE);
                int goldPrice = Integer.parseInt(edtGoldPrice.getText().toString());
                int price = Integer.parseInt(edtPrice.getText().toString());
                float w = Float.parseFloat(edtWeight.getText().toString());
                double r = (goldPrice+price)*w;
                r += r*percentSaller/100;
                r += r*percentTax/100;
                txtResult.setText("نهایت قیمت خرید " + r);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        percentSaller = prefs.getInt("percent", -1);
        if (percentSaller == -1) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("percent", 7);
            editor.putInt("tax", 8);
            editor.commit();
            percentSaller = 7;
            percentTax = 8;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return true;
    }
}
