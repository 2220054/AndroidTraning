package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        //このアプリの情報を保存するファイルをprefに設定
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);

        //画面のパーツを千数にセット
        EditText thoughtsText = findViewById(R.id.kansou);
        Button saveButton = findViewById(R.id.keep);
        Button cancelButton = findViewById(R.id.cancel);
        Button resetButton = findViewById(R.id.reset);

        //カレーごとにプレファレンスを分ける
        String menu[] = {"dry", "cutlet", "cheese", "soup"};

        //前画面の情報を受け取る
        Intent intent = getIntent();
        int curry = intent.getIntExtra("curry", 4);

       // String thoughtsSt = pref.getString("memo", "");
        String thoughtsSt = pref.getString(menu[curry], "");

        thoughtsText.setText(thoughtsSt);

        SharedPreferences.Editor editor = pref.edit();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences.Editor editor = pref.edit();
                editor.putString(menu[curry], thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "保存しました", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(), "終了します", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(menu[curry], null);
                editor.apply();
                Toast.makeText(getApplicationContext(), "リセットしました", Toast.LENGTH_SHORT).show();

                thoughtsText.setText(null);
            }
        });

    }
}