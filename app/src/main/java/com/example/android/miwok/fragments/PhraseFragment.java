package com.example.android.miwok.fragments;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * Fragmento para a listagem de frases
 */
public class PhraseFragment extends SuperFragment {

    /**
     * Construtor vazio requerido por fragmento
     */
    public PhraseFragment() {}

    /**
     * Monta a lista de traduções da página
     * @return - lista de traduções
     */
    @Override
    protected ArrayList<Word> makeListWords() {
        return new ArrayList<Word>(Arrays.asList(
                Word.make("onde você está indo?"    , "minto wuksus"        , R.raw.phrase_where_are_you_going      ),
                Word.make("qual o seu nome?"        , "tinnә oyaase'nә"     , R.raw.phrase_what_is_your_name        ),
                Word.make("meu nome é..."           , "oyaaset..."          , R.raw.phrase_my_name_is               ),
                Word.make("como está se sentindo?"  , "michәksәs?"          , R.raw.phrase_how_are_you_feeling      ),
                Word.make("estou me sentindo bem"   , "kuchi achit"         , R.raw.phrase_im_feeling_good          ),
                Word.make("você está vindo?"        , "әәnәs'aa?"           , R.raw.phrase_are_you_coming           ),
                Word.make("sim, estou indo"         , "hәә’ әәnәm"          , R.raw.phrase_yes_im_coming            ),
                Word.make("estou indo"              , "әәnәm"               , R.raw.phrase_im_coming                ),
                Word.make("vamos"                   , "yoowutis"            , R.raw.phrase_lets_go                  ),
                Word.make("venha aqui"              , "әnni'nem"            , R.raw.phrase_come_here                )
        ));
    }

    /**
     * Cor de fundo da tela
     * @return - referência de fundo
     */
    @Override
    protected int backgroundColor() {
        return R.color.category_phrase;
    }

    /**
     * Pega o título da página
     * @return - título
     */
    @Override
    public String getTitle() {
        return "Frases";
    }
}
