public class OX {


    private char[][] board = new char[4][4];
    private int winX = 0 , winO = 0 , draw = 0;
    private String currentPlayer="X";
    private int turnCount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;
    public void start(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0){
                    if(j==0){
                        board[i][j] = '-';
                        continue;
                    }
                    board[i][j] = ((j - 1)+"").charAt(0);
                    continue;
                }
                if(j==0 && i!=0){
                    board[i][j] = ((i - 1)+"").charAt(0);
                }else{
                    board[i][j] = '-';
                }
            }
        }
        turnCount=0;
    }

    public String getCurrentPlayer(){
        return currentPlayer;
    }


    public void displayBoard(){
        for(int i = 0 ;i<board.length;i++){
            for(int j = 0;j < board[1].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void switchPlayer(){
        if(currentPlayer.equals("X")){
            currentPlayer="O";
        }else{
            currentPlayer="X";
        }


    }

    public boolean put(int x,int y) {
        board[x + 1][y + 1] = currentPlayer.charAt(0);
        System.out.print(board[x + 1][y + 1] + "\n");
        turnCount++;
        if(checkWin(x,y)==true){
            if(currentPlayer.equals("x"))
                scoreX++;
            else
                scoreO++;
        }
        return true;


    }

    public String get(int col, int row) {
        if(col > 2 || col < 0 || row > 2 || row < 0){
            return null;
        }
        return ""+board[row+1][col+1]+"";
    }

    public boolean checkWin(int col, int row) {
        /* checkColWin */
        boolean colWin = true;
        for(int i = 0; i < 3; i++) {
            if(!(board[i+1][col+1]==currentPlayer.charAt(0))){
                colWin = false;
            }

        }

        if(colWin){
            return true;
        }
        /* checkRowWin */
        boolean rowWin = true;
        for(int i = 0; i < 3; i++) {
            if(!(board[row+1][i+1]==currentPlayer.charAt(0))){
                rowWin = false;
            }
        }
        if(rowWin){
            return true;
        }
        /* checkEsWin */
        boolean esWin = true;
        for(int i = 0; i < 3; i++) {
            if(!(board[i+1][i+1]==currentPlayer.charAt(0))){
                esWin = false;
            }
        }
        if(esWin){
            return true;
        }
        /* checkSsWin */
        boolean ssWin = true;
        for(int i = 0; i < 3; i++) {
            if(!(board[i+1][3-i]==currentPlayer.charAt(0))){
                ssWin = false;
            }
        }
        if(ssWin){
            return true;
        }

        return false;
    }

    public String getTableString() {
        String result = "";
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                result = result + board[i][j];
            }
            result = result + "\n";
        }
        return result;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }

    public boolean isDraw() {
        if(turnCount < 9){
            return false;
        }
        scoreDraw++;
        return true;
    }
}