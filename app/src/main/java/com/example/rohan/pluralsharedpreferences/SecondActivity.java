package com.example.rohan.pluralsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    TextView txvName, txvProfession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvName = findViewById(R.id.txvName);
        txvProfession = findViewById(R.id.txvProfession);

    }

    public void removeProfessionKey(View view) {

        SharedPreferences sp = getSharedPreferences(getPackageName()+"myFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(MyConstant.NAME);
        editor.apply();

    }

    public void clearAccountData(View view) {

        SharedPreferences sp = getSharedPreferences(getPackageName()+"myFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();

    }

    public void loadAccountData(View view) {
        // activity application level
        SharedPreferences sp = getSharedPreferences(getPackageName()+"myFile", Context.MODE_PRIVATE);

        String name = sp.getString(MyConstant.NAME,"N/A");
        String profession = sp.getString(MyConstant.PROFESSION,"N/A");
        txvName.setText(name);
        txvProfession.setText(profession);

    }
}
