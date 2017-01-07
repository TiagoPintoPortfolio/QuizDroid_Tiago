package pt.ipp.estgf.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Tiago Pinto on 18/11/2016.
 */

public class niveis extends Activity implements View.OnClickListener{

    private int id;
    private String nome;
    private String descricao;

    //Construtor da classe niveis
    //public niveis(int id, String nome, String descricao) {
        //this.id = id;
        //this.nome = nome;
        //this.descricao = descricao;
    //}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    Button ver_facil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveis);

        Button ver_facil = (Button)findViewById(R.id.button_facil);
        ver_facil.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_facil){

            Intent i = new Intent(niveis.this,Pergunta.class);
            startActivity(i);
        }

    }
}

