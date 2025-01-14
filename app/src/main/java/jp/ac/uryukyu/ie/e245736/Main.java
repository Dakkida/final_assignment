package jp.ac.uryukyu.ie.e245736;

import java.util.Scanner;

//0が何も乗ってなくて、１が白、２が黒
public class Main {
    public static void main(String[] args) {
        int WhitePlayer = 1;
        int BlackPlayer = 2;

        Logic logic = new Logic();
        Scanner scanner = new Scanner(System.in);

        int currentPlayer = WhitePlayer;
        System.out.println("先行は白です");

        while(true) {   
            String currentColor = "";

            if(currentPlayer == 1){
                currentColor = "白";
            }else if(currentPlayer == 2){
                currentColor = "黒";
            }

            logic.printBoard();
            System.out.println("現在のターンは" + currentColor + "です");
            System.out.println("どこにコマを置きますか？");
            System.out.println("X座標Y座標8x8で指定してください");
            System.out.println("X座標を入力してくだい");
            int row = scanner.nextInt() - 1;
            System.out.println("Y座標を入力してください");
            int col = scanner.nextInt() - 1;
            
            if(logic.check(col, row, currentPlayer, currentPlayer)){
                if(currentPlayer == 1){
                    currentPlayer = 2;
                }else{
                    currentPlayer = 1;
                }
            }else{
                System.out.println("有効なマスにコマを置いてください!!!");
            }
        }
    }
}
