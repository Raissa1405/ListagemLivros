package com.example.listagemlivros.views;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listagemlivros.model.Livro;
import com.example.listagemlivros.R;


public class CadastroLivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        final EditText etTitulo = findViewById(R.id.etTitulo);
        final EditText etAutor = findViewById(R.id.etAutor);
        final EditText etCategoria = findViewById(R.id.etCategoria);

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = etTitulo.getText().toString();
                String autor = etAutor.getText().toString();
                String categoria = etCategoria.getText().toString();

                Livro novoLivro = new Livro(titulo, autor, categoria);
                MainActivity.bibliotecaItems.add(novoLivro);

                // Definir o resultado como RESULT_OK e finalizar a CadastroLivroActivity
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}


