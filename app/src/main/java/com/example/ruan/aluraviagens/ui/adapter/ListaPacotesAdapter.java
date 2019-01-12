package com.example.ruan.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruan.aluraviagens.R;
import com.example.ruan.aluraviagens.model.Pacote;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacoteList;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacoteList, Context context) {
        this.pacoteList = pacoteList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacoteList.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacoteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewCriada = layoutInflater.inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacoteList.get(position);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        dias.setText(pacote.getDias() + " dias");

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        preco.setText("R$ " + pacote.getPreco().toString());

        return viewCriada;
    }
}
