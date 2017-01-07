package pt.ipp.estgf.quizdroid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Tiago Pinto on 02/01/2017.
 */

public class PerguntaActivity extends Activity {

    List<Pergunta> perguntaList;
    int pontos = 0;
    int pergunta_id = 0;

    Pergunta PerguntaAtual;
    TextView txtPergunta, tempo, pontuacao;
    Button button_op_1, button_op_2, button_op_3, button_op_4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        MyDbHelper sqLiteDatabase = new MyDbHelper(this); //Base de dados da classe
        perguntaList = sqLiteDatabase.getAllPerguntas();  //Vai buscar todas as perguntas à Base de Dados
        PerguntaAtual = perguntaList.get(pergunta_id); //Pergunta atual

        //TextView onde será mostrada a pontuação
        txtPergunta = (TextView) findViewById(R.id.textView_pergunta); //TextView onde será mostrada a Pergunta

        //4 Botões que contém as opções da Base de dados
        button_op_1 = (Button) findViewById(R.id.button_op_1);
        button_op_2 = (Button) findViewById(R.id.button_op_2);
        button_op_3 = (Button) findViewById(R.id.button_op3);
        button_op_4 = (Button) findViewById(R.id.button_op4);

        pontuacao = (TextView) findViewById(R.id.textView_pontuacao); //TextView onde será mostrada a pontuação

        //tempo = (TextView) findViewById(R.id.textView_tempo); //TextView com o temporizador

        setPerguntaView();
        //tempo.setText("00:02:00");

        //CounterClass temporizador = new CounterClass(60000, 1000);

        button_op_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passa o texto do botão para outro método e verifica se a resposta está correta ou não
                getResposta(button_op_1.getText().toString());
            }
        });

        button_op_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResposta(button_op_2.getText().toString());
            }
        });

        button_op_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResposta(button_op_3.getText().toString());
            }
        });

        button_op_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResposta(button_op_4.getText().toString());
            }
        });

    }

    private void getResposta(String RespostaString) {

        //Se a condição coincidir aumenta o numero de pontos em 1 e altera o texto da pontuação
        if (PerguntaAtual.getRESPOSTA().equals(RespostaString)) {

            pontos++;
            pontuacao.setText("Pontuação: " + pontos);
        } else {
        /*
            // se tiver azar start activity e acaba o jogo
            Intent intent = new Intent(PerguntaActivity.this, Resultados_Activity.class);

            // passando o valor int
            Bundle b = new Bundle();
            b.putInt("score", pontos); // Sua pontuação
            intent.putExtras(b); // Coloca a sua pontuação para o próximo
            startActivity(intent);
            finish();
        }
        if (pergunta_id < 10) {

            // Se não houver mais perguntas
            PerguntaAtual = perguntaList.get(pergunta_id);
            setPerguntaView();
        } else {

            // Se houver mais perguntas
            Intent intent = new Intent(PerguntaActivity.this, Resultados_Activity.class);
            Bundle b = new Bundle();
            b.putInt("pontos", pontos); // Seu resultado
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }
        */
        }
    }

    /*
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            tempo.setText("Acabou o tempo!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            tempo.setText(hms);
        }
    }
    */

    private void setPerguntaView() {

        txtPergunta.setText(PerguntaAtual.getPERGUNTA());

        button_op_1.setText(PerguntaAtual.getOPTA());
        button_op_2.setText(PerguntaAtual.getOPTB());
        button_op_3.setText(PerguntaAtual.getOPTC());
        button_op_4.setText(PerguntaAtual.getOPTD());

        pergunta_id++;

    }
}

