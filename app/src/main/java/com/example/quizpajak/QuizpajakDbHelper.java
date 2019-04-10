package com.example.quizpajak;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quizpajak.QuizContract.*;

public class QuizpajakDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quizpajak.db";
    private static final int DATABASE_VERSION  = 1;

    private SQLiteDatabase db;

    public QuizpajakDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + "(" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuestionsTable.COLUMN_QUESTION + "TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + "TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + "TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + "TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + "TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + "INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    public void fillQuestionTable(){
        Question q1 = new Question("A is Correct", "A", "B", "C", "D", 1);
    }

    public void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(Question);
    }
}
