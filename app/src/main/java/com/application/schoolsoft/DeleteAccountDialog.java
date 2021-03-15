package com.application.schoolsoft;

import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import dalvik.system.DelegateLastClassLoader;

public class DeleteAccountDialog extends AppCompatDialogFragment {
    private DeleteAccountDialogListner listner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure you want to delete your account?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listner.DeleteAccount();
            }
        });
        builder.setNegativeButton("Cancel",null);

        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listner = (DeleteAccountDialogListner) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement DeleteAccountDialogListener");
        }
    }

    public interface DeleteAccountDialogListner{
        void DeleteAccount();
    }
}
