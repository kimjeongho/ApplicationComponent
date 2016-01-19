package com.tacademy.jeongho.applicationcomponent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    TextView sendView;
    EditText resultView;
    public static final String EXTRA_MESSAGE = "message";
    public static final String REQUEST_RESULT = "result_message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        sendView = (TextView)findViewById(R.id.text_send);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        sendView.setText(message);

        resultView = (EditText)findViewById(R.id.edit_result);

        Button finish_btn = (Button)findViewById(R.id.btn_finish);
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(REQUEST_RESULT,resultView.getText().toString());
                setResult(Activity.RESULT_OK,data);
                finish();
            }
        });
    }
}
