package com.coderknot.gamesearch.fragments;

import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.coderknot.gamesearch.R;

public class AddGameDialogFragment extends DialogFragment {

    public AddGameDialogFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_add_game_dialog, container, false);
        final RadioGroup surveyRadioGroup = (RadioGroup) rootView.findViewById(R.id.gameListTypeRadioGroup);

        return rootView;
    }

}
