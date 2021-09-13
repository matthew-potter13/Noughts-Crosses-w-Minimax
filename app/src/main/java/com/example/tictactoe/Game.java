package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    private Random random;
    private Button grid00;
    private Button grid01;
    private Button grid02;
    private Button grid10;
    private Button grid11;
    private Button grid12;
    private Button grid20;
    private Button grid21;
    private Button grid22;

    private TextView WinsText;
    private TextView LossesText;;
    private TextView DrawsText;;
    int wins = 0;
    int losses = 0;
    int draws = 0;

    boolean gameEnd;

    int lvlCount = 3;
    private Button minusLvl;
    private Button lvl;
    private Button incLvl;


    ArrayList<String> spaces = new ArrayList<String>();
    ArrayList<String> CPUMoves = new ArrayList<String>();
    ArrayList<String> PlayerMoves = new ArrayList<String>();

    ArrayList<Integer> scores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().setTitle("Tic Tac Toe");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WinsText =  findViewById(R.id.win);
        LossesText = findViewById(R.id.loss);
        DrawsText = findViewById(R.id.draw);

        minusLvl = findViewById(R.id.minusLvl);
        incLvl = findViewById(R.id.incLvl);

        lvl = (Button) findViewById(R.id.Lvl);
        lvl.setText(""+lvlCount);

        grid00 = (Button) findViewById(R.id.grid00);
        grid01 = (Button) findViewById(R.id.grid01);
        grid02 = (Button) findViewById(R.id.grid02);
        grid10 = (Button) findViewById(R.id.grid10);
        grid11 = (Button) findViewById(R.id.grid11);
        grid12 = (Button) findViewById(R.id.grid12);
        grid20 = (Button) findViewById(R.id.grid20);
        grid21 = (Button) findViewById(R.id.grid21);
        grid22 = (Button) findViewById(R.id.grid22);

        lockBoard();

        lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvl.setClickable(false);
                minusLvl.setClickable(false);
                incLvl.setClickable(false);
                gameEnd = false;
                play();
            }
        });

        minusLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lvlCount > 1){
                    lvlCount--;
                    lvl.setText(""+lvlCount);
                }
            }
        });

        incLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lvlCount < 5){
                    lvlCount++;
                    lvl.setText(""+lvlCount);
                }
            }
        });

        scores.add(0);
        scores.add(1);
        scores.add(-1);
    }

    public void lockBoard(){
        grid00.setClickable(false);
        grid01.setClickable(false);
        grid02.setClickable(false);
        grid10.setClickable(false);
        grid11.setClickable(false);
        grid12.setClickable(false);
        grid20.setClickable(false);
        grid21.setClickable(false);
        grid22.setClickable(false);
    }

    public void unlockBoard(){
        grid00.setText("");
        grid01.setText("");
        grid02.setText("");
        grid10.setText("");
        grid11.setText("");
        grid12.setText("");
        grid20.setText("");
        grid21.setText("");
        grid22.setText("");

        spaces.clear();
        spaces.add("00");
        spaces.add("01");
        spaces.add("02");
        spaces.add("10");
        spaces.add("11");
        spaces.add("12");
        spaces.add("20");
        spaces.add("21");
        spaces.add("22");
        PlayerMoves.clear();
        CPUMoves.clear();

        grid00.setClickable(true);
        grid01.setClickable(true);
        grid02.setClickable(true);
        grid10.setClickable(true);
        grid11.setClickable(true);
        grid12.setClickable(true);
        grid20.setClickable(true);
        grid21.setClickable(true);
        grid22.setClickable(true);
    }

    public void play(){
        unlockBoard();
        grid00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid00.setText("O");
                spaces.remove("00");
                grid00.setClickable(false);
                PlayerMoves.add("00");
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid01.setText("O");
                spaces.remove("01");
                grid01.setClickable(false);
                PlayerMoves.add("01");
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid02.setText("O");
                spaces.remove("02");
                grid02.setClickable(false);
                PlayerMoves.add("02");
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid10.setText("O");
                spaces.remove("10");
                PlayerMoves.add("10");
                grid10.setClickable(false);
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid11.setText("O");
                spaces.remove("11");
                PlayerMoves.add("11");
                grid11.setClickable(false);
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid12.setText("O");
                spaces.remove("12");
                PlayerMoves.add("12");
                grid12.setClickable(false);
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid20.setText("O");
                spaces.remove("20");
                grid20.setClickable(false);
                PlayerMoves.add("20");
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid21.setText("O");
                spaces.remove("21");
                PlayerMoves.add("21");
                grid21.setClickable(false);
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });

        grid22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid22.setText("O");
                spaces.remove("22");
                PlayerMoves.add("22");
                grid22.setClickable(false);
                WIN();
                if (!gameEnd) {
                    CPU();
                    WIN();
                }
            }
        });
    }

    public void CPU(){
        if (spaces.size() > 0) {
            int bestScore = -1000000000;

            random = new Random();
            int prob = random.nextInt(100);
            int index = random.nextInt(spaces.size());
            String test = spaces.get(index);

            for (int i = 0; i < spaces.size(); i++) {
                String swap = spaces.get(i);
                CPUMoves.add(swap);
                spaces.remove(swap);
                int score = minimax(spaces, 0, false);
                CPUMoves.remove(swap);
                spaces.add(i, swap);
                if (score > bestScore) {
                    bestScore = score;
                    test = spaces.get(i);
                }
            }

            if (lvlCount == 1){
                    index = random.nextInt(spaces.size());
                    test = spaces.get(index);
            } else if (lvlCount == 2){
                if (prob > 75){
                    index = random.nextInt(spaces.size());
                    test = spaces.get(index);
                }
            } else if (lvlCount == 3){
                if (prob > 85){
                    index = random.nextInt(spaces.size());
                    test = spaces.get(index);
                }
            } else if (lvlCount == 4){
                if (prob > 95){
                    index = random.nextInt(spaces.size());
                    test = spaces.get(index);
                }
            }

            if (test.contains("00") == true) {
                grid00.setText("X");
                spaces.remove("00");
                grid00.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("01") == true) {
                grid01.setText("X");
                spaces.remove("01");
                grid01.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("02") == true) {
                grid02.setText("X");
                spaces.remove("02");
                grid02.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("10") == true) {
                grid10.setText("X");
                spaces.remove("10");
                grid10.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("11") == true) {
                grid11.setText("X");
                spaces.remove("11");
                grid11.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("12") == true) {
                grid12.setText("X");
                spaces.remove("12");
                grid12.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("20") == true) {
                grid20.setText("X");
                spaces.remove("20");
                grid20.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("21") == true) {
                grid21.setText("X");
                spaces.remove("21");
                grid21.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            } else if (test.contains("22") == true) {
                grid22.setText("X");
                spaces.remove("22");
                grid22.setClickable(false);
                //CPUMoves.add("00");
                CPUMoves.add(test);
            }
        }
    }

    public int minimax(ArrayList<String> spacesCopy, int depth, Boolean isMax){
        if (WINAI() != -1) {
            return scores.get(WINAI());
        }

        if (isMax == true){
            int bestScore = -1000000000;
            if (spacesCopy.size() > 0) {
                for (int i = 0; i < spacesCopy.size(); i++) {
                    String swap = spacesCopy.get(i);
                    CPUMoves.add(swap);
                    spacesCopy.remove(swap);
                    int score = minimax(spacesCopy,depth+1, false);
                    CPUMoves.remove(swap);
                    spacesCopy.add(i, swap);
                    if (score >= bestScore) {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 1000000000;
            if (spacesCopy.size() > 0) {
                for (int i = 0; i < spacesCopy.size(); i++) {
                    String swap = spacesCopy.get(i);
                    PlayerMoves.add(swap);
                    spacesCopy.remove(swap);
                    int score = minimax(spacesCopy, depth+1, true);
                    PlayerMoves.remove(swap);
                    spacesCopy.add(i, swap);
                    if (score <= bestScore) {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        }
    }

    public int WINAI(){
        //ROWS
        if (PlayerMoves.contains("00") && PlayerMoves.contains("01") && PlayerMoves.contains("02")){
            return 2;
        }
        else if (PlayerMoves.contains("10") && PlayerMoves.contains("11") && PlayerMoves.contains("12")){
            return 2;
        }
        else if (PlayerMoves.contains("20") && PlayerMoves.contains("21") && PlayerMoves.contains("22")){
            return 2;
        }//COLLUMNS
        else if (PlayerMoves.contains("00") && PlayerMoves.contains("10") && PlayerMoves.contains("20")){
            return 2;
        }else if (PlayerMoves.contains("01") && PlayerMoves.contains("11") && PlayerMoves.contains("21")){
            return 2;
        }else if (PlayerMoves.contains("02") && PlayerMoves.contains("12") && PlayerMoves.contains("22")){
            return 2;
        //DIAGONALS
        }else if (PlayerMoves.contains("00") && PlayerMoves.contains("11") && PlayerMoves.contains("22")){
            return 2;
        }else if (PlayerMoves.contains("20") && PlayerMoves.contains("11") && PlayerMoves.contains("02")){
            return 2;
        }

        //ROWS
        if (CPUMoves.contains("00") && CPUMoves.contains("01") && CPUMoves.contains("02")){
            return 1;
        }
        else if (CPUMoves.contains("10") && CPUMoves.contains("11") && CPUMoves.contains("12")){
            return 1;
        }
        else if (CPUMoves.contains("20") && CPUMoves.contains("21") && CPUMoves.contains("22")){
            return 1;
        }//COLLUMNS
        else if (CPUMoves.contains("00") && CPUMoves.contains("10") && CPUMoves.contains("20")){
            return 1;
        }else if (CPUMoves.contains("01") && CPUMoves.contains("11") && CPUMoves.contains("21")){
            return 1;
        }else if (CPUMoves.contains("02") && CPUMoves.contains("12") && CPUMoves.contains("22")){
            return 1;
        //DIAGONALS
        }else if (CPUMoves.contains("00") && CPUMoves.contains("11") && CPUMoves.contains("22")){
            return 1;
        }else if (CPUMoves.contains("02") && CPUMoves.contains("11") && CPUMoves.contains("20")){
            return 1;
        }


        if (spaces.size() == 0){
            return 0;
        }

        return -1;
    }

    public void WIN(){
        if (!gameEnd) {
            //ROWS
            if (PlayerMoves.contains("00") && PlayerMoves.contains("01") && PlayerMoves.contains("02")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (PlayerMoves.contains("10") && PlayerMoves.contains("11") && PlayerMoves.contains("12")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (PlayerMoves.contains("20") && PlayerMoves.contains("21") && PlayerMoves.contains("22")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            }//COLLUMNS
            else if (PlayerMoves.contains("00") && PlayerMoves.contains("10") && PlayerMoves.contains("20")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (PlayerMoves.contains("01") && PlayerMoves.contains("11") && PlayerMoves.contains("21")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (PlayerMoves.contains("02") && PlayerMoves.contains("12") && PlayerMoves.contains("22")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
                //DIAGONALS
            } else if (PlayerMoves.contains("00") && PlayerMoves.contains("11") && PlayerMoves.contains("22")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (PlayerMoves.contains("20") && PlayerMoves.contains("11") && PlayerMoves.contains("02")) {
                //finish();
                wins++;
                WinsText.setText("Wins: " + wins);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            }
        }
        if(!gameEnd){
            //ROWS
            if (CPUMoves.contains("00") && CPUMoves.contains("01") && CPUMoves.contains("02")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (CPUMoves.contains("10") && CPUMoves.contains("11") && CPUMoves.contains("12")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (CPUMoves.contains("20") && CPUMoves.contains("21") && CPUMoves.contains("22")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            }//COLLUMNS
            else if (CPUMoves.contains("00") && CPUMoves.contains("10") && CPUMoves.contains("20")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (CPUMoves.contains("01") && CPUMoves.contains("11") && CPUMoves.contains("21")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (CPUMoves.contains("02") && CPUMoves.contains("12") && CPUMoves.contains("22")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
                //DIAGONALS
            } else if (CPUMoves.contains("00") && CPUMoves.contains("11") && CPUMoves.contains("22")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            } else if (CPUMoves.contains("02") && CPUMoves.contains("11") && CPUMoves.contains("20")) {
                //finish();
                losses++;
                LossesText.setText("Losses: " + losses);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            }
        }

        if (!gameEnd) {
            if (spaces.size() == 0) {
                draws++;
                DrawsText.setText("Draws: " + draws);
                lockBoard();
                gameEnd = true;
                lvl.setClickable(true);
                minusLvl.setClickable(true);
                incLvl.setClickable(true);
            }
        }
    }
}
