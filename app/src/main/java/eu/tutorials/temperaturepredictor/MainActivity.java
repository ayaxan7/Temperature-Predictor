package eu.tutorials.temperaturepredictor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText chirps;
    Button SubmitBtn;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        chirps=findViewById(R.id.chirps);
        SubmitBtn=findViewById(R.id.SubmitBtn);
        output=findViewById(R.id.output);
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            output.setVisibility(View.VISIBLE);
            String chirp=chirps.getText().toString();
            int n=Integer.parseInt(chirp);
            double temp=(n/3.0)+4.0;
            String formattedTemp = String.format("%.2f", temp) + "°C";
            output.setText(formattedTemp);
        }
    });
    }
}