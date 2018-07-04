package com.dz.elen.homeworks.Homework6;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<MyHolder>{

    private List<Student> students;
    private Context context;




    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list_item, viewGroup, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int i) {

        final String name = students.get(i).getName();
        final String mail = students.get(i).getMail();
        final int img = students.get(i).getImage();

        holder.nameTxt.setText(name);
        holder.mailTxt.setText(mail);
        holder.imageView.setImageResource(img);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openStudentActivity(name,mail,img, pos);
            }
        });


    }

    @Override
    public int getItemCount() {

        return students.size();
    }

    private void openStudentActivity(String name, String mail, int image, int position){
        Intent intent = new Intent(context, StudentActivity.class);

        intent.putExtra("NAME_KEY", name);
        intent.putExtra("MAIL_KEY", mail);
        intent.putExtra("IMG_KEY", image);
        intent.putExtra("POS_KEY", position);

        context.startActivity(intent);



    }
}


