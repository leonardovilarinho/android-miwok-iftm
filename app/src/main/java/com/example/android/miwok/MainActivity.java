package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Classe inicial do sistema, cnfigura aplicativo e inicia
 * a tela
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Armazena o container de viewpager da página inicial
     */
    private ViewPager viewPager;

    /**
     * Inicia a tela com o layout inicial, adicionando o adaptador de categorias e
     * configurando as abas de categorias de traduções
     * @param savedInstanceState - estado da instância salva na memória
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCategoryAdapter();
        configureTabLayout();
    }

    /**
     * Cria o adaptador de categorias e adiciona ele a view pager da tela principal
     */
    private void addCategoryAdapter() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    /**
     * Cria a abas de categorias com a configuração do adaptador de categorias atual
     * do view pager
     */
    private void configureTabLayout() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
