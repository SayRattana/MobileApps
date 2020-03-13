package com.example.easylearning.ui.aboutme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.easylearning.IMyActivity.IMyActivity;
import com.example.easylearning.R;


public class AboutmeFragment extends Fragment {


    private AboutmeViewModel aboutmeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutmeViewModel =
                ViewModelProviders.of(this).get(AboutmeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_aboutme, container, false);
        final TextView textView = root.findViewById(R.id.text_aboutme);

        aboutmeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}