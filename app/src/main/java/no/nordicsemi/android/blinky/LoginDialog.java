package no.nordicsemi.android.blinky;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class LoginDialog extends AppCompatDialogFragment {
    private EditText username;
    private EditText password;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_login,null);

        builder.setView(view).setTitle("Login to get Token").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("SOMESHIT");
                String usn = username.getText().toString();
                String pass = password.getText().toString();
                System.out.println(usn+pass);

            }
        });
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        return builder.create();
    }
}
