package com.example.listagemlivros.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listagemlivros.adapter.BibliotecaAdapter;
import com.example.listagemlivros.model.Livro;
import com.example.listagemlivros.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Livro> bibliotecaItems = new ArrayList<>();
    private ListView listView;
    private BibliotecaAdapter adapter;
    private static final int REQUEST_CADASTRO_LIVRO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adicionar livros de exemplo (apenas para teste)
        bibliotecaItems.add(new Livro("Livro 1", "Autor 1", "Ficção"));
        bibliotecaItems.add(new Livro("Livro 2", "Autor 2", "Não Ficção"));
        bibliotecaItems.add(new Livro("Livro 3", "Autor 3", "Suspense"));

        // Configurar a ListView e o Adapter
        listView = findViewById(R.id.listView);
        adapter = new BibliotecaAdapter(this, bibliotecaItems);
        listView.setAdapter(adapter);

        Button btnCadastrarLivro = findViewById(R.id.btnCadastrarLivro);
        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir para a tela de cadastro de livros (CadastroLivroActivity) com startActivityForResult
                Intent intent = new Intent(MainActivity.this, CadastroLivroActivity.class);
                startActivityForResult(intent, REQUEST_CADASTRO_LIVRO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CADASTRO_LIVRO && resultCode == RESULT_OK) {
            // Atualizar a lista de livros (se necessário)
            adapter.notifyDataSetChanged();
        }
    }
}

