package jp.ac.uryukyu.ie.e245736;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//0が何も乗ってなくて、１が白、２が黒
public class Main {
    public static void main(String[] args) {
        int WhitePlayer = 1;
        int BlackPlayer = 2;

        Logic logic = new Logic();
        try (Scanner scanner = new Scanner(System.in)) {
            int currentPlayer = WhitePlayer;
            int currentOpponentPlayer = BlackPlayer;
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
                
                if(logic.check(col, row, currentPlayer, currentOpponentPlayer)){
                    if(currentPlayer == 1){
                        currentPlayer = 2;
                        currentOpponentPlayer = 1;
                    }else{
                        currentPlayer = 1;
                        currentOpponentPlayer = 2;
                    }
                }else{
                    System.out.println("有効なマスにコマを置いてください!!!");
                    try {
                        Thread.sleep(5000); // 10秒(1万ミリ秒)間だけ処理を止める
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
