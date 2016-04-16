package ant.com.fragmentsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ant.com.fragmentsapp.R;
import ant.com.fragmentsapp.fragments.CinemaFragment;
import ant.com.fragmentsapp.fragments.FirstFragment;
import ant.com.fragmentsapp.fragments.RecyclerFragment;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d("Test_rot_act", "onCreate");

        CinemaFragment fragment = new CinemaFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.test_container, fragment)
                .commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Test_rot_act", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Test_rot_act", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Test_rot_act", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Test_rot_act", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Test_rot_act", "onDestroy");
    }
}
