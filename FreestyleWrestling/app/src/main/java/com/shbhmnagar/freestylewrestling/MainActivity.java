package com.shbhmnagar.freestylewrestling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// Player A is Red Player and Player B is Blue Player.
public class MainActivity extends AppCompatActivity {

    /**
     * Keep's track of the score of player A
            */
    int playerAScore = 0;

    /**
     * Keep's track of the score of player B
     */
    int playerBScore = 0;

    /**
     * Keep's track of the penalty of player A
     */
    int penaltyA = 0;

    /**
     * Keep's track of the penalty of player B
     */
    int penaltyB = 0;

    /**
     * Saves the state of the playerAScore
     */
    private static final String PLAYER_A_SCORE = "playerAScore";

    /**
     * Saves the state of the playerBScore
     */
    private static final String PLAYER_B_SCORE = "playerBScore";

    /**
     * Saves the state of the penaltyA
     */
    private static final String PLAYER_A_PENALTY = "penaltyA";

    /**
     * Saves the state of the penaltyB
     */
    private static final String PLAYER_B_PENALTY = "penaltyB";

    TextView scoreViewA;
    TextView scoreViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = findViewById(R.id.playerA_Score);
        scoreViewB = findViewById(R.id.playerB_Score);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of items position
        outState.putInt(PLAYER_A_SCORE, playerAScore);
        outState.putInt(PLAYER_B_SCORE, playerBScore);
        outState.putInt(PLAYER_A_PENALTY, penaltyA);
        outState.putInt(PLAYER_B_PENALTY, penaltyB);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Read the state of items position
        playerAScore = savedInstanceState.getInt(PLAYER_A_SCORE);
        playerBScore = savedInstanceState.getInt(PLAYER_B_SCORE);
        penaltyA = savedInstanceState.getInt(PLAYER_A_PENALTY);
        penaltyB = savedInstanceState.getInt(PLAYER_B_PENALTY);
        displayScoreOfPlayerA(playerAScore);
        displayScoreOfPlayerB(playerBScore);
    }


    /**
     * Increase the score of player A by 1 point
     */
    public void addOnePointA(View v) {
        playerAScore += 1;
        displayScoreOfPlayerA(playerAScore);
    }

    /**
     * Increase the score of player A by 2 point
     */
    public void addTwoPointA(View v) {
        playerAScore += 2;
        displayScoreOfPlayerA(playerAScore);
    }

    /**
     * Increase the score of player A by 4 point
     */
    public void addFourPointA(View v) {
        playerAScore += 4;
        displayScoreOfPlayerA(playerAScore);
    }

    /**
     * Increase the score of player A by 5 point
     */
    public void addFivePointA(View v) {
        playerAScore += 5;
        displayScoreOfPlayerA(playerAScore);
    }

    /**
     * Gives the point 1 point to player B for 1st, 2nd and 3rd penalty.
     * At, fourth penalty player B wins.
     */
    public void penaltyA (View v) {

        penaltyA += 1;

        if(penaltyA <= 2) {
            playerBScore += 1;
            displayScoreOfPlayerB(playerBScore);
        }
        else if(penaltyA == 3) {
            playerBScore += 2;
            displayScoreOfPlayerB(playerBScore);
        }
        else {
            // Player B wins
            Toast toast = Toast.makeText(getApplicationContext(), R.string.playerBlueWin, Toast.LENGTH_SHORT);
            toast.show();
            resetRoundScore();
        }
    }

    /**
     * Player A wins if pinA is clicked
     */
    public void pinA (View v) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.playerRedWin, Toast.LENGTH_SHORT);
        toast.show();
        resetRoundScore();
    }

    /**
     * Displays the score of player A
     * @param score
     */
    public void displayScoreOfPlayerA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Increase the score of player B by 1 point
     */
    public void addOnePointB(View v) {
        playerBScore += 1;
        displayScoreOfPlayerB(playerBScore);
    }

    /**
     * Increase the score of player B by 2 point
     */
    public void addTwoPointB(View v) {
        playerBScore += 2;
        displayScoreOfPlayerB(playerBScore);
    }

    /**
     * Increase the score of player B by 4 point
     */
    public void addFourPointB(View v) {
        playerBScore += 4;
        displayScoreOfPlayerB(playerBScore);
    }

    /**
     * Increase the score of player B by 5 point
     */
    public void addFivePointB(View v) {
        playerBScore += 5;
        displayScoreOfPlayerB(playerBScore);
    }

    /**
     * Gives the point 1 point to player A for 1st, 2nd and 3rd penalty.
     * At, fourth penalty player A wins.
     */
    public void penaltyB (View v) {

        penaltyB += 1;

        if(penaltyB <= 2) {
            playerAScore += 1;
            displayScoreOfPlayerA(playerAScore);
        }
        else if(penaltyB == 3) {
            playerAScore += 2;
            displayScoreOfPlayerA(playerAScore);
        }
        else {
            // Display toast of Player A Win
            Toast toast = Toast.makeText(getApplicationContext(), R.string.playerRedWin, Toast.LENGTH_SHORT);
            toast.show();
            resetRoundScore();
        }
    }

    /**
     * Player B wins if pinB is clicked
     */
    public void pinB (View v) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.playerBlueWin, Toast.LENGTH_SHORT);
        toast.show();
        resetRoundScore();
    }

    /**
     * Displays the score of player B
     * @param score
     */
    public void displayScoreOfPlayerB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    /**
     * Reset's the whole score of the match
     */
    public void resetWholeScore(View v) {
        playerAScore = 0;
        playerBScore = 0;
        penaltyA = 0;
        penaltyB = 0;
        displayScoreOfPlayerA(playerAScore);
        displayScoreOfPlayerB(playerBScore);
    }

    /**
     * Reset's the round score of the match
     */
    public void resetRoundScore() {
        playerAScore = 0;
        playerBScore = 0;
        penaltyA = 0;
        penaltyB = 0;
        displayScoreOfPlayerA(playerAScore);
        displayScoreOfPlayerB(playerBScore);
    }
}
