package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Adaptador de categoria, para indicar as abas que possuímos na
 * tela inicial e gerenciar o conteúdo de cada uma
 */
class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Contexto do aplicativo, onde deve ser inserido o adaptador
     */
    private Context mContext;

    /**
     * Cria um novo adaptador de categorias
     * @param context - contexto atual do aplicativo
     * @param fm - gerenciador de fragmentos criado na instância do app
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Pega o fragmento atual, de acordo com a aba sendo exibida na tela
     * @param position - posição da aba
     * @return - instância de framento da aba atual
     */
    @Override
    public Fragment getItem(int position) {
        return TabsRepository.getTab(position);
    }

    /**
     * Pega o número total de abas do adaptador
     * @return - número total de abas
     */
    @Override
    public int getCount() {
        return TabsRepository.count();
    }

    /**
     * Pega o título atual da aba selecionada
     * @param position - posição da aba selecionada
     * @return - título da aba selecionada
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return TabsRepository.getTitle(position);
    }
}
