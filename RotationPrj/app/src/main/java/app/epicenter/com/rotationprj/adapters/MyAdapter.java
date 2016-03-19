package app.epicenter.com.rotationprj.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.epicenter.com.rotationprj.R;
import app.epicenter.com.rotationprj.models.Student;

public class MyAdapter extends BaseAdapter {

    Context context;

    List<Student> studentList;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public MyAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.my_item_list_layout, parent, false);

        TextView nameAndSurname = (TextView)view.findViewById(R.id.myTextView);
        TextView university = (TextView)view.findViewById(R.id.myTextView2);

        Student student = studentList.get(position);

        nameAndSurname.setText(student.getName() + " " + student.getSurname());
        university.setText(student.getUniversity());

        return view;
    }
}
