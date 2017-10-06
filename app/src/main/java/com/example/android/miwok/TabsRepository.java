package com.example.android.miwok;

import android.app.Fragment;

import com.example.android.miwok.fragments.ColorFragment;
import com.example.android.miwok.fragments.FamilyFragment;
import com.example.android.miwok.fragments.NumberFragment;
import com.example.android.miwok.fragments.PhraseFragment;
import com.example.android.miwok.fragments.SuperFragment;

import java.util.Arrays;
import java.util.Vector;

public class TabsRepository {
    /**
     * Lista de fragmentos do aplicativo
     */
    private static Vector<SuperFragment> fragments = new Vector<SuperFragment>(Arrays.asList(
            new ColorFragment(),
            new FamilyFragment(),
            new NumberFragment(),
            new PhraseFragment()
    ));

    /**
     * Pega um fragmento da lista
     * @param index - item da lista
     * @return -fragmento da lista
     */
    public static SuperFragment getTab(int index) {
        return fragments.get(index);
    }

    /**
     * Pega p título de um fragmento da lista
     * @param index - item da lista
     * @return - título do item
     */
    public static String getTitle(int index) {
        return fragments.get(index).getTitle();
    }


    /**
     * Quantidade de fragmentos do app
     * @return - número de fragmentos
     */
    public static int count() {
        return fragments.size();
    }
}
