package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //宣言
        ImageView comfilmFab = findViewById(R.id.comfilmFab);

        //前画面の情報を受け取る
        Intent intent = getIntent();


        //画像をセットし、表示

        comfilmFab.setImageURI();

    }
}