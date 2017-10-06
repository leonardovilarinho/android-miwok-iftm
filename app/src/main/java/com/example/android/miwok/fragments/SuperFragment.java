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

import static com.example.android.miwok.R.id.words;

/**
 * Super classe que une os métodos de um fragmento além de requerir a criação
 * de uma cor e uma lista de traduções com os métodos abstratos
 */
public abstract class SuperFragment extends Fragment {

    /**
     * Player de música do aplicativo, pode controlar o som a ser eecutado
     */
    protected MediaPlayer mMediaPlayer;

    /**
     * Gerenciador de áudio do aplicativo, para dar foco ou não a um som
     */
    protected AudioManager mAudioManager;

    /**
     * Inicia a visão da lista, criando o gerenciador de áudio com origem no
     * telefone, por fim, cria o adaptador de traduções e adiciona-o na lista de itens
     * @param inflater - layout da página atual
     * @param container - contexto da tela atual
     * @param savedInstanceState - instância salva
     * @return - contexto da página atualizada com itens da lista
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        WordAdapter adapter = new WordAdapter(getActivity(), makeListWords(), backgroundColor());

        ListView listView = (ListView) rootView.findViewById(words);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener( listItemOnClick );

        return rootView;
    }

    /**
     * Evento disparado quando um item da lista é clicado, o áudio é pausado,
     * a tradução do item é pega e então o seu áudio iniciado, caso o foco
     * esteja no aplicativo
     */
    private AdapterView.OnItemClickListener listItemOnClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            releaseMediaPlayer();
            Word word = makeListWords().get(position);
            int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudio());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        }
    };

    /**
     * Evento que controla o áudio do aplicativo, caso o aúdio seja interrompido ele será pausado,
     * caso o foco do telefone se volte ao aplicativo o áudio será retomado e caso o foco sair do
     * aplicativo, o áudio será liberado da mémoria
     */
    protected AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            boolean interromp = focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
            interromp = interromp || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

            if (interromp) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
                mMediaPlayer.start();
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
                releaseMediaPlayer();
        }
    };


    /**
     * Evento chamado quando qualquer áudio do Media Player for completado
     */
    protected MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    /**
     * Quando a execução do aplicativo for interrompida o áudio deve ser liberado
     */
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    /**
     * Libera o o player de música do aplicativo da mémoria do telefone, retirando
     * o foco do aúdio do aplicativo
     */
    protected void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    /**
     * Método que força a criação da lista de objetos
     * @return - lista com objetos criados
     */
    protected abstract ArrayList<Word> makeListWords();

    /**
     * Método que força a criação da cor de fundo da tela
     * @return - referência a cor de fundo
     */
    protected abstract int backgroundColor();

    /**
     * Método que força dar nome a uma tela
     * @return - título da tela
     */
    public abstract String getTitle();


}
