package com.tacademy.jeongho.applicationcomponent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
    public static final int REQUEST_OTHER_ACTIVITY = 0;
    EditText inputView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputView = (EditText)findViewById(R.id.edit_input);
        textView = (TextView)findViewById(R.id.textView);

        Button other_btn=(Button)findViewById(R.id.btn_other);
        other_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputView.getText().toString();
                Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                intent.putExtra(OtherActivity.EXTRA_MESSAGE,message);
                startActivityForResult(intent, REQUEST_OTHER_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_OTHER_ACTIVITY && resultCode == Activity.RESULT_OK){
            String result = data.getStringExtra(OtherActivity.REQUEST_RESULT);
            textView.setText(result);
        } else {
            textView.setText("Back누르지마!");
        }
    }
}
