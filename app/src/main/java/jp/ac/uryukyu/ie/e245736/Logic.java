package jp.ac.uryukyu.ie.e245736;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Logic {
    private int[][] board = new int[8][8];
    //0が何も乗ってなくて、１が白、２が黒
    public Logic(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
            board[i][j] = 0;
            }
        }

        board[3][3] = 1;
        board[3][4] = 2;
        board[4][3] = 2;
        board[4][4] = 1;
    }

    //コマが置けるか確認する
    public boolean check(int a, int b, int currentPlayerColor, int currentOpponentPlayer) {
        if(board[a][b] == 0) {
            if(checkBoardEmptAndJudge(a, b, currentPlayerColor, currentOpponentPlayer)){
                
            }else{return false;}
        }else{return false;}
    }

    public void printBoard(){
        for(int i=0; i<8; i++){
            System.out.println("--------");
            for(int j=0; j<8; j++){
                System.out.println("|");
                System.out.print(board[i][j]);
                if(j==7) {
                    System.out.println("");
                }
            }
        }
    }

    //ボードの盤面が空いているか確認しコマが置けるか判断する
    private boolean checkBoardEmptAndJudge(int a, int b, int player_color, int currentOpponentPlayer) {
        //置くこま周辺上下左右斜め8つに相手のコマがあるかの確認
        if(board[a-1][b-1] == player_color || board[a][b-1] == player_color || board[a+1][b-1] == player_color || board[a-1][b] == player_color || 
        board[a+1][b] == player_color || board[a-1][b+1] == player_color || board[a][b+1] == player_color || board[a+1][b+1] == player_color){
            if()
        }el
    }

    //以下ひっくり返すか確認しひっくり返す
    public boolean checkJudge(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor) {
        
    }

    //上方向に相手のコマをひっくり返す
    public void turnUp(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor) {
        int targetY = a-1;

        //盤の外なら終了
        if(targetY < 0) {
            return;
        }
        

        //現在のプレイヤーではないコマでないorマスが空ではないならループし続ける
        while(board[targetY][b] != currentPlayerColor && board[targetY][b] != 0){

            //次のマスへ
            targetY--;

            //盤の外なら終了
            if(targetY < 0){
                break;
            }

            //もし自分のコマならば
            if(board[targetY][b] == currentPlayerColor) {
                for(; a < targetY; ++){

                }
            }else{return;}
        }

        return;
    }
}
