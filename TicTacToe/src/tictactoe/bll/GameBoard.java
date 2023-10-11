/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;
import java.util.Objects;
/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    private int o;
    private int player=1;
    private int turn=0;
    private int winner;
    private String sTable[][] = new String[3][3];
    private String checkTable[] = new String[3];
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        if(player==0){
            player=1;
            return 1;
        }else{
            player=0;
            return 0;
        }
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if((!Objects.equals(sTable[col][row], "X") && !Objects.equals(sTable[col][row], "O")) && !isGameOver()){
            if(player==0){
                sTable[col][row]="X";
            }else{
                sTable[col][row]="O";
            }
            turn+=1;
            return true;
        }
        return false;
    }

    public boolean isGameOver()
    {
        System.out.println(turn);
        if(turn>4&&turn<9){
            for(int row=0;row<sTable.length;row++){ // checking the rows
                for(int col=0;col<sTable.length;col++){
                    checkTable[col]=sTable[col][row];
                }
                if(checkCheckTable()){
                    return true;
                }
            }
            for(int col=0;col<sTable.length;col++){ //checking the cols
                for(int row=0;row<sTable.length;row++){
                    checkTable[row]=sTable[col][row];
                }
                if(checkCheckTable()){
                    return true;
                }
            }
            for(int diag1=0;diag1<sTable.length;diag1++){ //checking diagonal 1
                checkTable[diag1]=sTable[diag1][diag1];
            }
            if(checkCheckTable()){
                return true;
            }
            o=0;
            for (int col=sTable.length-1;col>=0;col--,o++){ // checking diagonal 2
                checkTable[col] = sTable[col][o];
            }
            if(checkCheckTable()){
                return true;
            }
        }else if (turn>8){
            winner=-1;
            return true;
        }
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        return winner;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        getNextPlayer();
        for(int i=0;i<sTable.length;i++){
            for(int k=0; k<sTable.length;k++){
                sTable[i][k]="";
            }
            checkTable[i]="";
        }
        winner=-1;
        turn=0;
    }
    private void checkWinner(){
        if(Objects.equals(checkTable[0], "X"))
        {
            winner=0;
        }else{
            winner=1;
        }
    }
    private boolean checkCheckTable(){ //checks if there is a full row, column or diagonal
        if(Objects.equals(checkTable[0], checkTable[1]) && Objects.equals(checkTable[1], checkTable[2])&& (checkTable[1]=="X" || checkTable[1]=="O")){
            checkWinner();
            return true;
        }
        return false;
    }
}