package br.edu.iff.pooa20161.contatosapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20161.contatosapp.R;
import br.edu.iff.pooa20161.contatosapp.models.Contato;

public class ContatoActivity extends AppCompatActivity {

    EditText nome, email, telefone;
    Button btsalvar,btalterar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        String nomep     = (String) intent.getSerializableExtra("nome");
        String emailp    = (String) intent.getSerializableExtra("email");
        String telefonep = (String) intent.getSerializableExtra("telefone");

        EditText nome = (EditText) findViewById(R.id.etNomeContato);
        nome.setText(nomep);

        EditText email = (EditText) findViewById(R.id.etEmailContato);
        email.setText(emailp);

        EditText telefone = (EditText) findViewById(R.id.etTelefoneContato);
        telefone.setText(telefonep);

        btsalvar = (Button) findViewById(R.id.btSalvarContato);
        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }
    public void salvar() {

        nome = (EditText) findViewById(R.id.etNomeContato);
        email = (EditText) findViewById(R.id.etEmailContato);
        telefone = (EditText) findViewById(R.id.etTelefoneContato);
        Contato contato = new Contato(nome.getText().toString(),email.getText().toString(),telefone.getText().toString());

        contato.save();

        Toast.makeText(this,"Contato Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
