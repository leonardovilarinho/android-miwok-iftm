package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.Word;

import java.util.ArrayList;

/**
 * Adaptador para a lista de itens, customizando cada item
 * para exibir a imagem, tradução e áudio
 */
public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * Armazena a referência para a cor de fundo do item atual
     */
    private int backgroundColor;

    /**
     * Cria um adaptador de uma tradução, cujo gerencia os itens de uma listview customizada
     * com palavra, tradução, imagem, áudio e cor
     * @param context - tela atual para adicionar a lista
     * @param _words - lista de traduções a serem exibidas
     * @param color - cor de fundo da lista
     */
    public WordAdapter(Activity context, ArrayList<Word> _words, int color) {
        super(context, 0, _words);
        backgroundColor = color;
    }


    /**
     * Pega um item da lista e o devolve personalizado, com o layout definido
     * em item_list
     * @param position - posição do item no array de traduções
     * @param convertView - objeto View para ser customizado
     * @param parent - parentes do item atual
     * @return - item da lista já customizado
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        item = item != null ? item : LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);

        return mountCustomView(item, getItem(position));
    }

    /**
     * Define a cor do fundo, texto em português, texto em miwok e foto do item
     * passado como parâmetro, retornando-o customizado
     * @param item - objeto a ser customizado
     * @param word - dados da customização
     * @return - objeto já customizado
     */
    private View mountCustomView(View item, Word word) {
        LinearLayout layout = (LinearLayout) item.findViewById(R.id.word_container);
        layout.setBackgroundResource(backgroundColor);

        TextView defaultTextView = (TextView) item.findViewById(R.id._default);
        defaultTextView.setText(word.getDefault());

        TextView miwokTextView = (TextView) item.findViewById(R.id._miwok);
        miwokTextView.setText(word.getMiwok());

        ImageView imageContainer = (ImageView) item.findViewById(R.id.image_container);
        imageContainer.setVisibility(View.GONE);

        if(word.hasImage()) {
            imageContainer.setImageResource(word.getImage());
            imageContainer.setVisibility(View.VISIBLE);
        }
        return item;
    }
}
