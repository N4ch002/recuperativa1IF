package cl.ipvg.recuperativa1if;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button btVolver;
    TextView tvNombre2, tvCarrera2, tvResultado;
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btVolver = (Button) findViewById(R.id.btVolver);
        tvNombre2 = (TextView) findViewById(R.id.tvNombre2);
        tvCarrera2 = (TextView) findViewById(R.id.tvCarrera2);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        Context context = getApplicationContext();

        tvNombre2.setText(getIntent().getStringExtra("nombre"));
        tvCarrera2.setText(getIntent().getStringExtra("carrera"));

        tvResultado.setText(getIntent().getStringExtra("promedio"));

        Intent intent2 = new Intent(this, MainActivity2.class);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

    }
}