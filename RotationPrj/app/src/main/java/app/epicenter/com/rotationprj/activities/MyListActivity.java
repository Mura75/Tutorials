package app.epicenter.com.rotationprj.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.epicenter.com.rotationprj.R;
import app.epicenter.com.rotationprj.adapters.MyAdapter;
import app.epicenter.com.rotationprj.models.Student;

public class MyListActivity extends AppCompatActivity {

    ListView listView;

    List<Student> studentList;

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        studentList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Student s = new Student("Name " + i,
                    "Surname " + i, "Email " + i,
                    "Phone " + i, "University " + i);

            studentList.add(s);
        }

        listView = (ListView)findViewById(R.id.listView);


        myAdapter = new MyAdapter(MyListActivity.this, studentList);

//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(MyListActivity.this,
//                        R.layout.my_item_list_layout,
//                        R.id.myTextView,
//                        stringList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> parent, View view,
                            int position, long id) {

        Student student = studentList.get(position);
                        Toast.makeText(MyListActivity.this,
                                student.getName() + "\n" +
                                        student.getSurname() + "\n" +
                                        student.getUniversity() + "\n" +
                                        student.getEmail() + "\n" +
                                        student.getPhone(),
                                Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
