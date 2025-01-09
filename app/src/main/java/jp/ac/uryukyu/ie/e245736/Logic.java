package jp.ac.uryukyu.ie.e245736;

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

    public boolean check(int a, int b, int player_color) {
        if(board[a][b] == 0) {
            if(checkBoardEmpty(a, b, player_color)){

            }
        }else{return false;}
    }

    public void printBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(board[i][j]);
                if(j==7) {
                    System.out.println("");
                }
            }
        }
    }

    private boolean checkBoardEmpty(int a, int b, int player_color) {
        return board[a][b] == player_color || board[a][b] == player_color || board[a][b] == player_color || board[a][b] == player_color || 
        board[a][b] == player_color || board[a][b] == player_color || board[a][b] == player_color || board[a][b] == player_color;
    }
}
