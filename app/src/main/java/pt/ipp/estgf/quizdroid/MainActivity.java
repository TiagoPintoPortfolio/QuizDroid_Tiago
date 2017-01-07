package pt.ipp.estgf.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {


    Button ver_novo_jogo;

    Button ver_ranking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ver_novo_jogo = (Button) findViewById(R.id.button_novo_jogo);
        ver_novo_jogo.setOnClickListener(this);

        ver_ranking = (Button) findViewById(R.id.button_ranking);
        ver_ranking.setOnClickListener(this);


    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate ao menu; Isso adiciona itens à actionbar se ela estiver presente.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

*/
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_novo_jogo) {

            Intent i = new Intent(MainActivity.this, niveis.class);
            startActivity(i);
        } else {

            if (v.getId() == R.id.button_ranking) {

                Intent i = new Intent(MainActivity.this, ranking.class);
                startActivity(i);
            }

        }
    }
}
