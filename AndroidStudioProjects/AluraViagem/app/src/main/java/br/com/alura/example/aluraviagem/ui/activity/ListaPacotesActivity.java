package br.com.alura.example.aluraviagem.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.adapter.ListaPacotesAdapter;
import br.com.alura.example.aluraviagem.dao.PacoteDao;
import br.com.alura.example.aluraviagem.models.Pacote;

import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.TITLE_APPBAR;

public class ListaPacotesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITLE_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        final List<Pacote> pacotes = new PacoteDao().lista();
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, ListaPacotesActivity.this));
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vaiParaResumoPacote(position, pacotes);
            }
        });
    }

    private void vaiParaResumoPacote(int position, List<Pacote> pacotes) {
        Intent intent = new Intent(ListaPacotesActivity.this,
                                                ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacotes.get(position));
        startActivity(intent);
    }
}
