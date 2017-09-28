/**
 * Created by Davorin on 6/15/2017.
 */
public class Player {
    //Instance variables
    String name;
    int games;
    int pos;
    double height;

    double effpg;
    double ppg;
    double reb;
    double orb;
    double drb;
    double apg;

    double fg;
    double fgm;
    double fga;
    double ft;
    double ftm;
    double fta;
    double twofg;
    double twofgm;
    double twofga;
    double threefg;
    double threefgm;
    double threefga;

    double tov;
    double pf;
    double mpg;
    double blk;
    double stl;

    int [] boxScore;
    String [] boxScoreString;

    boolean eligibileToPlay;




    //Getters and setters
    public String getName(){
        return name;
    }
    private void setName(String n){
        name = n;
    }

    public double getHeight(){
        return height;
    }



    public double getPpg(){
        return ppg;
    }
    private void setPpg(double p){
        ppg = p;
    }

    public double getRpg(){
        return reb;
    }
    private void setRpg(double r){
        reb = r;
    }

    public double getApg(){
        return apg;
    }
    private void setApg(double a){
        apg = a;
    }

    public double getTovpg(){
        return tov;
    }
    private void setTovpg(double t){
        tov = t;
    }

    public double getMpg(){
        return mpg;
    }
    private void setMpg(double m){mpg = m;}

    public double getBlk(){
        return blk;
    }
    private void setBlk(double b){
        blk = b;
    }

    public double getEffpg(){
        return effpg;
    }
    private void setEffpg(double e){
        effpg = e;
    }

    public double getFg(){
        return fg;
    }
    public double getFga(){
        return fga;
    }
    public double getTwofga(){
        return twofga;
    }
    public double getThreefga(){
        return threefga;
    }
    public double getThreefg(){return threefg;};
    public double getTwofg(){return twofg;};
    public double getFt(){return ft;};
    public double getFta(){return fta;};
    public double getPf(){return pf;};
    public double getOffReb(){return orb;}
    public double getDefReb(){return drb;}
    public double getStl(){return stl;}
    public void setEligibilityToPlay(boolean e){
        eligibileToPlay = e;
    }



    public void updateBoxScore(int stat, int value){
        boxScore[stat] = boxScore[stat] + value;
        updateBoxScoreString();
    }
    public void updateBoxScoreString(){
            for (int i = 1; i <= 14; i++){
                boxScoreString[i] = Integer.toString(boxScore[i]);
            }

    }




    public Player(String name, double height, int pos, int games, double mpg, double fg, double fgm, double fga, double twofg, double twofgm, double twofga, double threefg, double threefgm,
                  double threefga, double ft, double ftm, double fta, double orb, double drb, double rpg, double apg, double stl, double blk, double tov, double pf, double ppg, double effpg){
                this.name = name;
                this.height = height;

                this.pos = pos;
                this.games = games;
                this.mpg = mpg;
                this.fg = fg;
                this.fgm = fgm;
                this.fga = fga;
                this.twofg = twofg;
                this.twofgm = twofgm;
                this.twofga = twofga;
                this.threefg = threefg;
                this.threefgm = threefgm;
                this.threefga = threefga;
                this.ft = ft;
                this.ftm = ftm;
                this.fta = fta;
                this.orb = orb;
                this.drb = drb;
                this.reb = rpg;
                this.apg = apg;
                this.stl = stl;
                this.blk = blk;
                this.tov = tov;
                this.pf = pf;
                this.ppg = ppg;
                this.effpg = effpg;
                boxScoreString = new String[15];
                boxScore = new int[15];
                boxScoreString[0] = getName();
                for (int i = 1; i <= 14; i++){
                    boxScoreString[i] = "0";
                    boxScore[i] = 0;
                }

                eligibileToPlay = true;
    }


    @Override
    public String toString(){
        String toReturn = getName() + " " + getHeight();

        return toReturn;
    }


    public String getBoxScoreStat(int stat){
        return boxScoreString[stat];
    }
    public int getBoxScoreStatInt(int stat){
         return boxScore[stat];

    }

}
