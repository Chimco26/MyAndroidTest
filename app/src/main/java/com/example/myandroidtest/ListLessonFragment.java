package com.example.myandroidtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myandroidtest.interfaces.GoToOneLessonFragment;
import com.example.myandroidtest.models.LessonModel;
import com.example.myandroidtest.views.lessonsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListLessonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListLessonFragment extends Fragment implements GoToOneLessonFragment {

    List<LessonModel> mListLessons = new ArrayList<>();
    RecyclerView mLessonsRecyclerView;
    TextView mUserName;
    String userName;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    public ListLessonFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListLessonFragment newInstance(String userName) {
        ListLessonFragment fragment = new ListLessonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_class, container, false);
        mLessonsRecyclerView = v.findViewById(R.id.lesson_recyclerView);
        mUserName = v.findViewById(R.id.user_name);
        mUserName.setText(userName);
        initRecyclerView();

        return v;
    }

    private void initLessonList(){
        String[] androidRessources = getResources().getStringArray(R.array.android_ressources);
        String[] webRessources = getResources().getStringArray(R.array.web_ressources);
        String[] djangoRessources = getResources().getStringArray(R.array.django_ressources);
        String[] nodeRessources = getResources().getStringArray(R.array.node_ressources);
        String[] flutterRessources = getResources().getStringArray(R.array.flutter_ressources);

        LessonModel androidLesson = new LessonModel(androidRessources[0], androidRessources[1], androidRessources[2], R.drawable.android_image);
        LessonModel webLesson = new LessonModel(webRessources[0], webRessources[1], webRessources[2], R.drawable.web_image);
        LessonModel djangoLesson = new LessonModel(djangoRessources[0], djangoRessources[1], djangoRessources[2], R.drawable.django_image);
        LessonModel nodeLesson = new LessonModel(nodeRessources[0], nodeRessources[1], nodeRessources[2], R.drawable.node_image);
        LessonModel flutterLesson = new LessonModel(flutterRessources[0], flutterRessources[1], flutterRessources[2], R.drawable.flutter_image);

        mListLessons.add(androidLesson);
        mListLessons.add(webLesson);
        mListLessons.add(djangoLesson);
        mListLessons.add(nodeLesson);
        mListLessons.add(flutterLesson);
    }

    private void initRecyclerView(){
        initLessonList();
        mLessonsRecyclerView.setAdapter(new lessonsAdapter(mListLessons, this));
        mLessonsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void goToOneLessonFrag(LessonModel lessonModel) {
        OneLessonFragment oneLessonFrag= OneLessonFragment.newInstance(lessonModel.getTitle(), lessonModel.getSubTitle(), lessonModel.getDescriptionLesson());
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, oneLessonFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }
}