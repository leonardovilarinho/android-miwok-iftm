package com.example.android.miwok.fragments;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.Word;
import com.example.android.miwok.WordAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.android.miwok.R.id.words;

/**
 * Fragmento para a listagem de cores
 */
public class ColorFragment extends SuperFragment {

    /**
     * Construtor vazio requerido por fragmento
     */
    public ColorFragment() {}

    /**
     * Monta a lista de traduções da página
     * @return - lista de traduções
     */
    @Override
    protected ArrayList<Word> makeListWords() {
        return new ArrayList<Word>(Arrays.asList(
                Word.make("vermelho"            , "weṭeṭṭi"     , R.drawable.color_red           , R.raw.color_red            ),
                Word.make("verde"               , "chokokki"   , R.drawable.color_green         , R.raw.color_green          ),
                Word.make("marrom"              , "ṭakaakki"   , R.drawable.color_brown         , R.raw.color_brown          ),
                Word.make("cinza"               , "ṭopoppi"    , R.drawable.color_gray          , R.raw.color_gray           ),
                Word.make("preto"               , "kululli"    , R.drawable.color_black         , R.raw.color_black          ),
                Word.make("branco"              , "kelelli"    , R.drawable.color_white         , R.raw.color_white          ),
                Word.make("amarelo empoeirado"  , "ṭopiisә"    , R.drawable.color_dusty_yellow  , R.raw.color_dusty_yellow   ),
                Word.make("amarelo mostarda"    , "chiwiiṭә"   , R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow )
        ));
    }

    /**
     * Cor de fundo da tela
     * @return - referência de fundo
     */
    @Override
    protected int backgroundColor() {
        return R.color.category_color;
    }

    /**
     * Pega o título da página
     * @return - título
     */
    @Override
    public String getTitle() {
        return "Cores";
    }
}
