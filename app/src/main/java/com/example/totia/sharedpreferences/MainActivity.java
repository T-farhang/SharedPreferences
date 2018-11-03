package com.example.totia.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final String MYPREFERENCE = "MyPreference";
    public final String NAME = "PreferenceName";
    public final String PHONE = "PreferencePhone";
    public final String EMAIL = "PreferenceEmail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void registerClickListener(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(MYPREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText edtName = (EditText) findViewById(R.id.edtName);
        EditText edtPhone = (EditText) findViewById(R.id.edtPhone);
        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        editor.putString(NAME, edtName.getText().toString());
        editor.putString(PHONE, edtPhone.getText().toString());
        editor.putString(EMAIL, edtEmail.getText().toString());
        editor.commit();
        Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_SHORT).show();

    }

    public void showPhoneClickListener(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(MYPREFERENCE, Context.MODE_PRIVATE);
        String phone = sharedPreferences.getString(PHONE,null);
        Toast.makeText(MainActivity.this,phone,Toast.LENGTH_SHORT).show();
    }
}
