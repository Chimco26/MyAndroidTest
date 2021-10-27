package com.example.myandroidtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private String subTitle;
    private String description;
    private int image;

    private TextView mSubtitleTextView;
    private TextView mDescriptionTextView;
    private ImageView mImageView;
    private ImageButton mArrowBack;

    public OneLessonFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OneLessonFragment newInstance(int image, String subTitle, String description) {
        OneLessonFragment fragment = new OneLessonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, image);
        args.putString(ARG_PARAM2, subTitle);
        args.putString(ARG_PARAM3, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            image = getArguments().getInt(ARG_PARAM1);
            subTitle = getArguments().getString(ARG_PARAM2);
            description = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one_lesson, container, false);
        mSubtitleTextView = v.findViewById(R.id.sub_title_lesson);
        mDescriptionTextView = v.findViewById(R.id.description_lesson);
        mImageView = v.findViewById(R.id.image_one_leson);
        mArrowBack = v.findViewById(R.id.arrow_back);
        mArrowBack.setOnClickListener(v1 -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
        mSubtitleTextView.setText(subTitle);
        mDescriptionTextView.setText(description);
        mImageView.setImageResource(image);
        return v;
    }
}