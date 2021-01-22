package com.iflytek.sanyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iflytek.ainote.plugin.explicit.R;


/**
 * 不能设置任何 style
 */

public class MainActivity extends Activity {

    String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // 混合笔记packageName
    public static final String COMPLEX_NOTE_PACKAGE_NAME = "com.iflytek.ainote.note";
    //录音笔记
    public static final String AIRECORD_PACKAGE = "com.iflytek.record.ainoterecord";
    public static final String SYNC_NOTE_ID = "note_id";
    public static final String TYPE = "type";

    public void openRecord(View v) {
        Intent intent = new Intent();
        intent.setClassName(AIRECORD_PACKAGE, "com.iflytek.record.ainoterecord.ui.activity.RecordingActivity");
        // 创建新记录 注释此行
//        intent.putExtra(SYNC_NOTE_ID, 125L); // 打开已有记录
        startActivityForResult(intent, 200);

    }

    public void openNote(View v) {
        Intent intent = new Intent();
        intent.setClassName(COMPLEX_NOTE_PACKAGE_NAME, "com.iflytek.ainote.ui.activity.MainActivity");
        // 创建新写作 注释此行
//        intent.putExtra(SYNC_NOTE_ID, 125L); // 打开已有写作
        startActivityForResult(intent, 200);
    }

    public void back(View v) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "requestCode = " + requestCode + "\t resultCode = " + resultCode + "\t" + data);

        if (requestCode == 200 && resultCode == 201) {
            // note_id
            long note_id = data.getLongExtra(SYNC_NOTE_ID, -1);
            int type = data.getIntExtra(TYPE, -1);
            // type = 1 写作， type = 2 记录
            Log.e(TAG, "note_id = " + note_id + "\t type = " + type);
        }
    }
}