package zj.edittext_1_foucs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ed = (EditText) findViewById(R.id.edit);
        View rootView = findViewById(R.id.rootview);


        final SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(getRootView());
        softKeyboardStateHelper.addSoftKeyboardStateListener(new SoftKeyboardStateHelper.SoftKeyboardStateListener() {
            @Override
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {
                Log.e("zj", "键盘open");
            }

            @Override
            public void onSoftKeyboardClosed() {
                //取消输入框焦点
                Log.e("zj", "键盘close");
                ed.clearFocus();
            }
        });


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });


        ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Log.e("zj", "hasFocus");
                }else {
                    Log.e("zj", "not hasFocus");
                }
            }
        });
    }

    private View getRootView() {
        return findViewById(R.id.rootview);
    }
}
