package br.com.alura.example.agenda.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Cadastro Aluno");

        final AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activit_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activit_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activit_formulario_aluno_email);

        Button buttonSalvar = findViewById(R.id.activit_formulario_button_salvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno aluno = new Aluno(nome, telefone, email);

                dao.salva(aluno);

                finish();
            }
        });
    }
}
