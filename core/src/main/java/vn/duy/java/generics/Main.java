package vn.duy.java.generics;

record BaseballPlayer(String name, int position) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof BaseballPlayer baseballPlayer) {
            return baseballPlayer.name().equalsIgnoreCase(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name().hashCode();
    }
}
public class Main {
    public static void main(String[] args) {
        BaseballTeam team1 = new BaseballTeam("Team 1");
        BaseballTeam team2 = new BaseballTeam("Team 2");

        scoreResult(team1, 3, team2, 5);

        BaseballPlayer player1 = new BaseballPlayer("Duy", 1);
        BaseballPlayer player2 = new BaseballPlayer("Duy", 2);
        team1.addTeamMember(player1);
        team1.addTeamMember(player2);
        team1.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam team1, int t1Score, BaseballTeam team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
