package com.example.stepappv1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int stepCounter = 0;

    private TextView showCount;

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
        showCount = (TextView) findViewById(R.id.show_count);
    }

    public void startCount(View view) {
        Toast toast = Toast.makeText(this, R.string.counterStarted, Toast.LENGTH_LONG);
        toast.show();
        stepCounter = 0;
        showCount.setText(String.format("%d", stepCounter));
    }

    public void countUp(View view) {

        stepCounter++;
        showCount.setText(String.format("%d", stepCounter));

    }
}