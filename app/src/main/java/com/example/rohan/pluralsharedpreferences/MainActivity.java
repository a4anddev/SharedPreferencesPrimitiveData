package com.example.rohan.pluralsharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etProfession;
    private TextView txvName, txtProfession;
    private Switch pageColorSwitch;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etProfession = findViewById(R.id.etProfession);

        txvName = findViewById(R.id.txvName);
        txtProfession = findViewById(R.id.txvProfession);

        pageColorSwitch = findViewById(R.id.pageColorSwitch);

        linearLayout = findViewById(R.id.linearLayout);


        pageColorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                setPageColor(isChecked);

            }
        });

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
       boolean isChecked = sp.getBoolean("green",false);

        pageColorSwitch.setChecked(isChecked);

        Toast.makeText(this, "sharedPreferens " +isChecked, Toast.LENGTH_SHORT).show();


    }

    private void setPageColor(boolean isChecked) {

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        // editor is interface for store data
        editor.putBoolean("green",isChecked);
        editor.apply();

        linearLayout.setBackgroundColor(isChecked? Color.GREEN:Color.WHITE);

    }


    public void SaveAccountData(View view) {

        // activity level
//        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);


       // activity application level
        SharedPreferences sp = getSharedPreferences(getPackageName()+"myFile",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        // editor is interface for store data

        editor.putString(MyConstant.NAME,etName.getText().toString());
        editor.putString(MyConstant.PROFESSION, etProfession.getText().toString());
        editor.apply(); // apply method will not return any value and work asynchronously

        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();

    }


    public void loadAccountData(View view) {

        // activity level
//        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);

        // activity application level
        SharedPreferences sp = getSharedPreferences(getPackageName()+"myFile",Context.MODE_PRIVATE);

        String name = sp.getString(MyConstant.NAME,"N/A");
        String profession = sp.getString(MyConstant.PROFESSION,"N/A");
        txvName.setText(name);
        txtProfession.setText(profession);

    }

    public void openSecondActivity(View view) {

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

    }


}
