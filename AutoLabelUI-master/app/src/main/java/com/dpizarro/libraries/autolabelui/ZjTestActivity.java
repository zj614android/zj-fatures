package com.dpizarro.libraries.autolabelui;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.dpizarro.autolabel.library.AutoLabelUI;
import com.dpizarro.autolabel.library.Label;

import java.util.ArrayList;
import java.util.List;

public class ZjTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zj_test);

        AutoLabelUI autoLabelUI = (AutoLabelUI) findViewById(R.id.label_view);
        autoLabelUI.setBackgroundResource(R.drawable.round_corner_background);//设置圆角风格

        showLabel(autoLabelUI);

        autoLabelUI.setOnLabelClickListener(new AutoLabelUI.OnLabelClickListener() {
            @Override
            public void onClickLabel(Label labelClicked) {
                Toast.makeText(ZjTestActivity.this, labelClicked.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        autoLabelUI.setOnRemoveLabelListener(new AutoLabelUI.OnRemoveLabelListener() {
            @Override
            public void onRemoveLabel(Label removedLabel, int position) {
                Toast.makeText(ZjTestActivity.this, removedLabel.getText() + "被删除了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showLabel(AutoLabelUI autoLabelUI) {
        List<Person> testDatas = getData();

        for (int i = 0; i < testDatas.size(); i++) {
            autoLabelUI.addLabel(testDatas.get(i).getName());
        }
    }

    public List<Person> getData() {
        List<Person> testDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testDatas.add(new Person("MR__" + i, String.valueOf(i), i, false));
        }
        return testDatas;
    }
}
