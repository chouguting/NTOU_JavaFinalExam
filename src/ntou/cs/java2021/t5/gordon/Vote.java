package ntou.cs.java2021.t5.gordon;

public class Vote {
    String state; // 投票州
    int votes; // 選舉人票數
    String winner; // 獲選者
    String source;

    public Vote() {
        this.state = "";
        this.votes = 0;
        this.winner = "";
    }

    public Vote(String state, int votes, String winner, String source) {
        this.state = state;
        this.votes = votes;
        this.winner = winner;
        this.source = source;
    }

    public Vote(Vote v) {
        this.state = v.getState();
        this.votes = v.getVotes();
        this.winner = v.getWinner();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String toString() {
        return String.format("%-15s%-6d%-8s\n", state, votes, winner);
    }

    public String getSource() {
        return source;
    }
}
