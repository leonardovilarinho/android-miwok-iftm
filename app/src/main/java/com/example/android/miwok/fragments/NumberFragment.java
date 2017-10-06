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
 * Fragmento para a listagem de números
 */
public class NumberFragment extends SuperFragment {

    /**
     * Construtor vazio requerido por fragmento
     */
    public NumberFragment() {}

    /**
     * Monta a lista de traduções da página
     * @return - lista de traduções
     */
    @Override
    protected ArrayList<Word> makeListWords() {
        return new ArrayList<Word>(Arrays.asList(
                Word.make("um"         , "lutti"        , R.drawable.number_one     , R.raw.number_one      ),
                Word.make("dois"       , "otiiko"       , R.drawable.number_two     , R.raw.number_two      ),
                Word.make("três"       , "tolookosu"    , R.drawable.number_three   , R.raw.number_three    ),
                Word.make("quatro"     , "oyyisa"       , R.drawable.number_four    , R.raw.number_four     ),
                Word.make("cinco"      , "massokka"     , R.drawable.number_five    , R.raw.number_five     ),
                Word.make("seis"       , "temmokka"     , R.drawable.number_six     , R.raw.number_six      ),
                Word.make("sete"       , "kenekaku"     , R.drawable.number_seven   , R.raw.number_seven    ),
                Word.make("oito"       , "kawinta"      , R.drawable.number_eight   , R.raw.number_eight    ),
                Word.make("nove"       , "wo'e"         , R.drawable.number_nine    , R.raw.number_nine     ),
                Word.make("dez"        , "na'aacha"     , R.drawable.number_ten     , R.raw.number_ten      )
        ));
    }

    /**
     * Cor de fundo da tela
     * @return - referência de fundo
     */
    @Override
    protected int backgroundColor() {
        return R.color.category_number;
    }

    /**
     * Pega o título da página
     * @return - título
     */
    @Override
    public String getTitle() {
        return "Número";
    }
}
