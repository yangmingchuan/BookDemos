package com.example.pul.bookdemo.dialogframent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pul.bookdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * dialogFragment 基本使用
 */

public class DialogFragmentActivity extends AppCompatActivity {

    @BindView(R.id.btn_show_edit_name_dialog)
    Button btnShowEditNameDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_show_edit_name_dialog})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btn_show_edit_name_dialog:
                EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
                editNameDialog.show(getFragmentManager(), "EditNameDialog");
                break;
        }
    }

}
