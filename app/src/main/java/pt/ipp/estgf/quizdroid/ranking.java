package pt.ipp.estgf.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ranking extends Activity implements View.OnClickListener {


    private int pontuacoes;

    //Construtor das pontuacoes
    //public ranking(int pontuacoes) {
        //this.pontuacoes = pontuacoes;
    //}

    public int getPontuacoes() {
        return pontuacoes;
    }

    public void setPontuacoes(int pontuacoes) {
        this.pontuacoes = pontuacoes;
    }



    Button ver_preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ver_preferencias = (Button) findViewById(R.id.button_preferencias);
        ver_preferencias.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_preferencias){

            Intent i = new Intent(ranking.this,administracao.class);
            startActivity(i);
        }
    }
}
