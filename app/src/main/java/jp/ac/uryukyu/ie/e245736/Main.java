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
            logic.printBoard();
            System.out.println("現在のターンは" + currentPlayer + "です");
            System.out.println("どこにコマを置きますか？");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            

        }
    }
}
