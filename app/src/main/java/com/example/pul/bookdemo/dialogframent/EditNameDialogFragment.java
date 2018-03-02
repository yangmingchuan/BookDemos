package com.example.pul.bookdemo.dialogframent;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.pul.bookdemo.R;

/**
 * @packageName: com.example.pul.bookdemo.dialogframent
 * @fileName: EditNameDialogFragment
 * @date: 2018/3/1  18:33
 * @author: ymc
 * @QQ:745612618
 * 自定义 dialogfragment
 */

public class EditNameDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_content_fragment, container);
        return view;
    }
}
