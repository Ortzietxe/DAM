package com.example.practica5;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("LLAMADAS");
        tabs.addTab(spec);

        ListView lvLista1 = findViewById(R.id.lvLista1);
        final String[] llamadas = new String[] {"PAPA","MAMA","HERMANO","AMIGO", "PRIMO"};
        ArrayAdapter<String> adaptadorListView1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, llamadas);
        lvLista1.setAdapter(adaptadorListView1);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CHATS");
        tabs.addTab(spec);

        ListView lvLista2 = findViewById(R.id.lvLista2);
        final String[] chats = new String[] {"AMIGO", "PRIMO","PAPA","HERMANO","MAMA"};
        ArrayAdapter<String> adaptadorListView2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, chats);
        lvLista2.setAdapter(adaptadorListView2);

        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("CONTACTOS");
        tabs.addTab(spec);

        ListView lvLista3 = findViewById(R.id.lvLista3);
        final String[] contactos = new String[] {"AMIGO","HERMANO","MAMA","PAPA", "PRIMO"};
        ArrayAdapter<String> adaptadorListView3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, contactos);
        lvLista3.setAdapter(adaptadorListView3);

        tabs.setCurrentTab(0);
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public
            void onTabChanged(String s) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;

    }
}