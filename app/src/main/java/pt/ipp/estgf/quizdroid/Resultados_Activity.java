package pt.ipp.estgf.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tiago Pinto on 05/01/2017.
 */

public class Resultados_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView textView_resultados = (TextView) findViewById(R.id.textView_resultados);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("pontos");

        textView_resultados.setText("A sua pontuação é " + " " + score + ". Obrigado por jogar o meu jogo!");

    }

    public void playagain(View o) {

        Intent intent = new Intent(this, PerguntaActivity.class);

        startActivity(intent);

    }

}
