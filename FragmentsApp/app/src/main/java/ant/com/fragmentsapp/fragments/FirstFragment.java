package ant.com.fragmentsapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ant.com.fragmentsapp.MainActivity;
import ant.com.fragmentsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    Button button;

    Context parentContext;

    public FirstFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parentContext = context;
        Log.d("Test_rot_frag", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Test_rot_frag", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Log.d("Test_rot_frag", "onCreateView");
        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentContext, MainActivity.class);
                startActivity(intent);

                Toast.makeText(getActivity(),
                        "Hello",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Test_rot_frag", "onViewCreated");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Test_rot_frag", "onActivityCreated");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Test_rot_frag", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Test_rot_frag", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Test_rot_frag", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Test_rot_frag", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Test_rot_frag", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Test_rot_frag", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Test_rot_frag", "onDetach");
    }
}
