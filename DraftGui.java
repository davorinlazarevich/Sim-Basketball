import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

import java.util.concurrent.ThreadLocalRandom;

public class DraftGui {

    Team [] teamsInGame;
    boolean userVsCpu;
    int gameDifficulty;
    DraftFile draftFile;
    Scene draftScene;
    Button goToSetupLineupGui;

    public DraftGui(){
        goToSetupLineupGui = new Button("Start");
    }

    public void initializeDraftGui(Team [] tig, DraftFile df ){

        teamsInGame = tig;
        draftFile = df;
        userVsCpu = true;

        final BorderPane layoutBorderPane = new BorderPane();
        Label gameTitleLabel = new Label("Draft Players");
        Label homeDraftedPlayersLabel = new Label();
        Label visitorDraftedPlayersLabel = new Label();
        TableView draftBoardTableView = new TableView<>();

        draftBoardTableView.setMinWidth(250);
        draftBoardTableView.setMaxWidth(250);

        TableColumn<Player, String> nameColumn = new TableColumn<>("NAME");
        TableColumn<Player, Integer> ppgColumn = new TableColumn<>("PPG");
        TableColumn<Player, String> rpgColumn = new TableColumn<>("RPG");
        TableColumn<Player, String> apgColumn = new TableColumn<>("APG");
        TableColumn actionCol = new TableColumn( "Action" );

        nameColumn.setMinWidth(150);
        ppgColumn.setMinWidth(70);
        rpgColumn.setMinWidth(70);
        apgColumn.setMinWidth(70);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ppgColumn.setCellValueFactory(new PropertyValueFactory<>("ppg"));
        rpgColumn.setCellValueFactory(new PropertyValueFactory<>("rpg"));
        apgColumn.setCellValueFactory(new PropertyValueFactory<>("apg"));

        actionCol.setCellValueFactory( new PropertyValueFactory<>( "DUMMY" ) );

        Callback<TableColumn<Player, String>, TableCell<Player, String>> cellFactory =
                new Callback<TableColumn<Player, String>, TableCell<Player, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Player, String> param )
                    {
                        final TableCell<Player, String> cell = new TableCell<Player, String>()
                        {
                            final Button btn = new Button( "Draft" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                    {
                                        if (teamsInGame[1].getRosterSize() < 12 || teamsInGame[2].getRosterSize() < 12 ) {

                                            if (userVsCpu){
                                                Player player = getTableView().getItems().get(getIndex());
                                                teamsInGame[1].addPlayer(player);
                                                getTableView().getItems().remove(player);
                                                homeDraftedPlayersLabel.setText(teamsInGame[1].toString());



                                                int randomNum = ThreadLocalRandom.current().nextInt(0, draftFile.gameDifficulty);
                                                Player player2 = getTableView().getItems().get(randomNum);
                                                teamsInGame[2].addPlayer(player2);
                                                getTableView().getItems().remove(player2);
                                                visitorDraftedPlayersLabel.setText(teamsInGame[2].toString());
                                            }

                                            else {
                                                Player player = getTableView().getItems().get(getIndex());
                                                teamsInGame[draftFile.teamDrafting].addPlayer(player);
                                                getTableView().getItems().remove(player);
                                                if (draftFile.teamDrafting == 1){
                                                    homeDraftedPlayersLabel.setText(teamsInGame[draftFile.teamDrafting].toString());
                                                }
                                                else{
                                                    visitorDraftedPlayersLabel.setText(teamsInGame[draftFile.teamDrafting].toString());
                                                }

                                                draftFile.changePick();
                                            }

                                        }



                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };

        actionCol.setCellFactory( cellFactory );
        draftBoardTableView.setItems(draftFile.getTableData());
        draftBoardTableView.getColumns().addAll(nameColumn, ppgColumn, rpgColumn, apgColumn, actionCol);

        gameTitleLabel.setFont(Font.font("Arial",FontWeight.BOLD, 30));
        gameTitleLabel.setPadding(new Insets(20, 0, 20, 0));
        goToSetupLineupGui.setPadding(new Insets(30, 20, 30, 20));
        goToSetupLineupGui.setStyle("-fx-font-size: 15pt;");
        homeDraftedPlayersLabel.setPadding(new Insets(10, 10, 10, 10));
        homeDraftedPlayersLabel.setFont(Font.font("Arial",FontWeight.BOLD, 16));
        homeDraftedPlayersLabel.setMaxWidth(220);
        homeDraftedPlayersLabel.setMinWidth(220);
        visitorDraftedPlayersLabel.setPadding(new Insets(10, 10, 10, 20));
        visitorDraftedPlayersLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        visitorDraftedPlayersLabel.setMaxWidth(220);
        visitorDraftedPlayersLabel.setMinWidth(220);
        draftBoardTableView.setMinWidth(440);
        draftBoardTableView.setMaxWidth(840);

        layoutBorderPane.setTop(gameTitleLabel);
        layoutBorderPane.setCenter(draftBoardTableView);
        layoutBorderPane.setLeft(homeDraftedPlayersLabel);
        layoutBorderPane.setRight(visitorDraftedPlayersLabel);
        layoutBorderPane.setBottom(goToSetupLineupGui);
        layoutBorderPane.setAlignment(gameTitleLabel, Pos.CENTER);
        layoutBorderPane.setAlignment(homeDraftedPlayersLabel,Pos.TOP_CENTER);
        layoutBorderPane.setAlignment(visitorDraftedPlayersLabel,Pos.TOP_CENTER);
        layoutBorderPane.setAlignment(goToSetupLineupGui,Pos.CENTER);

        draftScene = new Scene(layoutBorderPane ,900, 900);

        layoutBorderPane.setId("pane");
        draftScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }

    public void setUserVScpuDifficulty(boolean uVc, int gd){
        userVsCpu = uVc;
        gameDifficulty = gd;
    }
}
