public class EventProbability {
    Team [] teamsInGame;
    GameBall gameBall;


    public EventProbability(Team [] tig, GameBall gb){
        teamsInGame = tig;
        gameBall = gb;

    }



    public int twoOrThreeAttempted(){
        double total2s = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getTwofga();
        double total3s = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getThreefga();
        double twoOrThree = Math.random() * (total2s + total3s);
        if(twoOrThree <= total2s){
            return 2;
        }
        else {
            return 3;
        }
    }

    public int whoShotTheBall(int twoOrThree){
        if (twoOrThree == 2) {
            double total2pa = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getTwofga();
            double shotAttemptedBy = Math.random() * total2pa;

            if (shotAttemptedBy <= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() && shotAttemptedBy >= 0) {
                return GameConstants.POINT_GUARD;
            } else if (shotAttemptedBy <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga()) && shotAttemptedBy >= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga()) {
                return GameConstants.SHOOTING_GUARD;
            } else if ((shotAttemptedBy <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTwofga()) && shotAttemptedBy >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga()))) {
                return GameConstants.SMALL_FORWARD;
            } else if ((shotAttemptedBy <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getTwofga()) && shotAttemptedBy >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTwofga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTwofga()))) {
                return GameConstants.POWER_FORWARD;
            } else {
                return GameConstants.CENTER;
            }
        }
        else {
            double total3pa = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getThreefga();
            double shotAttemptedBy = Math.random() * total3pa;

            if (shotAttemptedBy <= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() && shotAttemptedBy >= 0) {
                return GameConstants.POINT_GUARD;
            } else if (shotAttemptedBy <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga()) && shotAttemptedBy >= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga()) {
                return GameConstants.SHOOTING_GUARD;
            } else if ((shotAttemptedBy <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getThreefga()) && shotAttemptedBy >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga()))) {
                return GameConstants.SMALL_FORWARD;
            } else if ((shotAttemptedBy <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getThreefga()) && shotAttemptedBy >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getThreefga() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getThreefga()))) {
                return GameConstants.POWER_FORWARD;
            } else  {
                return GameConstants.CENTER;
            }
        }
    }

    public boolean didShotGoIn(int ftTwoOrThree, int player){
        double didShotGoIn = Math.random() * 100;
        if (ftTwoOrThree == 2){
            if (didShotGoIn < ((teamsInGame[gameBall.getPoss()].roster[player].getTwofg() / teamsInGame[gameBall.getPoss()].roster[player].getTwofga()) * 100)){
                return true;
            }
            else
                return false;
        }
        else if (ftTwoOrThree == 3){
            if (didShotGoIn < ((teamsInGame[gameBall.getPoss()].roster[player].getThreefg() / teamsInGame[gameBall.getPoss()].roster[player].getThreefga()) * 100)){
                return true;
            }
            else
                return false;
        }
        else {
            if (didShotGoIn < ((teamsInGame[gameBall.getPoss()].roster[player].getFt() / teamsInGame[gameBall.getPoss()].roster[player].getFta()) * 100)){
                return true;
            }
            else
                return false;
        }

    }

    public boolean isFouledOnShot(int player){
        double isFouledOnShot = Math.random() * 100;
        if (isFouledOnShot < (teamsInGame[gameBall.getPoss()].roster[player].getFta() * 3)){
            return true;
        }
        else
            return false;
    }
    public boolean isBlockedShot(){
        double totalBlks = teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.CENTER].getBlk();
        double isBlockedShot = Math.random() * 100;
        if (isBlockedShot < (totalBlks * 2)){
            return true;
        }
        else
            return false;
    }
    public boolean isAssisted(int playerWhoScored){
        double totalAst = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getApg() - teamsInGame[gameBall.getPoss()].roster[playerWhoScored].getApg();
        double isAssisted = Math.random() * 100;
        if (isAssisted < (totalAst * 8)){
            return true;
        }
        else
            return false;
    }

    //Calculates who assisted the ball, but excludes the player who scored, because you can't assist yourself.
    public int whoAssisted(int playerWhoScored) {
        int j = 1;
        double totalAst = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getApg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getApg() - teamsInGame[gameBall.getPoss()].roster[playerWhoScored].getApg();
        double assistedBy = Math.random() * totalAst;
        int toReturn = 1;
        double[] astMinusShooter = new double[5];
        for (int i = 1; i <= 5; i++) {
            if (i != playerWhoScored) {
                astMinusShooter[j] = teamsInGame[gameBall.getPoss()].roster[i].getApg();
                j++;
            }
        }
        if (assistedBy <= astMinusShooter[1] && assistedBy >= 0) {
            toReturn = GameConstants.POINT_GUARD;
        } else if ((assistedBy <= (astMinusShooter[GameConstants.POINT_GUARD] + astMinusShooter[GameConstants.SHOOTING_GUARD]) && assistedBy >= astMinusShooter[GameConstants.POINT_GUARD])){
            toReturn = GameConstants.SHOOTING_GUARD;
        } else if (((assistedBy <= (astMinusShooter[1] + astMinusShooter[GameConstants.SHOOTING_GUARD] + astMinusShooter[GameConstants.SMALL_FORWARD]) && assistedBy >= astMinusShooter[1] + astMinusShooter[2]))) {
            toReturn = GameConstants.SMALL_FORWARD;
        } else {
            toReturn = GameConstants.POWER_FORWARD;
        }
        if (playerWhoScored <= toReturn){
            toReturn++;
        }
        return toReturn;
    }


    public int whoFouled(){
        double totalFouls = teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.CENTER].getPf();
        double fouledBy = Math.random() * totalFouls;

        if (fouledBy <= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() && fouledBy >= 0) {
            return GameConstants.POINT_GUARD;
        } else if (fouledBy <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getPf()) && fouledBy >= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf()) {
            return GameConstants.SHOOTING_GUARD;
        } else if ((fouledBy <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getPf()) && fouledBy >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getPf()))) {
            return GameConstants.SMALL_FORWARD;
        } else if ((fouledBy <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getPf()) && fouledBy >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getPf() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getPf()))) {
            return GameConstants.POWER_FORWARD;
        } else {
            return GameConstants.CENTER;
        }
    }

    public int whoToSubOut(int team){
        int whoToSub = 1;
        int whoToSubTotal = 0;
        int possibleSub;

        int subOption = (int)(Math.random()*3);

        if (subOption <=1){
            for (int i = 1; i <= 5; i++){
                possibleSub = teamsInGame[team].roster[i].boxScore[1];
                if (possibleSub > whoToSubTotal){
                    whoToSub = i;
                    whoToSubTotal = possibleSub;
                }
            }
        }
        else{
            whoToSubTotal = 99;
            for (int i = 1; i <= 5; i++){
                possibleSub = (int)Math.round(teamsInGame[team].roster[i].getEffpg());
                if (possibleSub < whoToSubTotal){
                    whoToSub = i;
                    whoToSubTotal = possibleSub;
                }
            }
        }


        return whoToSub;
    }

    public int whoToSubIn(int team){
        int whoToSubIn = 6;
        int possibleSub;
        int subOption = (int)(Math.random()*8);

        int subOptionType = (int)(Math.random()*3);

        if (subOptionType <=1){
            int whoToSubTotal = -15;  //Because there are players with negative efficency per game. Rare but exists.
            for (int i = 6; i <= 12; i++){
                if (teamsInGame[team].roster[i].eligibileToPlay == true){
                    possibleSub = (int)Math.round(teamsInGame[team].roster[i].getEffpg());
                    if (possibleSub > whoToSubTotal){
                        subOption = i;
                        whoToSubTotal = possibleSub;

                    }
                }
            }
            return subOption;
        }
        else{
            if (teamsInGame[team].roster[subOption+5].eligibileToPlay == true){
                return subOption+5;
            }
            else{
                subOption = (int)(Math.random()*8);
                while(teamsInGame[team].roster[whoToSubIn+5].eligibileToPlay != true){
                    subOption = (int)(Math.random()*8);
                }
                return subOption+5;
            }
        }
    }

    public int whoBlockedShot(){
        double totalblks = teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.CENTER].getBlk();
        double blockedBy = Math.random() * totalblks;

        if (blockedBy <= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() && blockedBy >= 0) {
            return GameConstants.POINT_GUARD;
        } else if (blockedBy <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk()) && blockedBy >= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk()) {
            return GameConstants.SHOOTING_GUARD;
        } else if ((blockedBy <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getBlk()) && blockedBy >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk()))) {
            return GameConstants.SMALL_FORWARD;
        } else if ((blockedBy <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getBlk()) && blockedBy >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getBlk() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getBlk()))) {
            return GameConstants.POWER_FORWARD;
        } else {
            return GameConstants.CENTER;
        }
    }

    public int whatTeamRebounded(){
        double totalOffReb = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getOffReb();
        double totalDefReb = teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.CENTER].getDefReb();
        double whatTeamGotReb = Math.random() * (totalDefReb + totalOffReb);
        if (whatTeamGotReb < totalDefReb){
            return GameConstants.HOME_TEAM;
        }
        else
            return GameConstants.VISITOR_TEAM;
    }

    public int whoRebounded(int offOrDef){
        if (offOrDef == GameConstants.HOME_TEAM) {
            double totalDefReb = teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.CENTER].getDefReb();
            double whoGotTheReb = Math.random() * totalDefReb;
            if (whoGotTheReb <= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() && whoGotTheReb >= 0) {
                return GameConstants.POINT_GUARD;
            } else if (whoGotTheReb <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb()) && whoGotTheReb >= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb()) {
                return GameConstants.SHOOTING_GUARD;
            } else if ((whoGotTheReb <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getDefReb()) && whoGotTheReb >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb()))) {
                return GameConstants.SMALL_FORWARD;
            } else if ((whoGotTheReb <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getDefReb()) && whoGotTheReb >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getDefReb() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getDefReb()))) {
                return GameConstants.POWER_FORWARD;
            } else {
                return GameConstants.CENTER;
            }
        }
        else {
            double totalOffReb = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getOffReb();
            double whoGotTheReb = Math.random() * totalOffReb;
            if (whoGotTheReb <= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() && whoGotTheReb >= 0) {
                return GameConstants.POINT_GUARD;
            } else if (whoGotTheReb <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb()) && whoGotTheReb >= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb()) {
                return GameConstants.SHOOTING_GUARD;
            } else if ((whoGotTheReb <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getOffReb()) && whoGotTheReb >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb()))) {
                return GameConstants.SMALL_FORWARD;
            } else if ((whoGotTheReb <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getOffReb()) && whoGotTheReb >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getOffReb() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getOffReb()))) {
                return GameConstants.POWER_FORWARD;
            } else {
                return GameConstants.CENTER;
            }
        }
    }

    public int whoTurnedItOver(){
        double totalTurnovers = teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.CENTER].getTovpg();
        double whoGotTheTo = Math.random() * totalTurnovers;
        if (whoGotTheTo <= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() && whoGotTheTo >= 0) {
            return GameConstants.POINT_GUARD;
        } else if (whoGotTheTo <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTovpg()) && whoGotTheTo >= teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg()) {
            return GameConstants.SHOOTING_GUARD;
        } else if ((whoGotTheTo <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTovpg()) && whoGotTheTo >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTovpg()))) {
            return GameConstants.SMALL_FORWARD;
        } else if ((whoGotTheTo <= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.POWER_FORWARD].getTovpg()) && whoGotTheTo >= (teamsInGame[gameBall.getPoss()].roster[GameConstants.POINT_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SHOOTING_GUARD].getTovpg() + teamsInGame[gameBall.getPoss()].roster[GameConstants.SMALL_FORWARD].getTovpg()))) {
            return GameConstants.POWER_FORWARD;
        } else {
            return GameConstants.CENTER;
        }
    }

    public int whoStoleTheBall(){
        double totalSteals = teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.CENTER].getStl();
        double whoStoleIt = Math.random() * totalSteals;
        if (whoStoleIt <= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() && whoStoleIt >= 0) {
            return GameConstants.POINT_GUARD;
        } else if (whoStoleIt <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getStl()) && whoStoleIt >= teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl()) {
            return GameConstants.SHOOTING_GUARD;
        } else if ((whoStoleIt <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getStl()) && whoStoleIt >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getStl()))) {
            return GameConstants.SMALL_FORWARD;
        } else if ((whoStoleIt <= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POWER_FORWARD].getStl()) && whoStoleIt >= (teamsInGame[gameBall.getDefPoss()].roster[GameConstants.POINT_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SHOOTING_GUARD].getStl() + teamsInGame[gameBall.getDefPoss()].roster[GameConstants.SMALL_FORWARD].getStl()))) {
            return GameConstants.POWER_FORWARD;
        } else {
            return GameConstants.CENTER;
        }
    }

    public int whoWonJumpBall(){
        if (teamsInGame[GameConstants.HOME_TEAM].roster[GameConstants.CENTER].getHeight() > teamsInGame[GameConstants.VISITOR_TEAM].roster[GameConstants.CENTER].getHeight()){
            double heightComputation = ((teamsInGame[GameConstants.HOME_TEAM].roster[GameConstants.CENTER].getHeight() - teamsInGame[GameConstants.VISITOR_TEAM].roster[GameConstants.CENTER].getHeight()) * 5 ) + 50;
            double whoWonJump = Math.random() * 100;
            if(heightComputation < whoWonJump){
                return GameConstants.HOME_TEAM;
            }
            else
                return GameConstants.VISITOR_TEAM;
        }
        else{
            double heightComputation = ((teamsInGame[GameConstants.VISITOR_TEAM].roster[GameConstants.CENTER].getHeight() - teamsInGame[GameConstants.HOME_TEAM].roster[GameConstants.CENTER].getHeight()) * 5 ) + 50;
            double whoWonJump = Math.random() * 100;
            if(heightComputation < whoWonJump){
                return GameConstants.VISITOR_TEAM;
            }
            else
                return GameConstants.HOME_TEAM;
        }
        }

}
