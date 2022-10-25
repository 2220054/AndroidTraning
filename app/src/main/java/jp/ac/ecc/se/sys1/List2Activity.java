package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        //移行する画面の宣言
        Intent intentE = new Intent(this , EventActivity.class);
        Intent intentS = new Intent(this , SubActivity.class);

        Button tuika = findViewById(R.id.tuika);
        ListView Lv = findViewById(R.id.datalist);
        EditText namae = findViewById(R.id.namae3);

        //可変長のString配列
        ArrayList<String> datalist = new ArrayList<>();

        //配列セット用のアダプター宣言
        ArrayAdapter<String> adapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1,datalist);

        //画面上のListviewにアダプターの配列データ表示
        Lv.setAdapter(adapter);

        //データ追加ボタン
        tuika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tT = namae.getText().toString();
                if(!tT.equals("")) {
                    //1.追加する文字列を配列に追加
                    datalist.add(tT);
                    //2.リスト再表示
                    Lv.setAdapter(adapter);
                    //3.テキストクリア
                    namae.setText("");
                }

            }
        });

        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i%2){
                    case 0 :
                        startActivity(intentE);
                        break;
                    case 1 :
                        startActivity(intentS);
                        break;
                }
            }
        });










    }
}