
public class GameClock {
    private int period;
    private int min;
    private int sec;
    private int shotClock;
    private boolean timesUp;

    public int getMin(){
        return min;
    }
    public int getSec(){
        return sec;
    }


    public GameClock(){
        min = 12;
        sec = 0;
        timesUp = false;
        period = 1;
        shotClock = 24;
    }


    public boolean tick(){
        if (sec != 0){
            sec--;
            shotClock--;
        }
        else {
            if (min > 0) {
                min--;
                sec = 59;
            }
        }

        if (min == 0 && sec == 0){
            timesUp = true;
            return true;
        }
        else{
            timesUp = false;
            return false;
        }

    }

    public boolean isTimeUp (){
        if (timesUp == true)
            return true;
        else
            return false;
    }



    public void resetShotClock(){
        shotClock = GameConstants.SHOTCLOCK_RESET;
    }


    public int getPeriod(){
        return period;
    }

    public void setPeriod(){
        period++;
        if (period >= 1 && period <= 4) {
            min = 12;
            sec = 0;
            timesUp = false;
        }
        else {
            min = 5;
            sec = 0;
            timesUp = false;
        }
    }

    public String getTime(){
        String time = "";
        if (getMin() < 10){
            time = "0" + getMin();
        }
        else{
            time = "" + getMin();
        }
        if (getSec() < 10){
            time = time + ":0" + getSec();
        }
        else{
            time = time + ":" + getSec();
        }
        return time;
    }
    public int getShotClock(){
        return shotClock;
    }

}
