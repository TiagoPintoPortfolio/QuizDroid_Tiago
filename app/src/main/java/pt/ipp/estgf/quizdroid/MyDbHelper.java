package pt.ipp.estgf.quizdroid;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago Pinto on 02/01/2017.
 */

public class MyDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    //Nome da Base de Dados
    private static final String DATABASE_NAME = "droidquizdatabase";
    //Tabela Perguntas
    private static final String TABLE_PERG = "Pergunta";

    //Colunas das tabelas
    private static final String KEY_ID = "pergunta_id";
    private static final String KEY_PERG = "Pergunta";
    private static final String KEY_RESP = "resposta"; // resposta correta
    private static final String KEY_OPTA = "opta"; // opção a
    private static final String KEY_OPTB = "optb"; // opção b
    private static final String KEY_OPTC = "optc"; // opção c
    private static final String KEY_OPTD = "optd"; // opção d


    private SQLiteDatabase dbase;

    //public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
    //}

    //public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        //super(context, name, factory, version, errorHandler);
    //}

    public MyDbHelper(Context context){

        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        dbase = sqLiteDatabase;
        String sql = "CREATE TABLE IF NOT EXISTS" + TABLE_PERG + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PERG
                + " TEXT, " + KEY_RESP + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)" + KEY_OPTD + "TEXT";
        sqLiteDatabase.execSQL(sql);
        addPergunta();
    }

    private void addPergunta() {

        Pergunta p1 = new Pergunta("5+2 = ?", "7", "8", "6", "7", "1");
        this.addPergunta(p1);
        Pergunta p2 = new Pergunta("2+18 = ?", "18", "19", "20", "20","29");
        this.addPergunta(p2);
        Pergunta p3 = new Pergunta("10-3 = ?", "6", "7", "8", "7", "9");
        this.addPergunta(p3);
        Pergunta p4 = new Pergunta("5+7 = ?", "12", "13", "14", "12","16");
        this.addPergunta(p4);
        Pergunta p5 = new Pergunta("3-1 = ?", "1", "3", "2", "2","10");
        this.addPergunta(p5);
        Pergunta p6 = new Pergunta("0+1 = ?", "1", "0", "10", "1","2");
        this.addPergunta(p6);
        Pergunta p7 = new Pergunta("9-9 = ?", "0", "9", "1", "0","3");
        this.addPergunta(p7);
        Pergunta p8 = new Pergunta("3+6 = ?", "8", "7", "9", "9","10");
        this.addPergunta(p8);
        Pergunta p9 = new Pergunta("1+5 = ?", "6", "7", "5", "6","9");
        this.addPergunta(p9);
        Pergunta p10 = new Pergunta("7-5 = ?", "3", "2", "6", "2","1");
        this.addPergunta(p10);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV) {

        //Drop da tabela antiga se existir
        dbase.execSQL("DROP TABLE IF EXISTS " + TABLE_PERG);
        //Cria de novo a tabela
        onCreate(dbase);

    }

    //Adicionar nova Pergunta
    public void addPergunta(Pergunta perg) {

        ContentValues values = new ContentValues();
        values.put(KEY_PERG, perg.getPERGUNTA());
        values.put(KEY_RESP, perg.getRESPOSTA());
        values.put(KEY_OPTA, perg.getOPTA());
        values.put(KEY_OPTB, perg.getOPTB());
        values.put(KEY_OPTC, perg.getOPTC());
        values.put(KEY_OPTD, perg.getOPTD());

        // Inserindo linhas
        dbase.insert(TABLE_PERG, null, values);
    }

    public List<Pergunta> getAllPerguntas(){

        List<Pergunta> pergList = new ArrayList<Pergunta>();

        //Seleciona todas as Queries
        String selectQuery = "SELECT * FROM" + TABLE_PERG;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery,null);

        //Ciclo que percorre todas as linhas e adiciona à lista
        if(cursor.moveToFirst()){

            do{
                Pergunta perg = new Pergunta();
                perg.setID(cursor.getInt(0));
                perg.setPERGUNTA(cursor.getString(1));
                perg.setRESPOSTA(cursor.getString(2));
                perg.setOPTA(cursor.getString(3));
                perg.setOPTB(cursor.getString(4));
                perg.setOPTC(cursor.getString(5));
                perg.setOPTD(cursor.getString(6));

                pergList.add(perg);
            } while(cursor.moveToNext());
        }
        return pergList;
    }
}
