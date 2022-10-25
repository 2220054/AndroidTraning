package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //予備元画面から送られてきたIntent情報を入手
        Intent intent2 = getIntent();
        //int age = intent2.getIntExtra("age" , 25);
        //確認
        //Toast.makeText(this, "年齢:"+age, Toast.LENGTH_SHORT).show();


        //画面上のパーツの宣言部
        TextView profile3 = findViewById(R.id.profile3);
        EditText namae2 = findViewById(R.id.namae2);
        EditText password3 = findViewById(R.id.password3);
        Button clearN = findViewById(R.id.clearN);
        Button clearP = findViewById(R.id.clearP);
        CheckBox jyuu = findViewById(R.id.jyuu);
        CheckBox Nijyuu = findViewById(R.id.nijyuu);
        CheckBox sanjyuu = findViewById(R.id.sanjyuu);
        RadioButton man2 = findViewById(R.id.man2);
        RadioButton woman2 = findViewById(R.id.woman2);
        Button kakunin = findViewById(R.id.kakunin);



        kakunin.setOnClickListener(this);
        clearP.setOnClickListener(this);
        clearN.setOnClickListener(this);

        clearP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(password3.getText());
                return false;
            }
        });

        kakunin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(man2.isChecked()==true){
                    Toast.makeText(getApplicationContext(), R.string.text3, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), R.string.text4, Toast.LENGTH_SHORT).show();
                }

                finish(); //画面消える
                return false;
            }
        });





    }

    @Override
    public void onClick(View view) {
        EditText namae2 = findViewById(R.id.namae2);
        EditText password3 = findViewById(R.id.password3);

        switch (view.getId()){
            case R.id.clearN:
                namae2.setText("");
                break;
            case R.id.clearP:
                password3.setText("");
                setTitle(R.string.app_name);
                break;
            case R.id.kakunin:
                Toast.makeText(this, namae2.getText(), Toast.LENGTH_SHORT).show();

        }
    }
}