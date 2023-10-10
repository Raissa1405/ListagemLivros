package com.example.listagemlivros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listagemlivros.R;
import com.example.listagemlivros.model.Livro;

import java.util.ArrayList;


public class BibliotecaAdapter extends ArrayAdapter<Livro> {

    private Context context;
    private ArrayList<Livro> livros;

    public BibliotecaAdapter(Context context, ArrayList<Livro> bibliotecaItems) {
        super(context, R.layout.activity_item_biblioteca, bibliotecaItems);
        this.context = context;
        this.livros = bibliotecaItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Livro livro = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item_biblioteca, parent, false);
        }

        TextView textTitle = convertView.findViewById(R.id.textTitle);
        TextView textAuthor = convertView.findViewById(R.id.textAuthor);
        TextView textCategory = convertView.findViewById(R.id.textCategory);

        textTitle.setText(livro.getTitle());
        textAuthor.setText("Autor: " + livro.getAuthor());
        textCategory.setText("Categoria: " + livro.getCategory());

        return convertView;
    }
}
