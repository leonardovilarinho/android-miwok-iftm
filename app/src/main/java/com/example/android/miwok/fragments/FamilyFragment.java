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
 * Fragmento para a listagem de membros da família
 */
public class FamilyFragment extends SuperFragment {

    /**
     * Construtor vazio requerido por fragmento
     */
    public FamilyFragment() {}

    /**
     * Monta a lista de traduções da página
     * @return - lista de traduções
     */
    @Override
    protected ArrayList<Word> makeListWords() {
        return new ArrayList<Word>(Arrays.asList(
                Word.make("pai"                , "әpә"          , R.drawable.family_father          , R.raw.family_father           ),
                Word.make("mãe"                , "әṭa"          , R.drawable.family_mother          , R.raw.family_mother           ),
                Word.make("filho"              , "angsi"        , R.drawable.family_son             , R.raw.family_son              ),
                Word.make("filha"              , "tune"         , R.drawable.family_daughter        , R.raw.family_daughter         ),
                Word.make("irmão mais velho"   , "taachi"       , R.drawable.family_older_brother   , R.raw.family_older_brother    ),
                Word.make("irmão mais novo"    , "chalitti"     , R.drawable.family_younger_brother , R.raw.family_younger_brother  ),
                Word.make("irmã mais velha"    , "teṭe"         , R.drawable.family_older_sister    , R.raw.family_older_sister     ),
                Word.make("irmã mais nova"     , "kolliti"      , R.drawable.family_younger_sister  , R.raw.family_younger_sister   ),
                Word.make("avó"                , "ama"          , R.drawable.family_grandmother     , R.raw.family_grandmother      ),
                Word.make("avô"                , "paapa"        , R.drawable.family_grandfather     , R.raw.family_grandfather      )
        ));
    }

    /**
     * Cor de fundo da tela
     * @return - referência de fundo
     */
    @Override
    protected int backgroundColor() {
        return R.color.category_family;
    }

    /**
     * Pega o título da página
     * @return - título
     */
    @Override
    public String getTitle() {
        return "Família";
    }
}
