package com.example.myandroidtest.views;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidtest.R;
import com.example.myandroidtest.interfaces.GoToOneLessonFragmentListener;
import com.example.myandroidtest.models.LessonModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LessonsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ImageButton mStar1;
    private final ImageButton mStar2;
    private final ImageButton mStar3;
    private final ImageButton mStar4;
    private final ImageButton mStar5;

    private List<ImageButton> mStarList;

    private final ImageView mLessonImage;
    private final TextView mLessonTitle;
    private LessonModel mLessonModel;


    public LessonsViewHolder(View itemView, GoToOneLessonFragmentListener goToOneLessonFragmentListener) {
        super(itemView);
        mLessonImage = itemView.findViewById(R.id.lesson_image);
        mLessonTitle = itemView.findViewById(R.id.lesson_title);
        mStar1 = itemView.findViewById(R.id.star1);
        mStar2 = itemView.findViewById(R.id.star2);
        mStar3 = itemView.findViewById(R.id.star3);
        mStar4 = itemView.findViewById(R.id.star4);
        mStar5 = itemView.findViewById(R.id.star5);

        mStarList = new ArrayList<>(Arrays.asList(mStar1, mStar2, mStar3, mStar4, mStar5));

        for(ImageButton oneStar : mStarList){
            oneStar.setOnClickListener(this);
        }

        itemView.setOnClickListener(v -> {
            if(mLessonModel != null){
                goToOneLessonFragmentListener.goToOneLessonFrag(mLessonModel);
            }
        });
    }

    public void updateItemWithLesson(LessonModel lessonModel){
        mLessonModel = lessonModel;
        mLessonImage.setImageResource(lessonModel.getImageRessource());
        mLessonTitle.setText(lessonModel.getTitle());
        initStars();
    }

    @Override
    public void onClick(View v) {
        switch (Integer.parseInt(v.getTag().toString())){
            case 1:
                mLessonModel.setScore(1);
                initStars();
                break;
            case 2:
                mLessonModel.setScore(2);
                initStars();
                break;
            case 3:
                mLessonModel.setScore(3);
                initStars();
                break;
            case 4:
                mLessonModel.setScore(4);
                initStars();
                break;
            case 5:
                mLessonModel.setScore(5);
                initStars();
                break;
        }

    }

    private void initStars(){
        switch (mLessonModel.getScore()){
            case 0:
                setStars(new ArrayList<>(Arrays.asList()));
                break;
            case 1:
                setStars(new ArrayList<>(Arrays.asList(mStar1)));
                break;
            case 2:
                setStars(new ArrayList<>(Arrays.asList(mStar1, mStar2)));
                break;
            case 3:
                setStars(new ArrayList<>(Arrays.asList(mStar1, mStar2, mStar3)));
                break;
            case 4:
                setStars(new ArrayList<>(Arrays.asList(mStar1, mStar2, mStar3, mStar4)));
                break;
            case 5:
                setStars(new ArrayList<>(Arrays.asList(mStar1, mStar2, mStar3, mStar4, mStar5)));
                break;
            default:
                break;
        }
    }

    private void setStars(ArrayList<ImageButton> starsList){

        mStar1.setImageResource(R.drawable.ic_baseline_star_border_24);
        mStar2.setImageResource(R.drawable.ic_baseline_star_border_24);
        mStar3.setImageResource(R.drawable.ic_baseline_star_border_24);
        mStar4.setImageResource(R.drawable.ic_baseline_star_border_24);
        mStar5.setImageResource(R.drawable.ic_baseline_star_border_24);

        for(ImageButton star : starsList){
            star.setImageResource(R.drawable.ic_baseline_star_24);
        }




    }
}
