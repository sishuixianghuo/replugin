package com.iflytek.ainote.plugin.explicit.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iflytek.ainote.plugin.explicit.BuildConfig;

import com.iflytek.ainote.plugin.explicit.R;
import com.iflytek.sanyu.MainActivity;
import com.qihoo360.replugin.RePlugin;

public class MainFragment extends Fragment implements View.OnClickListener {

    private String TAG = "MainFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView" + RePlugin.getPluginContext());
//        openSanyu();
        return LayoutInflater.from(getContext()).inflate(R.layout.activity_main, null, false);

    }

    @Override
    public Context getContext() {
        if (BuildConfig.isPlugin) {
            return RePlugin.getPluginContext();
        }
        return super.getContext();
    }

    public void openSanyu() {
//        Intent intent = getContext().getPackageManager().getLaunchIntentForPackage("cn.edu.bnu.lcell.reading.eink");
//        if (intent != null) {
//            intent.putExtra("type", "110");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//        }

        Log.e(TAG, "打开新的工程");
//        Intent intent = new Intent();
//        intent.setClassName("com.iflytek.ainote.settings", "com.iflytek.ainote.settings.ui.activity.AdminActivity");
//        getContext().startActivity(intent);

        Intent intent = new Intent(getContext(), MainActivity.class);
        getContext().startActivity(intent);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.test).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(getContext(), "测试", Toast.LENGTH_SHORT).show();
        openSanyu();
    }
}