package jp.ac.ecc.se.sys1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentActivity extends AppCompatActivity {

    final int CAMERA_RESULT = 100;
    Uri imageUri;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_RESULT && resultCode == RESULT_OK){
            ImageView cameraImage = findViewById(R.id.cameraImage);
            /*
            Bitmap bitmap = data.getParcelableExtra("data");


            cameraImage.setImageBitmap(bitmap);
             */
            cameraImage.setImageURI(imageUri);


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //画面上のパーツを宣言
        EditText searchText = findViewById(R.id.searchText);
        Button searchButton = findViewById(R.id.searchButton);
        Button cameraButton = findViewById(R.id.cameraButton);
        Button comfilmButton = findViewById(R.id.comfilmButton);

        //移行する画面の宣言
        Intent ImageIntent = new Intent(this, ImageActivity.class);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //ファイル名
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "Traning_" + "_.jpg";
                //パラメータの設定
                ContentValues valses = new ContentValues();
                valses.put(MediaStore.Images.Media.TITLE, fileName);
                valses.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                //保存画像情報のURLを生成
                imageUri =
                        getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, valses);
                //カメラ起動のIntentにパラメータをセットする
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent,CAMERA_RESULT);

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,query);

                startActivity(intent);
            }
        });

        comfilmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageUri != null){
                    ImageIntent.putExtra("photo", imageUri);
                    startActivity(ImageIntent);
                }


            }
        });
    }
}