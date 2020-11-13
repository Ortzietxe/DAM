package com.example.actividaddialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Login extends DialogFragment {
    private EditText campoNombre;
    boolean comprobado;

    MainActivity main = new MainActivity();
    OnDialogoConfirmacionListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogoLogin = inflater.inflate(R.layout.login, null);
        builder.setView(dialogoLogin).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                comprobado = main.comprobar();
                if (comprobado)
                    dialog.cancel();
            }
        });
        campoNombre = dialogoLogin.findViewById(R.id.nomUsuario);
        return builder.create();
    }
    public EditText getCampoNombre(){
        return campoNombre;
    }

    public interface OnDialogoConfirmacionListener
    {
        void onPossitiveButtonClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnDialogoConfirmacionListener) context;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() +" no Implemento OnDialogoConfirmacionListener");
        }
    }
}
