package com.example.myandroidtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneLessonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneLessonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String title;
    private String subTitle;
    private String description;

    private TextView mTitleTextView;
    private TextView mSubtitleTextView;
    private ImageView mImageView;

    public OneLessonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @param subTitle Parameter 2.
     * @return A new instance of fragment OneLessonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneLessonFragment newInstance(String title, String subTitle, String description) {
        OneLessonFragment fragment = new OneLessonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, subTitle);
        args.putString(ARG_PARAM3, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            subTitle = getArguments().getString(ARG_PARAM2);
            description = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one_lesson, container, false);
        mTitleTextView = v.findViewById(R.id.title_lesson);
        mSubtitleTextView = v.findViewById(R.id.subtitle_lesson);
        mTitleTextView.setText(title);
        mSubtitleTextView.setText(subTitle);
        return v;
    }
}