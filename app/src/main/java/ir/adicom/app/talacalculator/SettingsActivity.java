package ir.adicom.app.talacalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.linearLayout);
        spec.setIndicator("تنظیمات دستی");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.linearLayout2);
        spec.setIndicator("تنظیمات اتوماتیک");
        host.addTab(spec);

        for(int i=0; i<host.getTabWidget().getChildCount(); i++) {
            if (i != host.getCurrentTab())
                host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
        host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFFFFF"));

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String s) {
                for(int i=0; i<host.getTabWidget().getChildCount(); i++) {
                    if (i != host.getCurrentTab())
                        host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#CCCCCC"));
                }

                host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
    }
}
