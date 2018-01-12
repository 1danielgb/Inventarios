package com.example.hobo.inventarios.viewObjeto;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hobo.inventarios.R;

public class Objeto extends AppCompatActivity {

    TextView tvName, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Objeto");

        tvName = (TextView) findViewById(R.id.tvNameObjeto);
        tvDesc = (TextView) findViewById(R.id.tvDescriptionObjeto);

        Bundle bundle = getIntent().getExtras();

        tvDesc.setText(bundle.getString("name"));
        tvName.setText(bundle.getString("desc"));
    }
}
