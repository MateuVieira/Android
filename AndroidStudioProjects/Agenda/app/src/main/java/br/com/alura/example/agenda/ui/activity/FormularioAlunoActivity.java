package br.com.alura.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;

import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;
import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.TITLE_APPBAR_EDITA;
import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.TITLE_APPBAR_NOVO_ALUNO;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        inicializacaoDosCampos();
        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if( itemId == R.id.activity_formulario_aluno_menu_salvar){
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        if( getIntent().hasExtra(CHAVE_ALUNO)) {
            Intent dados = getIntent();
            aluno = (Aluno) dados.getSerializableExtra("aluno");
            preencheCampos();
            setTitle(TITLE_APPBAR_EDITA);
        } else {
            aluno = new Aluno();
            setTitle(TITLE_APPBAR_NOVO_ALUNO);
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }


    private void finalizaFormulario() {
        preencheAluno();
        if(aluno.temIdValido()) {
            dao.edita(aluno);
        }else{
            dao.salva(aluno);
        }
        finish();
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
