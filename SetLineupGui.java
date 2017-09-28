import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SetLineupGui {
    Team [] teamsInGame;
    boolean userVScpu;

    Label gameTitleLabel;
    Text t1;
    Text t2;
    Text t3;
    Text t4;
    Text t5;
    Text t6;
    Text t7;
    Text t8;
    Text t9;
    Text t10;
    Text t11;
    Text t12;
    Text tt1;
    Text tt2;
    Text tt3;
    Text tt4;
    Text tt5;
    Text tt6;
    Text tt7;
    Text tt8;
    Text tt9;
    Text tt10;
    Text tt11;
    Text tt12;
    Text startersText;
    Text benchText;
    Text startersText2;
    Text benchText2;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button buttonb1;
    Button buttonb2;
    Button buttonb3;
    Button buttonb4;
    Button buttonb5;
    Button buttonb6;
    Button buttonb7;
    Button buttonb8;
    Button buttonb9;
    Button buttonb10;
    Button buttonb11;
    Button buttonb12;
    Button startGameButton2;
    GridPane lineupGridPane;
    GridPane lineupGridPane2;
    Scene scene;

    int subIndex;
    int subIndex2;
    Image image;
    ImageView imageView12;
    Stage stage;

    public SetLineupGui() {
        startGameButton2 = new Button("Start");



    }
    public void updateLineupCells(){
        t1.setText(teamsInGame[1].roster[1].getName());
        t2.setText(teamsInGame[1].roster[2].getName());
        t3.setText(teamsInGame[1].roster[3].getName());
        t4.setText(teamsInGame[1].roster[4].getName());
        t5.setText(teamsInGame[1].roster[5].getName());
        t6.setText(teamsInGame[1].roster[6].getName());
        t7.setText(teamsInGame[1].roster[7].getName());
        t8.setText(teamsInGame[1].roster[8].getName());
        t9.setText(teamsInGame[1].roster[9].getName());
        t10.setText(teamsInGame[1].roster[10].getName());
        t11.setText(teamsInGame[1].roster[11].getName());
        t12.setText(teamsInGame[1].roster[12].getName());

        tt1.setText(teamsInGame[2].roster[1].getName());
        tt2.setText(teamsInGame[2].roster[2].getName());
        tt3.setText(teamsInGame[2].roster[3].getName());
        tt4.setText(teamsInGame[2].roster[4].getName());
        tt5.setText(teamsInGame[2].roster[5].getName());
        tt6.setText(teamsInGame[2].roster[6].getName());
        tt7.setText(teamsInGame[2].roster[7].getName());
        tt8.setText(teamsInGame[2].roster[8].getName());
        tt9.setText(teamsInGame[2].roster[9].getName());
        tt10.setText(teamsInGame[2].roster[10].getName());
        tt11.setText(teamsInGame[2].roster[11].getName());
        tt12.setText(teamsInGame[2].roster[12].getName());
    }
    public void setupTeams(Team [] tig, boolean uVcpu){
        teamsInGame = tig;
        userVScpu = uVcpu;
        stage = new Stage();




        subIndex = 0;
        subIndex2 = 0;

        gameTitleLabel = new Label("Edit Lineup");
        BorderPane layoutBorderPane = new BorderPane();
        Image image = new Image("collage1.jpg");
        ImageView imageView1 = new ImageView(image);

        t1 = new Text(teamsInGame[1].roster[1].getName());
        t2 = new Text(teamsInGame[1].roster[2].getName());
        t3 = new Text(teamsInGame[1].roster[3].getName());
        t4 = new Text(teamsInGame[1].roster[4].getName());
        t5 = new Text(teamsInGame[1].roster[5].getName());
        t6 = new Text(teamsInGame[1].roster[6].getName());
        t7 = new Text(teamsInGame[1].roster[7].getName());
        t8 = new Text(teamsInGame[1].roster[8].getName());
        t9 = new Text(teamsInGame[1].roster[9].getName());
        t10 = new Text(teamsInGame[1].roster[10].getName());
        t11 = new Text(teamsInGame[1].roster[11].getName());
        t12 = new Text(teamsInGame[1].roster[12].getName());
        startersText = new Text("Starting Lineup");
        benchText = new Text("Bench");

        button1 = new Button("Move");
        button2 = new Button("Move");
        button3 = new Button("Move");
        button4 = new Button("Move");
        button5 = new Button("Move");
        button6 = new Button("Move");
        button7 = new Button("Move");
        button8 = new Button("Move");
        button9 = new Button("Move");
        button10 = new Button("Move");
        button11 = new Button("Move");
        button12 = new Button("Move");

        tt1 = new Text(teamsInGame[2].roster[1].getName());
        tt2 = new Text(teamsInGame[2].roster[2].getName());
        tt3 = new Text(teamsInGame[2].roster[3].getName());
        tt4 = new Text(teamsInGame[2].roster[4].getName());
        tt5 = new Text(teamsInGame[2].roster[5].getName());
        tt6 = new Text(teamsInGame[2].roster[6].getName());
        tt7 = new Text(teamsInGame[2].roster[7].getName());
        tt8 = new Text(teamsInGame[2].roster[8].getName());
        tt9 = new Text(teamsInGame[2].roster[9].getName());
        tt10 = new Text(teamsInGame[2].roster[10].getName());
        tt11 = new Text(teamsInGame[2].roster[11].getName());
        tt12 = new Text(teamsInGame[2].roster[12].getName());
        startersText2 = new Text("Starting Lineup");
        benchText2 = new Text("Bench");

        buttonb1 = new Button("Move");
        buttonb2 = new Button("Move");
        buttonb3 = new Button("Move");
        buttonb4 = new Button("Move");
        buttonb5 = new Button("Move");
        buttonb6 = new Button("Move");
        buttonb7 = new Button("Move");
        buttonb8 = new Button("Move");
        buttonb9 = new Button("Move");
        buttonb10 = new Button("Move");
        buttonb11 = new Button("Move");
        buttonb12 = new Button("Move");

        button1.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 1;
                button1.setVisible(false);
            }

            else {
                teamsInGame[1].substitute(subIndex, 1);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button2.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 2;
                button2.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 2);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button3.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 3;
                button3.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 3);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });
        button4.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 4;
                button4.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 4);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });
        button5.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 5;
                button5.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 5);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button6.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 6;
                button6.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 6);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button7.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 7;
                button7.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 7);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button8.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 8;
                button8.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 8);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button9.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 9;
                button9.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 9);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button10.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 10;
                button10.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 10);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button11.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 11;
                button11.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 11);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });

        button12.setOnAction((ActionEvent event) ->
        {
            if (subIndex == 0){
                subIndex = 12;
                button12.setVisible(false);
            }
            else {
                teamsInGame[1].substitute(subIndex, 12);
                updateLineupCells();
                subIndex = 0;
                homeButtonVisible();
            }
        });



        buttonb1.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 1;
                buttonb1.setVisible(false);
            }

            else {
                teamsInGame[2].substitute(subIndex2, 1);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb2.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 2;
                buttonb2.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 2);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb3.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 3;
                buttonb3.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 3);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });
        buttonb4.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 4;
                buttonb4.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 4);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });
        buttonb5.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 5;
                buttonb5.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 5);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb6.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 6;
                buttonb6.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 6);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb7.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 7;
                buttonb7.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 7);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb8.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 8;
                buttonb8.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 8);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb9.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 9;
                buttonb9.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 9);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb10.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 10;
                buttonb10.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 10);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb11.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 11;
                buttonb11.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 11);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });

        buttonb12.setOnAction((ActionEvent event) ->
        {
            if (subIndex2 == 0){
                subIndex2 = 12;
                buttonb12.setVisible(false);
            }
            else {
                teamsInGame[2].substitute(subIndex2, 12);
                updateLineupCells();
                subIndex2 = 0;
                visitorButtonVisible();
            }
        });


        lineupGridPane = new GridPane();
        lineupGridPane.setVgap(10);
        lineupGridPane.setHgap(10);
        lineupGridPane.setPadding(new Insets(0, 5, 0, 105));

        lineupGridPane2 = new GridPane();
        lineupGridPane2.setVgap(10);
        lineupGridPane2.setHgap(10);
        lineupGridPane2.setPadding(new Insets(0, 5, 0, 5));



        lineupGridPane.add(t1, 1, 1, 1, 1);
        lineupGridPane.add(t2, 1, 2, 1, 1);
        lineupGridPane.add(t3, 1, 3, 1, 1);
        lineupGridPane.add(t4, 1, 4, 1, 1);
        lineupGridPane.add(t5, 1, 5, 1, 1);
        lineupGridPane.add(t6, 1, 8, 1, 1);
        lineupGridPane.add(t7, 1, 9, 1, 1);
        lineupGridPane.add(t8, 1, 10, 1, 1);
        lineupGridPane.add(t9, 1, 11, 1, 1);
        lineupGridPane.add(t10, 1, 12, 1, 1);
        lineupGridPane.add(t11, 1, 13, 1, 1);
        lineupGridPane.add(t12, 1, 14, 1, 1);
        lineupGridPane.add(startersText, 1, 0, 1, 1);
        lineupGridPane.add(benchText, 1, 7, 1, 1);

        lineupGridPane.add(button1, 3, 1, 1, 1);
        lineupGridPane.add(button2, 3, 2, 1, 1);
        lineupGridPane.add(button3, 3, 3, 1, 1);
        lineupGridPane.add(button4, 3, 4, 1, 1);
        lineupGridPane.add(button5, 3, 5, 1, 1);
        lineupGridPane.add(button6, 3, 8, 1, 1);
        lineupGridPane.add(button7, 3, 9, 1, 1);
        lineupGridPane.add(button8, 3, 10, 1, 1);
        lineupGridPane.add(button9, 3, 11, 1, 1);
        lineupGridPane.add(button10, 3, 12, 1, 1);
        lineupGridPane.add(button11, 3, 13, 1, 1);
        lineupGridPane.add(button12, 3, 14, 1, 1);


        lineupGridPane2.add(tt1, 1, 1, 1, 1);
        lineupGridPane2.add(tt2, 1, 2, 1, 1);
        lineupGridPane2.add(tt3, 1, 3, 1, 1);
        lineupGridPane2.add(tt4, 1, 4, 1, 1);
        lineupGridPane2.add(tt5, 1, 5, 1, 1);
        lineupGridPane2.add(tt6, 1, 8, 1, 1);
        lineupGridPane2.add(tt7, 1, 9, 1, 1);
        lineupGridPane2.add(tt8, 1, 10, 1, 1);
        lineupGridPane2.add(tt9, 1, 11, 1, 1);
        lineupGridPane2.add(tt10, 1, 12, 1, 1);
        lineupGridPane2.add(tt11, 1, 13, 1, 1);
        lineupGridPane2.add(tt12, 1, 14, 1, 1);
        lineupGridPane2.add(startersText2, 1, 0, 1, 1);
        lineupGridPane2.add(benchText2, 1, 7, 1, 1);

        lineupGridPane2.add(buttonb1, 3, 1, 1, 1);
        lineupGridPane2.add(buttonb2, 3, 2, 1, 1);
        lineupGridPane2.add(buttonb3, 3, 3, 1, 1);
        lineupGridPane2.add(buttonb4, 3, 4, 1, 1);
        lineupGridPane2.add(buttonb5, 3, 5, 1, 1);
        lineupGridPane2.add(buttonb6, 3, 8, 1, 1);
        lineupGridPane2.add(buttonb7, 3, 9, 1, 1);
        lineupGridPane2.add(buttonb8, 3, 10, 1, 1);
        lineupGridPane2.add(buttonb9, 3, 11, 1, 1);
        lineupGridPane2.add(buttonb10, 3, 12, 1, 1);
        lineupGridPane2.add(buttonb11, 3, 13, 1, 1);
        lineupGridPane2.add(buttonb12, 3, 14, 1, 1);

        gameTitleLabel.setFont(Font.font("Arial",FontWeight.BOLD, 30));
        gameTitleLabel.setPadding(new Insets(20, 0, 20, 0));
        startGameButton2.setPadding(new Insets(30, 20, 30, 20));
        startGameButton2.setStyle("-fx-font-size: 15pt;");
        startersText.setFont(Font.font("Arial", FontWeight.BOLD,12));
        benchText.setFont(Font.font("Arial", FontWeight.BOLD,12));
        startersText2.setFont(Font.font("Arial", FontWeight.BOLD,12));
        benchText2.setFont(Font.font("Arial",FontWeight.BOLD, 12));

        t1.setFont(Font.font("Arial", FontWeight.BOLD,18));
        t2.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        t3.setFont(Font.font("Arial", FontWeight.BOLD,18));
        t4.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        t5.setFont(Font.font("Arial", FontWeight.BOLD,18));
        t6.setFont(Font.font("Arial", FontWeight.BOLD,18));
        t7.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        t8.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        t9.setFont(Font.font("Arial", FontWeight.BOLD,18));
        t10.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        t11.setFont(Font.font("Arial", FontWeight.BOLD,18));
        t12.setFont(Font.font("Arial", FontWeight.BOLD,18));

        tt1.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt2.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt3.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt4.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt5.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt6.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt7.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        tt8.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt9.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt10.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        tt11.setFont(Font.font("Arial", FontWeight.BOLD,18));
        tt12.setFont(Font.font("Arial", FontWeight.BOLD,18));


        StackPane bottomStackPane = new StackPane();
        StackPane topStackPane = new StackPane();
        ImageView[] bottomPictures1 = new ImageView[10];
        ImageView[] topPictures1 = new ImageView[10];


        Image image1 = new Image("p1.jpg", 0, 230, true, false);
        Image image2 = new Image("p2.jpg",0, 230, true, false);
        Image image3 = new Image("p3.jpg",0, 230, true, false);
        Image image4 = new Image("p4.jpg",0, 230, true, false);
        Image image5 = new Image("p5.jpg", 0, 230, true, false);
        Image image6 = new Image("p6.jpg",0, 230, true, false);
        Image image7 = new Image("p7.jpg",0, 230, true, false);
        Image image8 = new Image("p8.jpg",0, 230, true, false);
        Image image9 = new Image("p9.jpg",0, 230, true, false);
        Image image10 = new Image("p10.jpg",0, 230, true, false);
        bottomPictures1[0] = new ImageView(image1);
        bottomPictures1[1] = new ImageView(image2);
        bottomPictures1[2] = new ImageView(image3);
        bottomPictures1[3] = new ImageView(image4);
        bottomPictures1[4] = new ImageView(image5);
        bottomPictures1[5] = new ImageView(image6);
        bottomPictures1[6] = new ImageView(image7);
        bottomPictures1[7] = new ImageView(image8);
        bottomPictures1[8] = new ImageView(image9);
        bottomPictures1[9] = new ImageView(image10);

        Image image11 = new Image("p11.jpg", 0, 230, true, false);
        Image image12 = new Image("p12.jpg",0, 230, true, false);
        Image image13 = new Image("p13.jpg",0, 230, true, false);
        Image image14 = new Image("p14.jpg",0, 230, true, false);
        Image image15 = new Image("p15.jpg", 0, 230, true, false);
        Image image16 = new Image("p16.jpg",0, 230, true, false);
        Image image17 = new Image("p17.jpg",0, 230, true, false);
        Image image18 = new Image("p18.jpg",0, 230, true, false);
        Image image19 = new Image("p19.jpg",0, 230, true, false);
        Image image20 = new Image("p20.jpg",0, 230, true, false);
        topPictures1[0] = new ImageView(image11);
        topPictures1[1] = new ImageView(image12);
        topPictures1[2] = new ImageView(image13);
        topPictures1[3] = new ImageView(image14);
        topPictures1[4] = new ImageView(image15);
        topPictures1[5] = new ImageView(image16);
        topPictures1[6] = new ImageView(image17);
        topPictures1[7] = new ImageView(image18);
        topPictures1[8] = new ImageView(image19);
        topPictures1[9] = new ImageView(image20);


        SequentialTransition slideshow = new SequentialTransition();
        SequentialTransition slideshow2 = new SequentialTransition();

        for (ImageView pic : bottomPictures1) {

            SequentialTransition sequentialTransition = new SequentialTransition();

            FadeTransition in = fadeTransition(pic, 0.0, 1.0, 3000);
            PauseTransition current = new PauseTransition(Duration.millis(3000));
            FadeTransition out = fadeTransition(pic, 1.0, 0.0, 3000);

            sequentialTransition.getChildren().addAll(in, current, out);
            pic.setOpacity(0);
            bottomStackPane.getChildren().add(pic);
            slideshow.getChildren().add(sequentialTransition);
        }

        for (ImageView pic : topPictures1) {

            SequentialTransition sequentialTransition2 = new SequentialTransition();

            FadeTransition in2 = fadeTransition(pic, 0.0, 1.0, 3000);
            PauseTransition current2 = new PauseTransition(Duration.millis(3000));
            FadeTransition out2 = fadeTransition(pic, 1.0, 0.0, 3000);

            sequentialTransition2.getChildren().addAll(in2, current2, out2);
            pic.setOpacity(0);
            topStackPane.getChildren().add(pic);
            slideshow2.getChildren().add(sequentialTransition2);
        }
        slideshow.play();
        slideshow2.play();

        HBox hbox1 = new HBox(lineupGridPane,lineupGridPane2);
        hbox1.setSpacing(150);

        HBox hbox2 = new HBox(topStackPane, bottomStackPane);

        VBox vBox = new VBox(hbox1,hbox2);
        vBox.setSpacing(20);

        layoutBorderPane.setTop(gameTitleLabel);
        layoutBorderPane.setCenter(vBox);


        layoutBorderPane.setBottom(startGameButton2);
        layoutBorderPane.setAlignment(gameTitleLabel, Pos.CENTER);
        layoutBorderPane.setAlignment(lineupGridPane, Pos.CENTER);
        layoutBorderPane.setAlignment(lineupGridPane2, Pos.CENTER);
        layoutBorderPane.setAlignment(hbox2, Pos.CENTER);
        layoutBorderPane.setAlignment(hbox1, Pos.CENTER);
        layoutBorderPane.setAlignment(vBox, Pos.CENTER);

        layoutBorderPane.setAlignment(startGameButton2, Pos.CENTER);



        scene = new Scene(layoutBorderPane, 900, 900);
        layoutBorderPane.setId("pane");
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }

    public void homeButtonVisible(){
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        button5.setVisible(true);
        button6.setVisible(true);
        button7.setVisible(true);
        button8.setVisible(true);
        button9.setVisible(true);
        button10.setVisible(true);
        button11.setVisible(true);
        button12.setVisible(true);
    }
    public void visitorButtonVisible(){
        buttonb1.setVisible(true);
        buttonb2.setVisible(true);
        buttonb3.setVisible(true);
        buttonb4.setVisible(true);
        buttonb5.setVisible(true);
        buttonb6.setVisible(true);
        buttonb7.setVisible(true);
        buttonb8.setVisible(true);
        buttonb9.setVisible(true);
        buttonb10.setVisible(true);
        buttonb11.setVisible(true);
        buttonb12.setVisible(true);
    }

    public void visitorButtonInvisible(){
        buttonb1.setVisible(false);
        buttonb2.setVisible(false);
        buttonb3.setVisible(false);
        buttonb4.setVisible(false);
        buttonb5.setVisible(false);
        buttonb6.setVisible(false);
        buttonb7.setVisible(false);
        buttonb8.setVisible(false);
        buttonb9.setVisible(false);
        buttonb10.setVisible(false);
        buttonb11.setVisible(false);
        buttonb12.setVisible(false);
    }

    public FadeTransition fadeTransition(ImageView iv, double begining, double end, int length) {

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(length), iv);
        fadeTransition.setFromValue(begining);
        fadeTransition.setToValue(end);

        return fadeTransition;

    }

}

