package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView campoNum1;
    TextView campoNum2;
    EditText campoResultado;
    TextView campoOperacion;
    int randNum1, randNum2, numOperacion;
    int correctas = 0;
    String operacion;
    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNum1 = findViewById(R.id.num1);
        campoNum2 = findViewById(R.id.num2);

        campoResultado = findViewById(R.id.resultado);

        campoOperacion = findViewById(R.id.operacion);

        actualizarNums();
    }

    public void actualizarNums()
    {
        numOperacion = new Random().nextInt(3);

        switch (numOperacion)
        {
            case 0:
                operacion = "sumar";
                campoOperacion.setText("+");
                break;
            case 1:
                operacion = "restar";
                campoOperacion.setText("-");
                break;
            case 2:
                operacion = "multiplicar";
                campoOperacion.setText("x");
                break;
        }

        randNum1 = new Random().nextInt(99);
        campoNum1.setText("" + randNum1);

        randNum2 = new Random().nextInt(99);
        campoNum2.setText("" + randNum2);

        campoResultado.setText("");
    }

    public void comprobar(View v)
    {

        int num1 = Integer.parseInt(campoNum1.getText().toString());

        int num2 = Integer.parseInt(campoNum2.getText().toString());

        int resultado = Integer.parseInt(campoResultado.getText().toString());

        int solucion = 0;

        switch (operacion)
        {
            case "sumar":
                solucion = num1 + num2;
                break;
            case "restar":
                solucion = num1 - num2;
                break;
            case "multiplicar":
                solucion = num1 * num2;
                break;
        }


        if(resultado == solucion)
        {
            correctas++;
        }

        if(correctas >= 10)
        {
            notificar();
        }
        actualizarNums();
    }

    public void notificar()
    {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(CANAL_ID, "Mis notificaciones",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Descripción del canal");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                                        .setSmallIcon(R.drawable.ic_action_name)
                                                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_dialog_info))
                                                        .setContentTitle("¡¡FELICIDADES!!")
                                                        .setContentText("Has acertado 10 resultados");
        notificationManager.notify(NOTIFICACION_ID, notificacion.build());
    }
}