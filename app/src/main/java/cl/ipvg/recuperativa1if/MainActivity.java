package cl.ipvg.recuperativa1if;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btCalcular;
    EditText etNombre, etCarrera, etNota1, etNota2, etNota3;
    double n1, n2, n3, Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = (Button) findViewById(R.id.btCalcular);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etCarrera = (EditText) findViewById(R.id.etCarrera);
        etNota1 = (EditText) findViewById(R.id.etNota1);
        etNota2 = (EditText) findViewById(R.id.etNota2);
        etNota3 = (EditText) findViewById(R.id.etNota3);
        n1 = Double.parseDouble(etNota1.getText().toString());
        n2 = Double.parseDouble(etNota2.getText().toString());
        n3 = Double.parseDouble(etNota3.getText().toString());
        Resultado = (n1 + n2 + n3)/3;

        Intent intent = new Intent(this, MainActivity2.class);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("carrera", etCarrera.getText().toString());
                intent.putExtra("promedio", Resultado);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}