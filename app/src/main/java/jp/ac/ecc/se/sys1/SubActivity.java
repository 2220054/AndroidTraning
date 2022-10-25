package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {


    Intent intent3 = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sub);
        setContentView(R.layout.activity_const);
        //setContentView(R.layout.activity_const2);

        //setTitle("Sub Activity");

        //画面上のパーツの宣言部
        TextView nameLavel = findViewById(R.id.nameLabel);
        EditText nameText = findViewById(R.id.nameText2);
        Button clearbutton = findViewById(R.id.clearbutton2);
        Button comfilmButton = findViewById(R.id.comfilmButton);
        Button sendButton = findViewById(R.id.sendbutton2);

        nameLavel.setText("Name");

        sendButton.setOnClickListener(this);
        comfilmButton.setOnClickListener(this);

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");


            }
        });






    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this , EventActivity.class);

        setTitle("Button Clicked");

        switch (view.getId()) {

            case R.id.comfilmButton:
                setTitle("確認Button Clicked");
                Toast.makeText(this,"確認クリック", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sendbutton2:
                setTitle("送信Button Clicked");
                Toast.makeText(this,"送信クリック", Toast.LENGTH_SHORT).show();
                intent.putExtra("age" , 19);
                startActivity(intent);
                break;
        }
    }
}