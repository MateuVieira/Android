package br.com.alura.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITLE_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();

        if( getIntent().hasExtra("aluno")) {
            Intent dados = getIntent();

            aluno = (Aluno) dados.getSerializableExtra("aluno");

            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        } else {
            aluno = new Aluno();
        }
    }

    private void configuraBotaoSalvar() {
        Button buttonSalvar = findViewById(R.id.activit_formulario_button_salvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preencheAluno();
                if(aluno.temIdValido()) {
                    dao.edita(aluno);
                }else{
                    dao.salva(aluno);
                }
                finish();
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activit_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activit_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activit_formulario_aluno_email);
    }

    private void preencheAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setEmail(campoEmail.getText().toString());
    }
}
