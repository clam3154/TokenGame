public class TokenPass
{
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++)
        {
            board[i] = 1 + (int)(10 * Math.random());
        }
        currentPlayer = (int)(playerCount * Math.random());
    }

    public void distributeCurrentPlayerTokens()
    {
        if(board[currentPlayer] > 0)
        {
            int nextPlayer = currentPlayer+1;
            for(int token = board[currentPlayer]; token > 0; token--)
            {
                if(nextPlayer > (board.length-1))
                {
                    nextPlayer = 0;
                }
                board[nextPlayer] += 1;
                nextPlayer++;
            }
        }
    }

    public void nextPlayer()
    {
        currentPlayer++;
        if(currentPlayer > (board.length-1))
        {
            currentPlayer = 0;
        }
    }

    public void printBoard()
    {
        for(int i = 0; i < board.length; i++)
        {
            System.out.print("Player " + i + ": " + board[i] + " ");
        }
    }

    public int gameOver()
    {
        for(int i = 0; i < board.length; i++)
        {
            if(board[i] == 0)
            {
                return i;
            }
        }
        return -1;
    }
}
