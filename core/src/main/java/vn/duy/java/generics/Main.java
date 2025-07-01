package vn.duy.java.generics;

interface Player {}
record BaseballPlayer(String name, int position) implements Player {
}

record SoccerPlayer(String name, int position) implements Player {
}

public class Main {
    public static void main(String[] args) {
        BaseballTeam baseballTeam1 = new BaseballTeam("Team 1");
        BaseballTeam baseballTeam2 = new BaseballTeam("Team 2");
        scoreResult(baseballTeam1, 3, baseballTeam2, 5);

        SoccerTeam soccerTeam1 = new SoccerTeam("Team 1");
        SoccerTeam soccerTeam2 = new SoccerTeam("Team 2");
        scoreResult(soccerTeam1, 3, soccerTeam2, 5);

        Team<SoccerPlayer> team1 = new Team<>("Team 1");
        Team<BaseballPlayer> team2 = new Team<>("Team 2");
        scoreResult(team1, 3, team2, 5);

        BaseballPlayer player1 = new BaseballPlayer("Duy", 1);
        BaseballPlayer player2 = new BaseballPlayer("Duy", 2);
        baseballTeam1.addTeamMember(player1);
        baseballTeam1.addTeamMember(player2);
        baseballTeam1.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam team1, int t1Score, BaseballTeam team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SoccerTeam team1, int t1Score, SoccerTeam team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1Score, Team team2, int t2Score) {
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
