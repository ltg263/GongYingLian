package com.jxxx.gyl.utils.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jxxx.gyl.R;


/**
 * @author AlienChao
 * @date 2020/05/15 10:42
 */
public class AddandView extends FrameLayout implements View.OnClickListener {
    private ImageView mImage1;
    private ImageView mImage2;
    private TextView mText;
    int value;

    public AddandView(@NonNull Context context) {
        this(context, null);
    }

    public AddandView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddandView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        findView(context);
    }

    private void findView(Context context) {
        View view = View.inflate(context, R.layout.add_view, this);

        mImage1 = view.findViewById(R.id.image1);
        mImage2 = view.findViewById(R.id.image2);
        mText = view.findViewById(R.id.text);

        value = getValue();

        setShowValue(value);

        mImage1.setOnClickListener(this);
        mImage2.setOnClickListener(this);
    }

    private int vs = 0;
    /**
     * true 显示Add效果  保留点击监听 ？
     * false 不显示Add效果  保留点击监听
     */
    private boolean isShowAdd = true;

    public int getValue() { //获取值

        String trim = mText.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            Integer.valueOf(vs);
        }
        return vs;
    }

    public void setNotAdd(boolean notAdd) {
        isShowAdd = notAdd;
    }

    public void setValue(int value) {
        vs = value;

        // 只有添加数量大于1 或者  isShowAdd =true 默认
        if (isShowAdd | value > 1) {
            mText.setText(value + "");
        }

    }

    /**
     * 不管怎样都显示
     */
    public void setShowValue(int value) {
        vs = value;
        mText.setText(value + "");


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.image1:
//                jian();

                if (mOnNumberChangedListener != null) {
                    mOnNumberChangedListener.OnNumberChanged(vs, false);
                }
                break;
            case R.id.image2:
//                add();

                if (mOnNumberChangedListener != null) {
                    mOnNumberChangedListener.OnNumberChanged(vs, true);
                }
                break;
        }
    }

    public void jian() {
        if (vs > 0) {
            vs--;
            setShowValue(vs);
//            if (mOnNumberChangedListener != null) {
//                mOnNumberChangedListener.OnNumberChanged(vs, false);
//            }
        }

    }

    public void add() {

        vs++;
        setValue(vs);

//        if (mOnNumberChangedListener != null) {
//            mOnNumberChangedListener.OnNumberChanged(vs, true);
//        }
    }

    public interface OnNumberChangedListener {
        /**
         * vs 数字  isAdd 是否是添加
         */
        void OnNumberChanged(int vs, boolean isAdd);
    }

    private OnNumberChangedListener mOnNumberChangedListener;

    public void setOnNumberChangedListener(OnNumberChangedListener onNumberChangedListener) {
        mOnNumberChangedListener = onNumberChangedListener;
    }
}
