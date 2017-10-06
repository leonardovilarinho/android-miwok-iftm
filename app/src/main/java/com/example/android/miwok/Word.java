package com.example.android.miwok;

/**
 * Objeto que representa o conteúdo de uma cedula
 * da lista de cada categoria
 */
public class Word {
    /**
     * Armazena o valor da tradução em português
     */
    private String _default;

    /**
     * Armazena o valor da tradução em miwok
     */
    private String _miwok;

    /**
     * Armazena a referência para a imagem dessa tradução
     */
    private int _image = WITHOUT_IMAGE;

    /**
     * Armazena a referência para o áudio dessa tradução
     */
    private int _audio;

    /**
     * Constante que define que a tradução não tem uma imagem
     */
    private static final int WITHOUT_IMAGE = -1;

    /**
     * Fábrica de tradução com imagem
     * @param _default - palavra em português
     * @param _miwok - palavra em miwok
     * @param _image - referência da imagem
     * @param _audio - referência do áudio
     * @return - tradução iniciada
     */
    public static Word make(String _default, String _miwok, int _image, int _audio) {
        return new Word(_default, _miwok, _image, _audio);
    }

    /**
     * Fábrica de tradução sem imagem
     * @param _default - palavra em português
     * @param _miwok - palavra em miwok
     * @param _audio - referência do áudio
     * @return - tradução iniciada
     */
    public static Word make(String _default, String _miwok, int _audio) {
        return new Word(_default, _miwok, _audio);
    }

    /**
     * Cria uma tradução completa, ou seja, com imagem
     * @param _default - palavra em português
     * @param _miwok - palavra em miwok
     * @param _image - referência da imagem
     * @param _audio - referência do áudio
     */
    public Word(String _default, String _miwok, int _image, int _audio) {
        this._default = _default;
        this._miwok = _miwok;
        this._image = _image;
        this._audio = _audio;
    }

    /**
     * Cria uma tradução simples, sem uma imagem de descrição
     * @param _default - palavra em português
     * @param _miwok - palavra em miwok
     * @param _audio - referência do áudio
     */
    public Word(String _default, String _miwok, int _audio) {
        this._default = _default;
        this._miwok = _miwok;
        this._audio = _audio;
    }

    /**
     * Pega a palavra em português
     * @return - palavra em português
     */
    public String getDefault() {
        return _default;
    }

    /**
     * Pega a palavra em miwok
     * @return - palavra em miwok
     */
    public String getMiwok() {
        return _miwok;
    }

    /**
     * Pega referência da imagem
     * @return - número de referência
     */
    public int getImage() {
        return _image;
    }

    /**
     * Pega a referência do áudio
     * @return - número de referência
     */
    public int getAudio() { return _audio; }

    /**
     * Verifica se a tradução exige uma imagem
     * @return - tem imagem
     */
    public boolean hasImage() {
        return _image != WITHOUT_IMAGE;
    }
}
