package br.com.alura.example.aluraviagem.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.adapter.ListaPacotesAdapter;
import br.com.alura.example.aluraviagem.dao.PacoteDao;
import br.com.alura.example.aluraviagem.models.Pacote;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITLE_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        List<Pacote> pacotes = new PacoteDao().lista();
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, ListaPacotesActivity.this));
    }
}
