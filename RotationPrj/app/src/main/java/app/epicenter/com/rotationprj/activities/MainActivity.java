package app.epicenter.com.rotationprj.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.epicenter.com.rotationprj.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    String str = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);

        editText = (EditText)findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button buttonShow = (Button)findViewById(R.id.buttonShow);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = editText.getText().toString();
                Toast.makeText(MainActivity.this,
                        str,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        Button show2 = (Button)findViewById(R.id.buttonShow2);

        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        str,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        Log.d("Life_cycle", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life_cycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life_cycle", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life_cycle", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life_cycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life_cycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life_cycle", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Life_cycle", "onSaveInstanceState");
        outState.putString("my_str", str);
        Log.d("Life_cycle_saved_val", str);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Life_cycle", "onRestoreInstanceState");
        str = savedInstanceState.getString("my_str");
        Log.d("Life_cycle_restored_val", str);
    }
}
