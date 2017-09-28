import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DraftFile {
    int teamDrafting = 1;
    int gameDifficulty = 2840;

    //ObservableList<Player> players;
    ObservableList<Player> players = FXCollections.observableArrayList();

        public DraftFile() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("src\\PlayerDatabase.csv")));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] lineArray = line.split(",");
                    players.add(new Player(lineArray[0], Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]),  Double.parseDouble(lineArray[4]), Double.parseDouble(lineArray[5]), Double.parseDouble(lineArray[6]), Double.parseDouble(lineArray[7]), Double.parseDouble(lineArray[8]), Double.parseDouble(lineArray[9]), Double.parseDouble(lineArray[10]), Double.parseDouble(lineArray[11]), Double.parseDouble(lineArray[12]), Double.parseDouble(lineArray[13]), Double.parseDouble(lineArray[14]), Double.parseDouble(lineArray[15]), Double.parseDouble(lineArray[16]), Double.parseDouble(lineArray[17]), Double.parseDouble(lineArray[18]), Double.parseDouble(lineArray[19]), Double.parseDouble(lineArray[20]), Double.parseDouble(lineArray[21]), Double.parseDouble(lineArray[22]), Double.parseDouble(lineArray[23]), Double.parseDouble(lineArray[24]), Double.parseDouble(lineArray[25]), Double.parseDouble(lineArray[26]) ));
                }
            } catch (IOException ioException) {
                System.out.println("Error");
        }

    }

    public ObservableList<Player> getTableData(){
        return players;
    }
    public void changePick(){
        if (teamDrafting == 1){
            teamDrafting = 2;
        }
        else
            teamDrafting = 1;
    }

}
