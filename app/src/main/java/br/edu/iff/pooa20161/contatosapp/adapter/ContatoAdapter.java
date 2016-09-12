package br.edu.iff.pooa20161.contatosapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20161.contatosapp.R;
import br.edu.iff.pooa20161.contatosapp.models.Contato;

/**
 * Created by lglmoura on 09/09/16.
 */

public class ContatoAdapter extends ArrayAdapter<Contato> {

    private Context context = null;
    private ArrayList<Contato> contatos = null;


    public ContatoAdapter(Context context, ArrayList<Contato> contatos) {
        super(context, R.layout.linhalistacontato,contatos);
        this.context = context;
        this.contatos = contatos;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhalistacontato, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvllvNome);
        TextView email = (TextView) rowView.findViewById(R.id.tvllvEmail);
        TextView telefone = (TextView) rowView.findViewById(R.id.tvllvTelefone);

        nome.setText(contatos.get(position).getNome());
        email.setText(contatos.get(position).getEmail());
        telefone.setText(contatos.get(position).getTelefone());
        return rowView;
    }
}