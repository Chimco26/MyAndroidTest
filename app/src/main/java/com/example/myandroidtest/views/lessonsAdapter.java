package com.example.myandroidtest.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidtest.R;
import com.example.myandroidtest.interfaces.GoToOneLessonFragment;
import com.example.myandroidtest.models.LessonModel;

import java.util.List;

public class lessonsAdapter extends RecyclerView.Adapter<LessonsViewHolder> {

    List<LessonModel> mListLessons;
    GoToOneLessonFragment mGoToOneLessonFragment;

    public lessonsAdapter(List<LessonModel> mListLessons, GoToOneLessonFragment goToOneLessonFragment) {
        this.mListLessons = mListLessons;
        this.mGoToOneLessonFragment = goToOneLessonFragment;
    }

    @Override
    public LessonsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lesson, parent, false);
        return new  LessonsViewHolder(view, mGoToOneLessonFragment);
    }

    @Override
    public void onBindViewHolder(LessonsViewHolder holder, int position) {
        holder.updateItemWithLesson(this.mListLessons.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mListLessons.size();
    }
}
