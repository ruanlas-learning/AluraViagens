package com.example.ruan.aluraviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ruan.aluraviagens.R;
import com.example.ruan.aluraviagens.dao.PacoteDAO;
import com.example.ruan.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        ListView listaPacotesListView = (ListView) findViewById(R.id.lista_pacotes_listview);
        PacoteDAO pacoteDAO = new PacoteDAO();
        listaPacotesListView.setAdapter(new ListaPacotesAdapter(pacoteDAO.lista(), this));
    }
}
