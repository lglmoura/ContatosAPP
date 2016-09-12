package br.edu.iff.pooa20161.contatosapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20161.contatosapp.R;
import br.edu.iff.pooa20161.contatosapp.adapter.ContatoAdapter;
import br.edu.iff.pooa20161.contatosapp.models.Contato;

public class ListaContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaContatoActivity.this,ContatoActivity.class);
                intent.putExtra("id",0);
                intent.putExtra("nome","");
                intent.putExtra("email","");
                intent.putExtra("telefone","");

                startActivity(intent);
            }
        });
    }

    protected void onResume() {
        super.onResume();

        final ArrayList<Contato> contatos  = (ArrayList) Contato.listAll(Contato.class);

        ListView lista = (ListView) findViewById(R.id.lvContatos);
        ArrayAdapter adapter = new ContatoAdapter(this,contatos);
        lista.setAdapter(adapter);




    }

}
