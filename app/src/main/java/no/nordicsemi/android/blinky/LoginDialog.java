package no.nordicsemi.android.blinky;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.MacAddress;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import static android.content.Context.WIFI_SERVICE;

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

                //textView.setText("" + wifiInfo.getMacAddress());

            }
        });
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        return builder.create();
    }
    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }
}
