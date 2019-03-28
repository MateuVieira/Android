package br.com.alura.example.agenda.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.example.agenda.R;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de alunos");

        List<String> alunos= new ArrayList<>(Arrays.asList("Alex", "Fran", "Nico", "Mateus", "Amanda", "Ana", "Atena", "Junior"));
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listwiew);

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos));


    }
}
