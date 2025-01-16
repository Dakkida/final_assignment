package jp.ac.uryukyu.ie.e245736;

/**
    * オセロゲームに関する処理を実行します
    */

public class Logic {
    private int[][] board = new int[8][8];
    //0が何も乗ってなくて、１が白、２が黒

    /**
    * boardの初期設定
    */
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

    /**
    * コマを置けるか判断します。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @return boolean
    */

    //コマが置けるか確認する
    public boolean check(int a, int b, int currentPlayerColor, int currentOpponentPlayer) {
        if(board[a][b] == 0) {
            if(checkBoardEmptyAndJudge(a, b, currentPlayerColor, currentOpponentPlayer)){
                board[a][b] = currentPlayerColor;
                return true;
            }else{return false;}
        }else{return false;}
    }

    /**
    * ボードの内容を出力します
    */

    public void printBoard(){
        for(int i=0; i<8; i++){
            System.out.println("----------------");
            for(int j=0; j<8; j++){
                System.out.print("|");
                System.out.print(board[i][j]);
                if(j==7) {
                    System.out.println("");
                }
            }
        }
        System.out.println("----------------");
    }

    /**
    * コマをひっくり返すかを判断し、できない場合は置けない旨の出力をし、falseを返す
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //ボードの盤面が空いているか確認しコマが置けるか判断する
    private boolean checkBoardEmptyAndJudge(int a, int b, int player_color, int currentOpponentPlayer) {
        //置くこま周辺上下左右斜め8つに相手のコマがあるかの確認
        if(board[a-1][b-1] == currentOpponentPlayer || board[a][b-1] == currentOpponentPlayer || board[a+1][b-1] == currentOpponentPlayer || board[a-1][b] == currentOpponentPlayer || 
        board[a+1][b] == currentOpponentPlayer || board[a-1][b+1] == currentOpponentPlayer || board[a][b+1] == currentOpponentPlayer || board[a+1][b+1] == currentOpponentPlayer){
            if(checkJudge(a,b,player_color, currentOpponentPlayer)){
                System.out.println("コマをひっくり返しました。");
                return true;
            }
        }else{
            System.out.printf("X座標:%d Y座標:%d にコマは置けません", b+1,a+1);
            return false;
        }
        System.out.printf("X座標:%d Y座標:%d にコマは置けません", a+1,b+1);
        return false;
    }

    /**
    * 全方向のひっくり返すかのメソッドを呼び出すメソッド
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //以下ひっくり返すか確認しひっくり返す
    public boolean checkJudge(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor) {
        if(turnUp(a,b,currentPlayerColor,currentOpponentPlayerColor) || turnDown(a, b, currentPlayerColor, currentOpponentPlayerColor) || 
        turnLeft(a,b,currentPlayerColor,currentOpponentPlayerColor) || turnRight(a,b,currentPlayerColor,currentOpponentPlayerColor) || 
        turnUpRight(a,b,currentPlayerColor,currentOpponentPlayerColor) || turnRightDown(a,b,currentPlayerColor,currentOpponentPlayerColor) || 
        turnLeftDown(a,b,currentPlayerColor,currentOpponentPlayerColor) || turnUpLeft(a,b,currentPlayerColor,currentOpponentPlayerColor)){
            return true;
        }else{return false;}
    }

    /**
    * 上をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //上方向に相手のコマをひっくり返す
    public boolean turnUp(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor) {
        int targetY = a-1;

        //盤の外なら終了
        if(targetY < 0) {
            return false;
        }
        

        //現在のプレイヤーではないコマでないandマスが空ではないならループし続ける
        while(board[targetY][b] != currentPlayerColor && board[targetY][b] != 0){

            //次のマスへ
            targetY--;

            //盤の外なら終了
            if(targetY < 0){
                break;
            }

            //もし自分のコマならば
            if(board[targetY][b] == currentPlayerColor) {
                for(a = a-1; a > targetY; a--){
                    board[a][b] = currentPlayerColor; 
                }
                return true;
            }
        }
        return false;
    }

    /**
    * 下をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //下方向に相手のコマをひっくり返す
    public boolean turnDown(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor){
        //次のマスへ
        int targetY = a+1;

        //盤の外なら終了
        if(targetY > 8){
            return false;
        }

        //現在のプレイヤーではないコマでないandマスが空ではないならループし続ける
        while (board[targetY][b] != currentPlayerColor && board[targetY][b] != 0) {
            
            //次のマスへ
            targetY++;

            //盤の外なら終了
            if(targetY > 8){
                break;
            }

            //もし自分のコマならば
            if(board[targetY][b] == currentPlayerColor) {
                for(a = a+1; a < targetY; a++){
                    board[a][b] = currentPlayerColor; 
                }
                return true;
            }
        }
        return false;
    }

    /**
    * 右をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //右方向に相手のコマをひっくり返す
    public boolean turnRight(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor){
        //コマを進める
        int targetX = b+1;

        //壁の外なら
        if(targetX > 8){
            return false;
        }

        //現在のプレイヤーではないコマでないandマスが空ではないならループし続ける
        while(board[a][targetX] != currentPlayerColor && board[a][targetX] != 0){
            //次のマスへ
            targetX++;

            //壁の外なら終了
            if(targetX > 8){
                break;
            }

            //もし自分のコマならば
            if(board[a][targetX] == currentPlayerColor){
                for(b = b+1; b < targetX; b++){
                    board[a][b] = currentPlayerColor;
                }
                return true;
            }
        }

        return false;
    }

    /**
    * 左をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //左方向に相手のコマをひっくり返す
    public boolean turnLeft(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor){
        //コマを進める
        int targetX = b-1;

        //壁の外なら
        if(targetX < 0){
            return false;
        }

        //現在のプレイヤーではないコマでないandマスが空ではないならループし続ける
        while(board[a][targetX] != currentPlayerColor && board[a][targetX] != 0){
            //コマを進める
            targetX--;

            //壁の外なら
            if(targetX < 0){
                break;
            }

            //もし自分のコマならば
            if(board[a][targetX] == currentPlayerColor){
                for(b = b-1; b > targetX; b--){
                    board[a][b] = currentPlayerColor;
                }
                return true;
            }
        }

        return false;
    }

    /**
    * 斜め右上をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    //右上斜め方向に相手のコマをひっくり返す
    public boolean turnUpRight(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor){
        //コマを進める
        int targetX = b+1;
        int targetY = a-1;

        //壁の外なら
        if(targetX > 8 || targetY < 0){
            return false;
        }

        while(board[targetY][targetX] != currentPlayerColor && board[targetY][targetX] != 0){
            //コマを進める
            targetX++;
            targetY--;

            //壁の外なら
            if(targetX > 8 || targetY < 0){
                break;
            }

            //もし自分のコマならば
            //斜めの移動の仕方を考える
            if(board[targetY][targetX] == currentPlayerColor){
                for(a = a-1; a > targetY; a--){
                    b++;
                    board[a][b] = currentPlayerColor;
                }
                return true;
            }
        }

        return false;
    }

    /**
    * 斜め右上をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    public boolean turnRightDown(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor) {
        //コマを進める
        int targetX = b+1;
        int targetY = a+1;

        //壁の外なら
        if(targetX > 8 || targetY > 8){
            return false;
        }

        while(board[targetY][targetX] != currentPlayerColor && board[targetY][targetX] != 0){
            //コマを進める
            targetX++;
            targetY--;

            //壁の外なら
            if(targetX > 8 || targetY > 8){
                break;
            }

            //もし自分のコマならば
            if(board[targetY][targetX] == currentPlayerColor){
                for(a = a+1; a > targetY; a--){
                    b++;
                    board[a][b] = currentPlayerColor;
                }
                return true;
            }
        }

        return false;
    }

    /**
    * 斜め左下をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    public boolean turnLeftDown(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor){
        //コマを進める
        int targetX = b-1;
        int targetY = a+1;

        //壁の外なら
        if(targetX < 0 || targetY > 8){
            return false;
        }

        while (board[targetY][targetX] != currentPlayerColor && board[targetY][targetX] != 0) {
            //コマを進める
            targetX--;
            targetY++;

            //壁の外なら
            if(targetX < 0 || targetY > 8){
                break;
            }

            //もし自分のコマなら
            if(board[targetY][targetX] == currentPlayerColor){
                for(a = a+1; a < targetY; a++){
                    b--;
                    board[a][b] = currentPlayerColor;
                }
                return true;
            }
        }

        return false;
    }

    /**
    * 斜め左上をコマがひっくり返り返すか判断し、可能ならひっくり返してbooleanを返す。
    * @param a ボードのY座標
    * @param b ボードのX座標 
    * @param currentPlayerColor 現在のプレイヤーカラーを数字で管理
    * @param currentOpponentPlayerColor 現在のプレイヤーの相手の数字
    * @return boolean
    */

    public boolean turnUpLeft(int a, int b, int currentPlayerColor, int currentOpponentPlayerColor){
        //コマを進める
        int targetX = b-1;
        int targetY = a-1;

        //壁の外なら
        if(targetX < 0 || targetY < 0){
            return false;
        }

        while (board[targetY][targetX] != currentPlayerColor && board[targetY][targetX] != 0) {
            //コマを進める
            targetX--;
            targetY--;

            //壁の外なら
            if(targetX < 0 || targetY < 0){
                break;
            }

            //もし自分のコマなら
            if(board[targetY][targetX] == currentPlayerColor){
                for(a = a -1; a > targetY; a++){
                    b--;
                    board[a][b] = currentPlayerColor;
                }
                return true;
            }
        }

        return false;
    }
}
