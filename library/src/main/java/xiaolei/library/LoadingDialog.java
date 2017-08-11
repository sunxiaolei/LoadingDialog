package xiaolei.library;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;
import com.wang.avi.indicators.BallBeatIndicator;

/**
 * Created by sunxl8 on 2017/8/10.
 */

public class LoadingDialog extends Dialog {

    private AVLoadingIndicatorView mView;
    private Indicator mIndicator;
    private int mColor;

    public LoadingDialog(Context context, Indicator d, int c) {
        super(context, R.style.ProgressDialog);
        mIndicator = d;
        mColor = c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        mView = (AVLoadingIndicatorView) findViewById(R.id.view_loading);

        mView.setIndicator(mIndicator);
        mView.setIndicatorColor(mColor);

        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                mView.smoothToShow();
            }
        });

        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mView.smoothToHide();
            }
        });

        setCanceledOnTouchOutside(false);
    }

    public static class Builder {

        private Context mContext;
        private Indicator mIndicator = new BallBeatIndicator();
        private int mColor = Color.parseColor("#444444");

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setIndicator(Indicator d) {
            mIndicator = d;
            return this;
        }

        public Builder setIndicatorColor(int c) {
            mColor = c;
            return this;
        }

        public LoadingDialog create() {
            LoadingDialog dialog = new LoadingDialog(mContext, mIndicator, mColor);
            return dialog;
        }

    }
}
