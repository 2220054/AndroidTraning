package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] currylist = {"ドライカレー","カツカレー","チーズカレー","スープカレー"};

        //移行する画面の宣言
        Intent preferencesIntent = new Intent(this,PreferencesActivity.class);

        //画面上のパーツを宣言
        ListView listview = findViewById(R.id.currylist);

        //配列セット用のアダプター宣言
        ArrayAdapter<String> adapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1,currylist);

        //画面上のListviewにアダプターの配列データ表示
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;
                String st = (String) adapterView.getItemAtPosition(i);
                //Toast.makeText(getApplicationContext(), tv.getText(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), tv.getText(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), st, Toast.LENGTH_SHORT).show();

                //何番目を選んだか送る
                preferencesIntent.putExtra("curry",i);
                //画面遷移
                startActivity(preferencesIntent);


            }
        });
    }
}