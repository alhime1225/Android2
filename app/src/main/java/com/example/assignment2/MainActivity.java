package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openWebsite(View vew){
    EditText editTextForOpenWebsite=findViewById(R.id.txtOpenWeebsite);

        String url = editTextForOpenWebsite.getText().toString();

        if(url == null || url.isEmpty()){
            Toast.makeText(this,"Please enter URL", Toast.LENGTH_LONG ).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void openLocation(View vew){
        EditText editLocation=findViewById(R.id.txtOpenLocation);

        String location = editLocation.getText().toString();

        if(location == null || location.isEmpty()){
            Toast.makeText(this,"Please enter URL", Toast.LENGTH_LONG ).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
        startActivity(intent);
    }

    public void shareText(View vew){
        EditText editText=findViewById(R.id.txtShareText);

        String message = editText.getText().toString();

        /*
        -type = "image/jpeg"
        -text/plain, text/rtf, text/html, text/json
        -video/mp4, video/3gp
        -application/pdf
         */
        String mimeType = "text/plain";
        //Sharing the content to applicable apps
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(message)
                .startChooser();

    }


}