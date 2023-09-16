package com.viden.reader.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {
    public static final String TAG = "AlertDialogFragment";

    private final String alertContent;

    public AlertDialogFragment(String alertContent) {
        this.alertContent = alertContent;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(alertContent)
                .setPositiveButton("确认", (dialogInterface, i) -> {

                }).create();
    }
}
