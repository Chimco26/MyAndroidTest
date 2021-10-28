package com.example.myandroidtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    public static final String MY_PREFS_NAME = "MyPrefsName";
    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private Button mSendButton;
    private ProgressBar mProgressBar;
    private CheckBox mDisplayCheckBox;
    SharedPreferences prefs;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        mNameEditText = v.findViewById(R.id.editTextTextPersonName);
        mPasswordEditText = v.findViewById(R.id.editTextTextPassword);
        mProgressBar = v.findViewById(R.id.login_progressBar);
        mDisplayCheckBox = v.findViewById(R.id.checkBox_display_password);
        mDisplayCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                mPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            else
                mPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        });
        mSendButton = v.findViewById(R.id.send_button);
        mSendButton.setOnClickListener(v1 -> {
            prefs.edit().putString("name", mNameEditText.getText().toString()).apply();
            prefs.edit().putString("password", mPasswordEditText.getText().toString()).apply();
            setTimeOut();
        });
            mNameEditText.setText(prefs.getString("name", ""));
            mPasswordEditText.setText(prefs.getString("password", ""));
        if(!mNameEditText.getText().toString().isEmpty() && !mPasswordEditText.getText().toString().isEmpty()){
            mSendButton.setEnabled(true);
        }

        mNameEditText.addTextChangedListener(textWatcherListener);
        mPasswordEditText.addTextChangedListener(textWatcherListener);

        return v;
    }

    private void setTimeOut() {
        mProgressBar.setVisibility(View.VISIBLE);
        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                () -> {
                    mProgressBar.setVisibility(View.GONE);
                    ListLessonFragmentListener lessonFrag = ListLessonFragmentListener.newInstance(mNameEditText.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, lessonFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                },
                1000);
    }

    TextWatcher textWatcherListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!mNameEditText.getText().toString().isEmpty() && !mPasswordEditText.getText().toString().isEmpty()) {

                for (char oneChar : mNameEditText.getText().toString().toCharArray()) {
                    if (oneChar != ' ')
                        continue;
                    else
                        return;
                }
                for (char oneChar : mPasswordEditText.getText().toString().toCharArray()) {
                    if (oneChar != ' ')
                        continue;
                    else
                        return;
                }
                mSendButton.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}