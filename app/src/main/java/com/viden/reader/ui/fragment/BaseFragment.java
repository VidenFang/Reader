package com.viden.reader.ui.fragment;

import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.viden.reader.ui.dialog.AlertDialogFragment;
import com.viden.reader.view.IBaseView;
import com.viden.reader.view.IShowDialogView;
import com.viden.reader.view.IShowToastView;

public class BaseFragment extends Fragment implements IBaseView, IShowToastView, IShowDialogView {
    @Override
    public void showShortToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog(String content) {
        DialogFragment dialogFragment = new AlertDialogFragment(content);
        dialogFragment.show(getChildFragmentManager(), AlertDialogFragment.TAG);
    }
}
