package com.example.myandroidtest.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidtest.R;
import com.example.myandroidtest.interfaces.GoToOneLessonFragment;
import com.example.myandroidtest.models.LessonModel;

public class LessonsViewHolder extends RecyclerView.ViewHolder {

    private ImageView mLessonImage;
    private TextView mLessonTitle;
    private LessonModel mLessonModel;


    public LessonsViewHolder(View itemView, GoToOneLessonFragment goToOneLessonFragment) {
        super(itemView);
        mLessonImage = itemView.findViewById(R.id.lesson_image);
        mLessonTitle = itemView.findViewById(R.id.lesson_title);
        itemView.setOnClickListener(v -> {
            if(mLessonModel != null){
                goToOneLessonFragment.goToOneLessonFrag(mLessonModel);
            }
        });
    }

    public void updateItemWithLesson(LessonModel lessonModel){
        mLessonModel = lessonModel;
        mLessonImage.setImageResource(lessonModel.getImageRessource());
        mLessonTitle.setText(lessonModel.getTitle());
    }
}
