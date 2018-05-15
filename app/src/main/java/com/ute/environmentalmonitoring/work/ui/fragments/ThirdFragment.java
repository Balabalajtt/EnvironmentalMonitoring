package com.ute.environmentalmonitoring.work.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ute.environmentalmonitoring.R;
import com.ute.environmentalmonitoring.work.ui.activities.LogActivity;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class ThirdFragment extends Fragment {

    private ImageView mImHead;
    private Button mBtLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        mImHead = view.findViewById(R.id.im_head);
        mImHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LogActivity.class));
            }
        });

        mBtLogout = view.findViewById(R.id.bt_logout);
        mBtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LogActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }
}
