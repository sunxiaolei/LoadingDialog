package xiaolei.loadingview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.wang.avi.indicators.BallBeatIndicator;
import com.wang.avi.indicators.BallClipRotateIndicator;
import com.wang.avi.indicators.LineSpinFadeLoaderIndicator;

import xiaolei.library.LoadingDialog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LoadingDialog dialog = new LoadingDialog.Builder(this)
                .setIndicator(new LineSpinFadeLoaderIndicator())
                .setIndicatorColor(Color.parseColor("#120976"))
                .create();
        Button btn = (Button) findViewById(R.id.btn_show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 3000);
            }
        });

    }
}
