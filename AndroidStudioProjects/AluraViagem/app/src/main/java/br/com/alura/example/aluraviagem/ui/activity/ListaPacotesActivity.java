package br.com.alura.example.aluraviagem.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        listaPacotes.setAdapter(new ListaPacotesAdapter());
    }
}
