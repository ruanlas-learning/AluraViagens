package com.example.ruan.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruan.aluraviagens.util.DiasUtil;
import com.example.ruan.aluraviagens.util.MoedaUtil;
import com.example.ruan.aluraviagens.R;
import com.example.ruan.aluraviagens.util.ResourceUtil;
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

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileiraFormatada = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileiraFormatada);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
