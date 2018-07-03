package com.dz.elen.homeworks.Homework6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> students;
    private Context context;

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }


//    public StudentAdapter(List<Student> students, ListOfStudentsActivity listOfStudentsActivity) {
   // }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list_item, viewGroup, false);
        return new  ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(this.students.get(i));

    }

    @Override
    public int getItemCount() {
        return this.students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView mail;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            mail = (TextView) itemView.findViewById(R.id.email);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

        public void bind(Student student) {
            name.setText(student.getName());
            mail.setText(student.getMail());
            image.setImageResource(student.getImage());

        }
    }
}
