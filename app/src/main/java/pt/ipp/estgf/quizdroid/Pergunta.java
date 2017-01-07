package pt.ipp.estgf.quizdroid;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Tiago Pinto on 02/01/2017.
 */

public class Pergunta extends Activity{

    private int ID;
    //private int nivel;
    private String PERGUNTA;
    private String RESPOSTA;
    //private String pontuacao;

    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;

    public Pergunta() {

        ID = 0;
        PERGUNTA = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        OPTD = "";

        RESPOSTA = "";
    }

    public Pergunta(String pergunta, String oPTA, String oPTB, String oPTC, String oPTD, String rESPOSTA) {
            PERGUNTA = pergunta;
            OPTA = oPTA;
            OPTB = oPTB;
            OPTC = oPTC;
            OPTD = oPTD;

            RESPOSTA = rESPOSTA;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPERGUNTA() {
        return PERGUNTA;
    }

    public void setPERGUNTA(String PERGUNTA) {
        this.PERGUNTA = PERGUNTA;
    }

    public String getRESPOSTA() {
        return RESPOSTA;
    }

    public void setRESPOSTA(String RESPOSTA) {
        this.RESPOSTA = RESPOSTA;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String OPTD) {
        this.OPTD = OPTD;
    }

    /*
        public Pergunta(int i, int i1, String s, String s1, String s2) {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public String getPergunta() {
            return Pergunta;
        }

        public void setPergunta(String Pergunta) {
            this.Pergunta = Pergunta;
        }

        public String getResposta() {
            return Resposta;
        }

        public void setResposta(String resposta) {
            this.Resposta = resposta;
        }

        public String getPontuacao() {
            return pontuacao;
        }

        public void setPontuacao(String pontuacao) {
            this.pontuacao = pontuacao;
        }


        public String getOPTA() {
            return OPTA;
        }

        public void setOPTA(String OPTA) {
            this.OPTA = OPTA;
        }

        public String getOPTB() {
            return OPTB;
        }

        public void setOPTB(String OPTB) {
            this.OPTB = OPTB;
        }

        public String getOPTC() {
            return OPTC;
        }

        public void setOPTC(String OPTC) {
            this.OPTC = OPTC;
        }

        public String getOPTD() {
            return OPTD;
        }

        public void setOPTD(String OPTD) {
            this.OPTD = OPTD;
        }
    */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
    }


}
