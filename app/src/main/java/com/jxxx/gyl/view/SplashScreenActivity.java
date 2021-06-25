package com.jxxx.gyl.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;

public class SplashScreenActivity extends Activity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(() -> startUi(), 2000);
    }

    private void startUi() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}
