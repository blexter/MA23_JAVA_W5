public class Player {
    private String name;
    private int wins  = 0;
    private String marker;

    public Player(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public int getWins() {
        return wins;
    }

    public void setWins() {
        this.wins++;
    }
}


