package com.example.gameproj;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.sql.*;

public class HelloApplication extends Application {
    DialogueClass bunnydialogue = new DialogueClass("dialogues/bunnydialog.txt");
    DialogueClass duckdialogue = new DialogueClass("dialogues/duckdialog.txt");
    DialogueClass letter1dialogue = new DialogueClass("dialogues/letter1dialog.txt");
    DialogueClass letter2dialogue = new DialogueClass("dialogues/letter2dialog.txt");
    DialogueClass letter3dialogue = new DialogueClass("dialogues/letter3dialog.txt");
    DialogueClass skulldialogue = new DialogueClass("dialogues/skulldialog.txt");
    DialogueClass gundialogue = new DialogueClass("dialogues/gundialog.txt");
    DialogueClass bookdialogue = new DialogueClass("dialogues/bookdialog.txt");
    DialogueClass momdialogue = new DialogueClass("dialogues/momdialog.txt");
    DialogueClass bff1dialogue = new DialogueClass("dialogues/bffs1dialog.txt");
    DialogueClass bff2dialogue = new DialogueClass("dialogues/bffs2dialog.txt");
    DialogueClass bff3dialogue = new DialogueClass("dialogues/bffs3dialog.txt");
    DialogueClass dan1dialogue = new DialogueClass("dialogues/dan1dialog.txt");
    DialogueClass dan2dialogue = new DialogueClass("dialogues/dan2dialog.txt");
    DialogueClass dan3dialogue = new DialogueClass("dialogues/dan3dialog.txt");
    DialogueClass dan4dialogue = new DialogueClass("dialogues/dan4dialog.txt");
    DialogueClass ghost1dialogue = new DialogueClass("dialogues/ghostdialog1.txt");
    DialogueClass ghost2dialogue = new DialogueClass("dialogues/ghostdialog2.txt");
    DialogueClass bff4dialogue = new DialogueClass("dialogues/bffs4dialog.txt");
    DialogueClass bff5dialogue = new DialogueClass("dialogues/bffs5dialog.txt");

    boolean isLeftKeyPressed = false;
    boolean isRightKeyPressed = false;

    Connection connection;
    ImageView dan;
    Scene gamescene;
    Pane root = new Pane();
    BorderPane pane = new BorderPane();
    Image danIdleImage;
    Image danWalkLeftImage;
    Image danWalkRightImage;

    ImageView danDead;

    Timeline bulletAnimation = new Timeline();

    Image duckImg;
    Image scaryskullImage;

    ImageView duck;

    ImageView bunny;
    ImageView letter1;
    ImageView letter2;
    ImageView letter3;
    ImageView gun;
    ImageView skull;
    ImageView monsterIdle;
    ImageView monsterRun;
    ImageView bullet;
    ImageView bloodeffect;
    ImageView healthbarFull;
    ImageView healthbar70;
    ImageView healthbar60;
    ImageView healthbar20;
    ImageView healthbar10;
    ImageView ghostappears;
    ImageView ghostidle;
    ImageView book;
    ImageView diary;
    ImageView diarypage1;
    ImageView diarypage2;


    Image bunnyImg;
    Background danHomeRoomBG;
    Background danBathroomBG;
    Background danBedroomBG;
    Background hauntedHouseBG;
    BackgroundImage scaryskullbackground;
    Background danFrontYardBG;
    Background blackBG;
    Background hhmainRoomBG;
    Background hhHallwayBG;
    Background ghostbehinddoorBG;
    Background hhHallway2BG;
    Background doorDungeonBG;
    Background hhHallway3BG;
    Background tunnelBG;
    Background ghostTunnelBG;
    Background dungeon1BG;
    Background dungeon2BG;
    Background dungeon3BG;
    Background dungeonHallwayBG;
    Background monsterawakeBG;
    Background scaryskullBG;
    Background gameoverBG;
    Background dungeonHallway2BG;
    Background dungeonHallway3BG;
    Background dungeon4BG;
    Background dungeon5BG;
    Background throneroomBG;
    Background streetBG;
    Background rainywindowBG;


    Timeline collisionDetection;

    Label bigDialogueLabel;

    int bigDialogueHeight;
    Label mission1Lbl = new Label("MISSION 1");

    Label pressXTostartLbl = new Label("Press X to Start");

    private ImageView mom;

    private ImageView trevor;

    private ImageView julian;

    boolean onMission = false;

    boolean bunnyitemRetrieved = false;
    boolean duckitemRetrieved = false;
    boolean letter1Retrieved = false;
    boolean letter2Retrieved = false;
    boolean letter3Retrieved = false;
    boolean skullRetrieved = false;
    boolean gunRetrieved = false;
    boolean bookRetrieved = false;


    Label itemFoundLbl;

    int mom2currentDialogueIndex = 0;

    boolean momInteraction = false;
    boolean mom2Interaction = false;
    boolean bff1Interaction = false;
    boolean bff2Interaction = false;
    boolean bff3Interaction = false;
    boolean bff4Interaction = false;
    boolean bff5Interaction = false;

    boolean ghost1Interaction = false;
    boolean ghost2Interaction = false;

    MediaPlayer doorSE;
    Scene blackscene;

    Timeline timeline;
    Timeline timeline2;
    Timeline timeline3;

    Timeline timeline4;
    Timeline timeline5;
    Timeline timeline6;
    Timeline timeline7;
    Timeline timeline8;
    Timeline timeline9;


    Button startbtn = new Button("Start");

    BorderPane mainmenupane = new BorderPane();

    Scene mainmenuScene = new Scene(mainmenupane,400,300);

    int missionsCompleted = 0;
    TextField txtUserName;

    boolean danSelfTalk1 = false;
    boolean danSelfTalk2 = false;
    boolean danSelfTalk3 = false;
    boolean danSelfTalk4 = false;
    boolean onMission2 = false;
    boolean onMission3 = false;
    boolean onMission4 = false;
    boolean isMonsterAwake = false;
    boolean isMonsterKilled = false;
    boolean isDanKilled = false;
    boolean isgameRestart = false;
    boolean isGameEnd = false;
    Pane pane2 = new Pane();
    Scene jumpscareScene = new Scene(pane2,400,300);

    Pane pane3 = new Pane();

    Scene gameOverScene = new Scene(pane3, 600, 500);
    boolean isGameOver = false;
    boolean isGameStart = false;
    int attackCount = 0;
    Label pressLeftandRightLbl;
    Button playbtn = new Button("Play");
    Pane welcomelayout = new Pane();
    Scene welcomeScene = new Scene(welcomelayout,400,300);

    BorderPane dashboardpane = new BorderPane();
    Scene dashboardScene = new Scene(dashboardpane, 400, 300);



    StackPane prologuePane = new StackPane();
    Scene prologueScene = new Scene(prologuePane, 600, 500);
    Button opendiarybtn = new Button("Open Diary");
    Button goBackToPagebtn = new Button("<-");
    Button goToNextPagebtn = new Button("->");
    Button continuebtn = new Button("Continue");



    @Override
    public void start(Stage stage) throws IOException, URISyntaxException, SQLException {


        // ITEMS
        bunny = new ImageViewBuilder("/mrbunny.png", 40, 60).build();
        duck = new ImageViewBuilder("/duck.png", 40, 30).build();
        letter1 = new ImageViewBuilder("/letter.png", 40, 30).build();
        letter2 = new ImageViewBuilder("/letter.png", 40, 30).build();
        letter3 = new ImageViewBuilder("/letter.png", 40, 30).build();
        skull = new ImageViewBuilder("/skull.png", 40, 30).build();
        gun = new ImageViewBuilder("/gun.png", 40, 30).build();
        book = new ImageViewBuilder("/book.png", 40, 30).build();


        // CHARACTERS AND ASSETS
        dan = new ImageViewBuilder("/danidle.png", 80, 150).build();
        julian = new ImageViewBuilder("/julian.png", 80, 150).build();
        trevor = new ImageViewBuilder("/trevor.png", 80, 130).build();
        mom = new ImageViewBuilder("/mom.png", 80, 150).build();
        monsterIdle = new ImageViewBuilder("/monsteridle.gif", 200, 170).build();
        monsterRun = new ImageViewBuilder("/monsterrun.gif", 200, 200).build();
        bloodeffect = new ImageViewBuilder("/bloodeffect.gif", 100, 90).build();
        healthbarFull = new ImageViewBuilder("/healthbarFull.png", 80, 30).build();
        healthbar70 = new ImageViewBuilder("/healthbar70.png", 80, 30).build();
        healthbar60 = new ImageViewBuilder("/healthbar60.png", 80, 30).build();
        healthbar20 = new ImageViewBuilder("/healthbar20.png", 80, 30).build();
        healthbar10 = new ImageViewBuilder("/healthbar10.png", 80, 30).build();
        ghostidle = new ImageViewBuilder("/ghost-idle.gif", 600, 600).build();
        bullet = new ImageViewBuilder("/bullet.png", 15, 20).build();
        danDead = new ImageViewBuilder("/dandead.png", 150, 80).build();
        ghostappears = new ImageViewBuilder("/ghost-appears.gif", 600, 600).build();
        diary = new ImageViewBuilder("/diary.png", 100, 80).build();
        diarypage1 = new ImageViewBuilder("/page1.PNG", 500, 400).build();
        diarypage2 = new ImageViewBuilder("/page2.PNG", 500, 400).build();


        streetBG = createBackground("/rainy.gif");
        rainywindowBG = createBackground("/rainywindow.gif");




        startbtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );



        playbtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );
        goBackToPagebtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );
        goToNextPagebtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );
        opendiarybtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );
        continuebtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );

        playbtn.setPrefWidth(60);
        playbtn.setPrefHeight(30);


        startbtn.setPrefWidth(80);
        startbtn.setPrefHeight(30);



        Label lblGameTitle = new Label("The House " +
                "\n   on " +
                "\n    13th Street");
        lblGameTitle.setFont(Font.font("Broadway", FontWeight.BOLD, 27));
        lblGameTitle.setTextFill(Color.BLANCHEDALMOND);


        playbtn.setLayoutX((welcomelayout.getWidth() - playbtn.getWidth()) / 2.3);
        playbtn.setLayoutY((welcomelayout.getHeight() - playbtn.getHeight()) / 1.5);
        lblGameTitle.setLayoutX((welcomelayout.getWidth() - lblGameTitle.getWidth()) / 20.3);
        lblGameTitle.setLayoutY((welcomelayout.getHeight() - lblGameTitle.getHeight()) / 7);

        welcomelayout.setBackground(streetBG);
        welcomelayout.getChildren().addAll(playbtn, lblGameTitle);



        playbtn.setOnAction(event -> {
            stage.setScene(dashboardScene);

        });



        MediaPlayer mission1ST = new MediaPlayer(new Media(getClass().getResource("/mission1ST.mp3").toURI().toString()));

        MediaPlayer mission2ST = new MediaPlayer(new Media(getClass().getResource("/mission2ST.mp3").toURI().toString()));

        MediaPlayer creepySE1 = new MediaPlayer(new Media(getClass().getResource("/creepysceneSE.mp3").toURI().toString()));

        MediaPlayer monsterSE1 = new MediaPlayer(new Media(getClass().getResource("/monsterSE1.mp3").toURI().toString()));

        MediaPlayer monsterSE2 = new MediaPlayer(new Media(getClass().getResource("/monsterSE2.mp3").toURI().toString()));

        MediaPlayer battleST = new MediaPlayer(new Media(getClass().getResource("/battleST.mp3").toURI().toString()));

        MediaPlayer mission3ST = new MediaPlayer(new Media(getClass().getResource("/mission3ST.mp3").toURI().toString()));

        MediaPlayer mission4ST = new MediaPlayer(new Media(getClass().getResource("/mission4ST.mp3").toURI().toString()));

        VBox mainmenubox = new VBox();

        StackPane endlayout = new StackPane();
        Scene endscene = new Scene(endlayout, 400, 300);


        Text credits = new Text("The House On 13th Street\n      Created by Sky9x");
        credits.setFont(Font.font(20));
        credits.setFill(Color.WHITE);
        StackPane.setAlignment(credits, Pos.CENTER);

        // Create the message text
        Text message = new Text("If you or someone you know " +
                "\n is going through a hard time due to" +
                "\n losing a loved one, " +
                "\n you are not alone.");
        message.setFont(Font.font(16));
        message.setFill(Color.WHITE);
        message.setVisible(false); // Initially invisible
        StackPane.setAlignment(message, Pos.CENTER);


        pressLeftandRightLbl = new Label("Press Left and Right\n    Keys to Move");








        VBox vb3 = new VBox();
        vb3.getChildren().addAll(startbtn); //updated
        vb3.setSpacing(20);
        vb3.setAlignment(Pos.CENTER);
        dashboardpane.setCenter(vb3);
        dashboardpane.setBackground(streetBG);



        prologuePane.setBackground(rainywindowBG);
        VBox vb4 = new VBox();
        vb4.getChildren().addAll(diary, opendiarybtn);
        prologuePane.getChildren().add(vb4);
        vb4.setSpacing(6);
        vb4.setAlignment(Pos.CENTER);

        startbtn.setOnAction(event -> {
            stage.setScene(prologueScene);

            opendiarybtn.setOnAction(e ->{
                vb4.getChildren().removeAll(diary, opendiarybtn);
                vb4.getChildren().addAll(diarypage1, goToNextPagebtn);
            });

            goToNextPagebtn.setOnAction(e->{
                vb4.getChildren().removeAll(diarypage1, goToNextPagebtn);
                vb4.getChildren().addAll(diarypage2, goBackToPagebtn, continuebtn);
            });

            goBackToPagebtn.setOnAction(e->{
                vb4.getChildren().removeAll(diarypage2,goBackToPagebtn,continuebtn);
                vb4.getChildren().addAll(diarypage1, goToNextPagebtn);
            });



        });

        continuebtn.setOnAction(event -> {

                    // Start the mission
                    mission1ST.play();
                    root.getChildren().add(bunny);
                    bunny.layoutXProperty().bind(root.widthProperty().subtract(bunny.fitWidthProperty()));
                    bunny.layoutYProperty().bind(root.heightProperty().subtract(bunny.fitHeightProperty()));
                    mission1ST.setVolume(0.2);
                    stage.setScene(gamescene);

        });



        blackscene = new Scene(pane,400,300);

        Label lblGameOver = new Label("Game Over");
        lblGameOver.setFont(Font.font("Algerian", FontWeight.BOLD, 60));
        lblGameOver.setTextFill(Color.DARKRED);

        Button restartbtn = new Button("Try again?");

        pane3.getChildren().addAll(lblGameOver, restartbtn);

        MediaPlayer hhmusic1 = new MediaPlayer(new Media(getClass().getResource("/hhmusic1.mp3").toURI().toString()));

        MediaPlayer footstepsdoorSE = new MediaPlayer(new Media(getClass().getResource("/footstepsdoorSE.mp3").toURI().toString()));



        if(pane.getBackground() == blackBG && !bff2Interaction && !onMission4 &&!mom2Interaction){
            timeline = new Timeline(
                    new KeyFrame(Duration.seconds(3), event -> {

                        hhmusic1.play();
                        hhmusic1.setVolume(0.2);

                        trevor.setX((root.getWidth() - trevor.getFitWidth()) / 7);
                        trevor.setY(root.getHeight() - trevor.getFitHeight());
                        julian.setX((root.getWidth() - julian.getFitWidth()) / 4);
                        julian.setY(root.getHeight() - julian.getFitHeight());

                        pane.setBackground(danBedroomBG); //changing
                        root.setBackground(hauntedHouseBG);
                        stage.setScene(gamescene);
                    })
            );



        }


        if(pane.getBackground() == blackBG && !bff3Interaction && !onMission4 && !mom2Interaction){
            timeline2 = new Timeline(
                    new KeyFrame(Duration.seconds(4), event -> {

                        hhmusic1.play();
                        //footstepsdoorSE.setVolume(0.4);
                        dan.setX((root.getWidth() - dan.getFitWidth()) / 25);
                        dan.setY(root.getHeight() - dan.getFitHeight());



                        root.setBackground(hhmainRoomBG);
                        stage.setScene(gamescene);
                    })
            );

        }

        if(pane.getBackground() == ghostbehinddoorBG){
            timeline3 = new Timeline(
                    new KeyFrame(Duration.seconds(4), event -> {

                        mission2ST.play();
                        mission2ST.setVolume(0.3);
                        //footstepsdoorSE.setVolume(0.4);
                        dan.setX((root.getWidth() - dan.getFitWidth()) / 7);
                        dan.setY(root.getHeight() - dan.getFitHeight());
                        mission1Lbl.setText("MISSION 2");
                        mission1Lbl.setTextFill(Color.CRIMSON);
                        onMission2 = true;
                        root.getChildren().addAll(mission1Lbl,pressXTostartLbl);
                        pane.setBackground(blackBG);
                        root.setBackground(doorDungeonBG);
                        stage.setScene(gamescene);
                        onMission = false;
                    })
            );

        }

        if (pane2.getBackground() == ghostTunnelBG) {
            timeline4 = new Timeline(
                    new KeyFrame(Duration.seconds(4), event -> {
                        // Actions for the first keyframe
                        // footstepsdoorSE.setVolume(0.4);
                        dan.setX((root.getWidth() - dan.getFitWidth()) / 7);
                        dan.setY(root.getHeight() - dan.getFitHeight());
                        pane2.setBackground(blackBG);
                    }),
                    new KeyFrame(Duration.seconds(8), event -> {
                        // Actions for the second keyframe after 4 seconds
                        root.setBackground(dungeon1BG);
                        root.getChildren().add(skull);
                        skull.setX((root.getWidth() - skull.getFitWidth()) /2);
                        skull.setY(root.getHeight() - skull.getFitHeight());

                        stage.setScene(gamescene);
                    })
            );
        }

        if (pane2.getBackground() == monsterawakeBG) {
            timeline5 = new Timeline(
                    new KeyFrame(Duration.seconds(1), event -> {
                        monsterSE1.play();
                        monsterSE1.setVolume(0.2);
                        pane2.setBackground(scaryskullBG);

                    }),

                    new KeyFrame(Duration.seconds(2), event -> {

                        scaryskullImage = new Image("/zoomedinSkull.jpg");

                        scaryskullbackground = new BackgroundImage(
                                scaryskullImage,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
                        );

                        scaryskullBG = new Background(scaryskullbackground);

                       pane2.setBackground(scaryskullBG);
                    }),
                new KeyFrame(Duration.seconds(4), event -> {

                    // Actions for the second keyframe after 4 seconds
                    root.setBackground(dungeonHallwayBG);
                    stage.setScene(gamescene);
                    isMonsterAwake = true;
                })
            );
        }


            timeline7 = new Timeline(
                    new KeyFrame(Duration.seconds(4), event -> {

                        root.getChildren().remove(ghostidle);
                       root.setBackground(blackBG);
                        stage.setScene(gamescene);
                        bigDialogueLabel.setText("(Press S to Interact)");
                        bigDialogueLabel.setVisible(true);


                    })
            );



            timeline8 = new Timeline(
                    new KeyFrame(Duration.seconds(3), event -> {

                        mission4ST.play();

                        trevor.setX((root.getWidth() - trevor.getFitWidth()) / 7);
                        trevor.setY(root.getHeight() - trevor.getFitHeight());
                        julian.setX((root.getWidth() - julian.getFitWidth()) / 4);
                        julian.setY(root.getHeight() - julian.getFitHeight());

                        root.setBackground(hauntedHouseBG);
                        stage.setScene(gamescene);
                    })
            );

        timeline9 = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> {

                   root.getChildren().removeAll(trevor,julian,dan);
                   root.getChildren().add(ghostidle);
                   ghostidle.setX((root.getWidth() - ghostidle.getFitWidth()) + 180);
                   ghostidle.setY(root.getHeight() - ghostidle.getFitHeight() +100);

                    root.setBackground(hauntedHouseBG);
                    stage.setScene(gamescene);

                }),
                new KeyFrame(Duration.seconds(4), event -> {

                    endlayout.setBackground(blackBG);
                    endlayout.getChildren().addAll(credits, message);
                    credits.setVisible(true);
                    message.setVisible(false);
                    stage.setScene(endscene);




                }),
                new KeyFrame(Duration.seconds(7), event -> {

                    credits.setVisible(false);
                    message.setVisible(true);
                    isGameEnd = true;

                }),
                new KeyFrame(Duration.seconds(11), event -> {

                    timeline9.stop();
                    missionsCompleted = 4;


                    stage.close();

                })
                );



        MediaPlayer itemSE = new MediaPlayer(new Media(getClass().getResource("/itemSE.mp3").toURI().toString()));
        itemSE.setVolume(0.8);

        MediaPlayer dialogSE = new MediaPlayer(new Media(getClass().getResource("/dialogSE.mp3").toURI().toString()));
        //dialogSE.setVolume(0.8);

        doorSE = new MediaPlayer(new Media(getClass().getResource("/doorSE.mp3").toURI().toString()));


        List<String> mom2Dialogues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("dialogues/momdialog2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                mom2Dialogues.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BACKGROUNDS
        danBedroomBG = createBackground("/dan bedroom 2.png");
        danBathroomBG = createBackground("/bathroom2.jpg");
        danHomeRoomBG = createBackground("/homeroom.jpg");
        danFrontYardBG = createBackground("/danhome3.jpg");
        hauntedHouseBG = createBackground("/hauntedhouse.jpg");
        blackBG = createBackground("/blackscreen.png");
        hhmainRoomBG = createBackground("/hhMainRoom.jpg");
        hhHallwayBG = createBackground("/hhHallway.jpg");
        ghostbehinddoorBG = createBackground("/ghostbehinddoor.jpg");
        hhHallway2BG = createBackground("/hhHallway2.jpg");
        hhHallway3BG = createBackground("/hhHallway3.jpg");
        doorDungeonBG = createBackground("/doorDungeon.png");
        tunnelBG = createBackground("/tunnel.jpg");
        ghostTunnelBG = createBackground("/creature in the dark.png");
        dungeon1BG = createBackground("/dungeonbg1.png");
        dungeon2BG = createBackground("/dungeonbg2.jpg");
        dungeon3BG = createBackground("/dungeonbg3.jpg");
        dungeonHallwayBG = createBackground("/dungeonHallway.jpeg");
        monsterawakeBG = createBackground("/scaryghostawaken.gif");
        scaryskullBG = createBackground("/scaryghost3.jpg");
        gameoverBG = createBackground("/gameover.gif");
        dungeonHallway2BG = createBackground("/dungeonHallway2.gif");
        dungeon4BG = createBackground("/dungeon4.jpg");
        dungeonHallway3BG = createBackground("/dungeonhallway3.jpg");
        dungeon5BG = createBackground("/dungeon5.gif");
        throneroomBG = createBackground("/throneroom.jpg");

        root.setBackground(danBedroomBG);

        danIdleImage = new Image(Objects.requireNonNull(getClass().getResource("/danidle.png")).toExternalForm());
        danWalkLeftImage = new Image(Objects.requireNonNull(getClass().getResource("/danwalk.png")).toExternalForm());
        danWalkRightImage = new Image(Objects.requireNonNull(getClass().getResource("/danwalkright.png")).toExternalForm());


        root.getChildren().add(dan);

        gamescene = new Scene(root, 400, 300);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.BLACK);



        itemFoundLbl = new Label("Item Found!");
        itemFoundLbl.setFont(Font.font("Cascadia Code", FontWeight.BOLD, 20));
        itemFoundLbl.setTextFill(Color.GOLDENROD);
        itemFoundLbl.setAlignment(Pos.CENTER);
        itemFoundLbl.setEffect(dropShadow);
        itemFoundLbl.setVisible(false);
        root.getChildren().add(itemFoundLbl);


        bigDialogueLabel = new Label("(Press S to interact)");
        bigDialogueLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12)); // Decrease font size
        bigDialogueLabel.setTextFill(Color.WHITE);
        bigDialogueLabel.setAlignment(Pos.CENTER_LEFT); // Align text to the left
        bigDialogueLabel.setWrapText(true); // Allow text wrapping
        bigDialogueLabel.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.7), CornerRadii.EMPTY, Insets.EMPTY))); // Set semi-transparent background
        bigDialogueLabel.setPadding(new Insets(20));
        bigDialogueLabel.setVisible(false);
        bigDialogueHeight = 60;
        bigDialogueLabel.setPrefHeight(bigDialogueHeight);

        mission1Lbl.setFont(Font.font("Algerian", FontWeight.BOLD, 50)); // Set font size, weight, and type
        mission1Lbl.setTextFill(Color.MISTYROSE);

        pressXTostartLbl.setFont(Font.font("Cascadia Code", FontWeight.BOLD, 20)); // Set font size, weight, and type
        pressXTostartLbl.setTextFill(Color.BROWN);

        root.getChildren().add(mission1Lbl);
        mission1Lbl.setOpacity(0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(4), mission1Lbl);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);


        fadeIn.play();
        mission1Lbl.setEffect(dropShadow);

        root.getChildren().add(pressXTostartLbl);
        pressXTostartLbl.setEffect(dropShadow);

        root.getChildren().add(bigDialogueLabel);

        mission1Lbl.layoutXProperty().bind(root.widthProperty().subtract(mission1Lbl.widthProperty()).divide(2));
        mission1Lbl.layoutYProperty().bind(root.heightProperty().subtract(mission1Lbl.heightProperty()).divide(4));

        pressXTostartLbl.layoutXProperty().bind(root.widthProperty().subtract(pressXTostartLbl.widthProperty()).divide(2));
        pressXTostartLbl.layoutYProperty().bind(root.heightProperty().subtract(pressXTostartLbl.heightProperty()).divide(2.2));


        pressLeftandRightLbl.setFont(Font.font("Cascadia Code", FontWeight.BOLD, 20)); // Set font size, weight, and type
        pressLeftandRightLbl.setTextFill(Color.BROWN);


        pressLeftandRightLbl.setEffect(dropShadow);

        pressLeftandRightLbl.layoutXProperty().bind(root.widthProperty().subtract(pressLeftandRightLbl.widthProperty()).divide(2));
        pressLeftandRightLbl.layoutYProperty().bind(root.heightProperty().subtract(pressLeftandRightLbl.heightProperty()).divide(2.2));



        root.getChildren().add(pressLeftandRightLbl);
        pressLeftandRightLbl.setVisible(false);





        root.setOnKeyPressed(e -> {

            if (!bigDialogueLabel.isVisible()) {

                if (onMission) {

                    pressLeftandRightLbl.setVisible(false);


                    if (e.getCode() == KeyCode.LEFT) {
                        dan.setImage(danWalkRightImage);
                        dan.setX(dan.getX() - 10);
                        checkBounds();
                        isLeftKeyPressed = true;
                    }
                    if (e.getCode() == KeyCode.RIGHT) {
                        dan.setImage(danWalkLeftImage);
                        dan.setX(dan.getX() + 10);
                        checkBounds();
                        isRightKeyPressed = true;
                    }
                }


                if (e.getCode() == KeyCode.getKeyCode("X") && !onMission) {
                    onMission = true;
                    root.getChildren().removeAll(mission1Lbl, pressXTostartLbl);
                    pressLeftandRightLbl.setVisible(true);
                }


            }else{


                // DIALOGUE SOUND EFFECT
                if(e.getCode() == KeyCode.S && bigDialogueLabel.isVisible()){
                    dialogSE.seek(Duration.ZERO);
                    dialogSE.play();

                }


                if (e.getCode() == KeyCode.S && bunnyitemRetrieved && root.getBackground() == danBedroomBG) {

                    bunnydialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }


                if (e.getCode() == KeyCode.S &&duckitemRetrieved && root.getBackground() == danBathroomBG) {
                    duckdialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }


                if (momInteraction && e.getCode() == KeyCode.S && root.getBackground() == danHomeRoomBG) {
                    momdialogue.handleCharacterDialogEvent(bigDialogueLabel);
                }

                if (bff1Interaction && e.getCode() == KeyCode.S &&
                        root.getBackground() == danFrontYardBG && !onMission4 && !mom2Interaction) {

                    bff1dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                    if (!bff1dialogue.isDialogueDisplayed()) {
                        mission1ST.stop();
                        stage.setScene(blackscene);
                        pane.setBackground(blackBG);
                        timeline.play();
                    }

                }


                if (bff2Interaction && e.getCode() == KeyCode.S
                        && root.getBackground() == hauntedHouseBG && !onMission4 && !mom2Interaction) {

                        bff2dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                        if(!bff2dialogue.isDialogueDisplayed()) {
                            hhmusic1.stop();
                            stage.setScene(blackscene);
                            pane.setBackground(blackBG);
                            footstepsdoorSE.play();
                            timeline2.play();
                        }

                }


                if (bff3Interaction && e.getCode() == KeyCode.S &&
                        root.getBackground() == hhmainRoomBG && !onMission4 && !mom2Interaction) {
                    bff3dialogue.handleCharacterDialogEvent(bigDialogueLabel);
                }

                if (e.getCode() == KeyCode.S && letter1Retrieved && root.getBackground() == hhHallwayBG) {
                   letter1dialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }

                if (e.getCode() == KeyCode.S &&letter2Retrieved && root.getBackground() == hhHallway3BG) {
                    letter2dialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }


                if (e.getCode() == KeyCode.S &&letter3Retrieved && root.getBackground() == dungeon4BG) {
                    letter3dialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }


                if (e.getCode() == KeyCode.S &&skullRetrieved && root.getBackground() == dungeon1BG) {
                    skulldialogue.handleItemDialogueEvent(bigDialogueLabel,itemFoundLbl);
                }

                if (e.getCode() == KeyCode.S &&gunRetrieved && root.getBackground() == dungeonHallwayBG) {
                    gundialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }

                if (e.getCode() == KeyCode.S && bookRetrieved && root.getBackground() == dungeonHallway3BG) {
                    bookdialogue.handleItemDialogueEvent(bigDialogueLabel, itemFoundLbl);
                }


                if (danSelfTalk1 && e.getCode() == KeyCode.S && root.getBackground() == hhmainRoomBG) {
                    dan1dialogue.handleCharacterDialogEvent(bigDialogueLabel);
                }

                if (danSelfTalk2 && e.getCode() == KeyCode.S && root.getBackground() == hhHallway2BG) {
                        dan2dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                        if(!dan2dialogue.isDialogueDisplayed()) {
                            hhmusic1.stop();

                            stage.setScene(blackscene);
                            pane.setBackground(ghostbehinddoorBG);

                            timeline3.play();
                        }

                }

                if (danSelfTalk3 && e.getCode() == KeyCode.S && root.getBackground() == tunnelBG) {
                    dan3dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                    if(!dan3dialogue.isDialogueDisplayed()){
                        pane2.setBackground(ghostTunnelBG);
                        stage.setScene(jumpscareScene);

                        mission2ST.stop();
                        timeline4.play();
                        creepySE1.play();

                    }
                }

                if (danSelfTalk4 && e.getCode() == KeyCode.S
                        && root.getBackground() == dungeonHallway2BG) {

                    dan4dialogue.handleCharacterDialogEvent(bigDialogueLabel);
                }

                if (ghost1Interaction && e.getCode() == KeyCode.S && root.getBackground() == throneroomBG) {

                    root.getChildren().removeAll(mission1Lbl,pressXTostartLbl);
                  ghost1dialogue.handleCharacterDialogEvent(bigDialogueLabel);
                }

                if (ghost2Interaction && e.getCode() == KeyCode.S
                        && root.getBackground() == throneroomBG) {

                    ghost2dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                    if(!ghost2dialogue.isDialogueDisplayed()){
                        dan.setVisible(false);
                        pane2.setBackground(blackBG);
                        stage.setScene(jumpscareScene);
                        timeline7.play();
                        mission4ST.stop();

                    }

                }

                if (mom2Interaction && e.getCode() == KeyCode.S && (root.getBackground() == blackBG || root.getBackground() == danBedroomBG)) {
                    String dialogue = mom2Dialogues.get(mom2currentDialogueIndex);

                    if(dialogue.equals("Dan: !?")){
                        dan.setVisible(true);
                        mission4ST.play();
                        root.setBackground(danBedroomBG);
                        root.getChildren().removeAll(bunny, duck);
                        mom.setVisible(true);
                        mom.toBack();
                    }

                    if (!dialogue.isEmpty()) {

                        bigDialogueLabel.setText(dialogue);
                        bigDialogueLabel.setVisible(true);
                    } else {
                        bigDialogueLabel.setText("(Press S to Interact)");
                        bigDialogueLabel.setVisible(false);


                    }
                    mom2currentDialogueIndex++;
                }

                if (bff4Interaction && e.getCode() == KeyCode.S
                        && root.getBackground() == danFrontYardBG) {

                        bff4dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                        if(!bff4dialogue.isDialogueDisplayed()){
                        mission4ST.stop();
                        stage.setScene(blackscene);
                        pane.setBackground(blackBG);

                        timeline8.play();

                    }

                }

                if (bff5Interaction && e.getCode() == KeyCode.S
                        && root.getBackground() == hauntedHouseBG) {

                    bff5dialogue.handleCharacterDialogEvent(bigDialogueLabel);

                    if(!bff5dialogue.isDialogueDisplayed()){
                        mission4ST.stop();
                        stage.setScene(blackscene);
                        pane.setBackground(blackBG);

                        timeline9.play();

                    }

                }

            }

            if (!ghost2Interaction&&!bunnyitemRetrieved && dan.getBoundsInParent().intersects(bunny.getBoundsInParent())
                    && root.getBackground() == danBedroomBG) { //updated
                bunnyitemRetrieved = true;
                itemSE.play();


                itemFoundLbl.setVisible(true);
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(bunny);



            }

            if (!ghost2Interaction&&!duckitemRetrieved && dan.getBoundsInParent().intersects(duck.getBoundsInParent())
                    && root.getBackground() == danBathroomBG) {
                duckitemRetrieved = true;
                itemSE.stop();
                itemSE.play();


                itemFoundLbl.setVisible(true);
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(duck);
            }

            if (!ghost2Interaction&&!momInteraction && dan.getBoundsInParent().intersects(mom.getBoundsInParent())
                    && root.getBackground() == danHomeRoomBG) {

                momInteraction=true;

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);



            }

            if (!ghost2Interaction&& !bff1Interaction && dan.getBoundsInParent().intersects(julian.getBoundsInParent())
                    && root.getBackground() == danFrontYardBG) {

                bff1Interaction=true;

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }

            if (!ghost2Interaction&&!bff2Interaction && dan.getBoundsInParent().intersects(julian.getBoundsInParent())
                    && root.getBackground() == hauntedHouseBG) {

                bff2Interaction=true;
                timeline.stop(); //updated

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }

            if (!bff3Interaction && dan.getBoundsInParent().intersects(trevor.getBoundsInParent())
                    && root.getBackground() == hhmainRoomBG) {

                bff3Interaction=true;
                timeline2.stop();


                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }

            if (!letter1Retrieved && dan.getBoundsInParent().intersects(letter1.getBoundsInParent())
                    && root.getBackground() == hhHallwayBG) {
                letter1Retrieved = true;

                itemSE.stop();
                itemSE.play();
                itemFoundLbl.setVisible(true);
                bigDialogueLabel.toFront();
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(letter1); //updated

            }

            if(dan.getX() == 30 && root.getBackground() == hhmainRoomBG && letter1Retrieved && !danSelfTalk1) {

                danSelfTalk1 = true;


                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }

            if(dan.getX() == 200 && root.getBackground() == hhHallway2BG
                    && !danSelfTalk2) {
                danSelfTalk2 = true;

                missionsCompleted = 1;

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }



            if(onMission2 && pane.getBackground() == blackBG){
                timeline3.stop();

                mission1Lbl.setVisible(true);
                pressXTostartLbl.setVisible(true);

            }

            if (!letter2Retrieved && dan.getBoundsInParent().intersects(letter2.getBoundsInParent())
                    && root.getBackground() == hhHallway3BG) {
                letter2Retrieved = true;

                itemSE.stop();
                itemSE.play();
                itemFoundLbl.setVisible(true);
                bigDialogueLabel.toFront();
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(letter2); //updated

            }

            if(dan.getX() == 150 && root.getBackground() == tunnelBG
                    && !danSelfTalk3) {
                danSelfTalk3 = true;

                timeline4.stop();
                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);


            }

            if (!skullRetrieved && dan.getBoundsInParent().intersects(skull.getBoundsInParent())
                    && root.getBackground() == dungeon1BG) {
                skullRetrieved = true;

                itemSE.stop();
                itemSE.play();
                itemFoundLbl.setVisible(true);
                bigDialogueLabel.toFront();
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(skull); //updated

            }

            if (!gunRetrieved && dan.getBoundsInParent().intersects(gun.getBoundsInParent())
                    && root.getBackground() == dungeonHallwayBG) {
                gunRetrieved = true;

                itemSE.stop();
                itemSE.play();
                itemFoundLbl.setVisible(true);
                bigDialogueLabel.toFront();
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(gun); //updated

            }

            if(!isMonsterAwake && dan.getX() == 220 && root.getBackground() == dungeonHallwayBG) {

                pane2.setBackground(monsterawakeBG);
                stage.setScene(jumpscareScene);
                timeline5.play();



            }

            if(!onMission3 && root.getBackground() == dungeon3BG && !onMission){
                timeline5.stop();
                battleST.play();
                battleST.setVolume(0.4);
                monsterSE2.play();
                dan.setX((root.getWidth() - dan.getFitWidth()) / 7);
                dan.setY(root.getHeight() - dan.getFitHeight());
                monsterIdle.setX((root.getWidth() - monsterIdle.getFitWidth()));
                monsterIdle.setY((root.getHeight() - monsterIdle.getFitHeight()) + 12);
                monsterRun.setX((root.getWidth() - monsterRun.getFitWidth()));
                monsterRun.setY((root.getHeight() - monsterRun.getFitHeight()) + 20);
                root.getChildren().addAll(monsterIdle,monsterRun,danDead);
                monsterIdle.setVisible(true);
                monsterRun.setVisible(false);
                mission1Lbl.setText("MISSION 3");
                mission1Lbl.setTextFill(Color.DARKRED);
                root.getChildren().addAll(mission1Lbl,pressXTostartLbl,bloodeffect);
                missionsCompleted = 2;
                onMission3 = true;
                onMission = false;
                root.getChildren().add(bullet);
                bullet.setVisible(false);
                bloodeffect.setVisible(false);
                danDead.setVisible(false);
                root.getChildren().addAll(healthbarFull,healthbar70,healthbar60,healthbar20,healthbar10);
                healthbarFull.setVisible(false);
                healthbar70.setVisible(false);
                healthbar60.setVisible(false);
                healthbar20.setVisible(false);
                healthbar10.setVisible(false);
                pressLeftandRightLbl.setText("Press A Key to Shoot Monster");


            }

            if ( (!isGameOver && !isMonsterKilled && onMission3 && onMission && root.getBackground() == dungeon3BG)
                    || (isgameRestart)) {
                monsterIdle.setVisible(false);
                monsterRun.setVisible(true);


                if(attackCount == 0){

                    healthbarFull.setVisible(true);
                    healthbarFull.setLayoutX((root.getWidth() - healthbarFull.getFitWidth()) / 2);
                    healthbarFull.setLayoutY((root.getHeight() - healthbarFull.getFitHeight()) / 7);
                    System.out.println("Monster attacked");

                }
                if(attackCount == 1){
                    healthbarFull.setVisible(false);
                    healthbar70.setLayoutX((root.getWidth() - healthbar70.getFitWidth()) / 2);
                    healthbar70.setLayoutY((root.getHeight() - healthbar70.getFitHeight()) / 7);
                    healthbar70.setVisible(true);
                    System.out.println("attack 1");
                }
                if(attackCount == 2){
                    healthbar70.setVisible(false);
                    healthbar60.setLayoutX((root.getWidth() - healthbar60.getFitWidth()) / 2);
                    healthbar60.setLayoutY((root.getHeight() - healthbar60.getFitHeight()) / 7);
                    healthbar60.setVisible(true);
                    System.out.println("attack 2");
                }
                if(attackCount == 3){
                    healthbar60.setVisible(false);
                    healthbar20.setLayoutX((root.getWidth() - healthbar20.getFitWidth()) / 2);
                    healthbar20.setLayoutY((root.getHeight() - healthbar20.getFitHeight()) / 7);
                    healthbar20.setVisible(true);
                    System.out.println("attack 3");
                }
                if(attackCount == 4){
                    healthbar20.setVisible(false);
                    healthbar10.setLayoutX((root.getWidth() - healthbar10.getFitWidth()) / 2);
                    healthbar10.setLayoutY((root.getHeight() - healthbar10.getFitHeight()) / 7);
                    healthbar10.setVisible(true);
                    System.out.println("attack 4");
                }
                if(attackCount == 5){
                    bloodeffect.setVisible(true);
                    System.out.println("attack 5");
                    healthbar10.setVisible(false);
                    bullet.setVisible(false);
                    monsterRun.setVisible(false);
                    isMonsterKilled = true;
                    isDanKilled = false;
                    isGameOver = false;
                    bulletAnimation.stop();

                }

                if(bullet.getBoundsInParent().intersects(monsterIdle.getBoundsInParent())){
                    attackCount++;

                }

                timeline6.setCycleCount(Timeline.INDEFINITE);
                timeline6.play();
                //timeline6.setRate(3);

                collisionDetection.setCycleCount(Timeline.INDEFINITE);
                collisionDetection.play();

                if (e.getCode() == KeyCode.A) {

                    bullet.setX(dan.getX() + 50);
                    bullet.setY(dan.getFitHeight() + 100);
                    bulletAnimation.playFromStart();

                }
            }

            if(!ghost1Interaction&&!danSelfTalk4&& dan.getX() == 10 && root.getBackground() == dungeonHallway2BG){
                danSelfTalk4 = true;
                battleST.stop();
                mission3ST.play();


                timeline6.stop();
                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
            }

            if (!letter3Retrieved && dan.getBoundsInParent().intersects(letter3.getBoundsInParent())
                    && root.getBackground() == dungeon4BG) {
                letter3Retrieved = true;

                itemSE.stop();
                itemSE.play();
                itemFoundLbl.setVisible(true);
                bigDialogueLabel.toFront();
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(letter3); //updated

            }

            if(!onMission4 && root.getBackground() == throneroomBG){
                mission3ST.stop();
                mission4ST.play();
                dan.setX((root.getWidth() - dan.getFitWidth()) / 7);
                dan.setY(root.getHeight() - dan.getFitHeight());
                mission1Lbl.setText("MISSION 4");
                mission1Lbl.setTextFill(Color.DARKBLUE);
                root.getChildren().addAll(mission1Lbl,ghostappears,ghostidle);
                ghostidle.setX((root.getWidth() - ghostidle.getFitWidth()) + 180);
                ghostidle.setY(root.getHeight() - ghostidle.getFitHeight() +100);

                ghostappears.setVisible(false);
                ghostidle.setVisible(false);
                pressLeftandRightLbl.setVisible(false);

                missionsCompleted = 3;
                onMission4 = true;
                onMission3 = false;
                onMission2 = false;



            }

            if(onMission4 && root.getBackground() == throneroomBG){
                ghostidle.setVisible(true);

                if (!ghost1Interaction && dan.getBoundsInParent().intersects(ghostidle.getBoundsInParent())
                        && root.getBackground() == throneroomBG) {

                    ghost1Interaction=true;

                    bigDialogueLabel.setVisible(true);
                    bigDialogueLabel.toFront();
                    bigDialogueLabel.setPrefWidth(root.getWidth());
                    bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

                }
            }

            if (!bookRetrieved && dan.getBoundsInParent().intersects(book.getBoundsInParent())
                    && root.getBackground() == dungeonHallway3BG) {
                bookRetrieved = true;

                itemSE.stop();
                itemSE.play();
                itemFoundLbl.setVisible(true);
                bigDialogueLabel.toFront();
                itemFoundLbl.setLayoutX((root.getWidth() - itemFoundLbl.getWidth()) / 2);
                itemFoundLbl.setLayoutY((root.getHeight() - itemFoundLbl.getHeight()) / 7);
                bigDialogueLabel.setVisible(true);

                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
                root.getChildren().remove(book); //updated

            }

            if (bookRetrieved && !ghost2Interaction && dan.getBoundsInParent().intersects(ghostidle.getBoundsInParent())
                    && root.getBackground() == throneroomBG) {

                ghost2Interaction=true;

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }


            if(root.getBackground()== blackBG && !mom2Interaction && ghost2Interaction){
                timeline7.stop();
                root.getChildren().add(mom);
                mom.setVisible(false);
                dan.setX((root.getWidth() - dan.getFitWidth()) / 2);
                dan.setY(root.getHeight() - dan.getFitHeight());
                mom.setX((root.getWidth() - mom.getFitWidth()) / 7);
                mom.setY(root.getHeight() - mom.getFitHeight());
                mom2Interaction = true;
                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);
            }

            if (!bff4Interaction && dan.getBoundsInParent().intersects(julian.getBoundsInParent())
                    && root.getBackground() == danFrontYardBG && mom2Interaction) {

                bff4Interaction=true;

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }

            if (!bff5Interaction && dan.getBoundsInParent().intersects(julian.getBoundsInParent())
                    && root.getBackground() == hauntedHouseBG && bff4Interaction) {

                timeline8.stop();
                bff5Interaction=true;

                bigDialogueLabel.setVisible(true);
                bigDialogueLabel.toFront();
                bigDialogueLabel.setPrefWidth(root.getWidth());
                bigDialogueLabel.setLayoutY(root.getHeight() - bigDialogueHeight);

            }


        });



        // BULLET ANIMATION
        bulletAnimation.getKeyFrames().add(
                new KeyFrame(Duration.millis(7), ee -> {
                    if (bullet.getX() < 500) {
                        bullet.setVisible(true);
                        bullet.setX(bullet.getX() + 5);

                    }

                    if (bullet.isVisible()&&bullet.getBoundsInParent().intersects(monsterIdle.getBoundsInParent())) {
                        bloodeffect.setX(monsterRun.getX() + 100);
                        bloodeffect.setY(monsterRun.getY() + 115);
                        bloodeffect.setVisible(true);
                        System.out.println("Monster attacked");
                    }
                })
        );
        bulletAnimation.setCycleCount(Animation.INDEFINITE);

        // GAME OVER DETECTION
        collisionDetection = new Timeline(
                new KeyFrame(Duration.millis(7), e -> {

                    if(isGameOver){

                            danDead.setX(dan.getX());
                            danDead.setY(root.getHeight() - dan.getFitHeight() + 100);
                            bloodeffect.setX(dan.getX());
                            bloodeffect.setY(root.getHeight() - dan.getFitHeight() + 70);
                            dan.setVisible(false);
                            danDead.setVisible(true);
                            bloodeffect.toFront();
                            isMonsterKilled = false;
                            healthbar10.setVisible(false);

                            bullet.setVisible(false);
                            pane3.setBackground(gameoverBG);
                            System.out.println("game over");


                            stage.setScene(gameOverScene);
                            lblGameOver.setLayoutX((pane3.getWidth() - lblGameOver.getWidth()) / 2);
                            lblGameOver.setLayoutY((pane3.getHeight() - lblGameOver.getHeight()) / 14);
                            restartbtn.setLayoutX((pane3.getWidth() - restartbtn.getWidth()) / 2);
                            restartbtn.setLayoutY((pane3.getHeight() - restartbtn.getHeight()) / 5);
                            collisionDetection.stop();
                            timeline6.stop();



                    }



                })
        );

        restartbtn.setStyle(
                "-fx-background-color: brown; " +
                        "-fx-text-fill: beige; " +
                        "-fx-font-size: 11px; " +
                        "-fx-font-family: 'Broadway';"
        );

        restartbtn.setOnAction(event -> {
            isGameOver = false;
            stage.setScene(gamescene);
            isgameRestart = true;
            attackCount = 0;
            isMonsterKilled = false;

            bloodeffect.setVisible(false);
            danDead.setVisible(false);
            dan.setVisible(true);
            dan.setX((root.getWidth() - dan.getFitWidth()) / 7);
            dan.setY(root.getHeight() - dan.getFitHeight());
            healthbarFull.setVisible(true);
            healthbar70.setVisible(false);
            healthbar60.setVisible(false);
            healthbar20.setVisible(false);
            healthbar10.setVisible(false);
            monsterIdle.setVisible(true);
            monsterRun.setVisible(false);
            monsterRun.setX((root.getWidth() - monsterRun.getFitWidth()));
            monsterRun.setY((root.getHeight() - monsterRun.getFitHeight()) + 20);
            pressLeftandRightLbl.setText("Press A Key to Shoot Monster");
            pressLeftandRightLbl.setVisible(true);




            if(isMonsterKilled){
                isDanKilled = false;
                root.getChildren().removeAll(bullet,monsterRun,bloodeffect);
                bulletAnimation.stop();
                timeline6.stop();
                collisionDetection.stop();

            }


        });



        // MONSTER ANIMATION
        timeline6 = new Timeline(new KeyFrame(Duration.millis(120), event -> {
            double newX = monsterRun.getX() - 6; // Adjust the speed
            monsterRun.setX(newX);
            System.out.println("moving");

            if (!isMonsterKilled &&monsterRun.getBoundsInParent().intersects(dan.getBoundsInParent())) {
                isGameOver = true;
            }

            if(isMonsterKilled){

                isDanKilled = false;
                root.getChildren().removeAll(bullet,monsterRun,bloodeffect);
                bulletAnimation.stop();
                timeline6.stop();
                collisionDetection.stop();

            }


        }));

        root.requestFocus();


        stage.setOnShown(event -> {
            dan.setX((root.getWidth() - dan.getFitWidth()) / 2);
            dan.setY(root.getHeight() - dan.getFitHeight());



        });

        root.setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = false;
                dan.setImage(danIdleImage);
                checkBounds();
            } else if (e.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = false;
                dan.setImage(danIdleImage);
                checkBounds();
            }

        });



        root.requestFocus();
        stage.setTitle("The House on 13th Street");
        stage.setScene(welcomeScene);

        stage.setResizable(false);
        stage.show();
    }


    private void checkBounds() {
        double danX = dan.getX();
        double danWidth = dan.getFitWidth();
        double sceneWidth = dan.getScene().getWidth();


        if (danX < 0) {


            if(root.getBackground() == danBedroomBG){
                switchToRightScene(danHomeRoomBG);


            }else if(root.getBackground() == danBathroomBG){
                root.getChildren().remove(mom);
                switchToRightScene(danBedroomBG);
                root.getChildren().remove(duck);


            } else if(root.getBackground() == danHomeRoomBG){
                doorSE.stop();
                doorSE.play();
                switchToRightScene(danFrontYardBG);

            } else if(root.getBackground() == hhHallwayBG) {
                switchToRightScene(hhmainRoomBG);

            }
            else if(root.getBackground() == hhHallway3BG){
                switchToRightScene(doorDungeonBG);
            }

            else if(root.getBackground() == dungeonHallwayBG){
                switchToRightScene(dungeon1BG);
            }

            else if(root.getBackground() == dungeon4BG){
                switchToRightScene(dungeonHallway2BG);
            }
            else if(root.getBackground() == dungeonHallway3BG){
                switchToRightScene(dungeon4BG);
            }
            else if(root.getBackground() == dungeon5BG){
                switchToRightScene(dungeonHallway3BG);
            }
            else if(root.getBackground() == throneroomBG) {
                switchToRightScene(dungeon5BG);

            } else{
                dan.setX(5);
            }



        } else if (danX + danWidth > sceneWidth) {

            if(root.getBackground() == danBedroomBG){
                root.getChildren().remove(mom);
                switchToLeftScene(danBathroomBG);

            }else if(root.getBackground() == danHomeRoomBG){
                switchToLeftScene(danBedroomBG);
                root.getChildren().remove(duck); //updated wont appear in bedroom

            }else if(root.getBackground() == hhmainRoomBG){
                switchToLeftScene(hhHallwayBG);

            }

            else if(root.getBackground() == hhHallwayBG && danSelfTalk1){
                switchToLeftScene(hhHallway2BG);
            }
            else if(root.getBackground() == doorDungeonBG){
                switchToLeftScene(hhHallway3BG);
            }
            else if(root.getBackground() == hhHallway3BG){
                switchToLeftScene(tunnelBG);
            }

            else if(root.getBackground() == dungeon1BG){
                switchToLeftScene(dungeonHallwayBG);
            }

            else if(root.getBackground() == dungeonHallwayBG){
                switchToLeftScene(dungeon3BG);
                onMission = false;
            }
            else if(root.getBackground() == dungeon3BG) {
                switchToLeftScene(dungeonHallway2BG);
            }
            else if(root.getBackground() == dungeonHallway2BG){
                switchToLeftScene(dungeon4BG);
            }
            else if(root.getBackground() == dungeon4BG){
                switchToLeftScene(dungeonHallway3BG);
            }
            else if(root.getBackground() == dungeonHallway3BG){
                switchToLeftScene(dungeon5BG);
            }
            else if(root.getBackground() == dungeon5BG){
                switchToLeftScene(throneroomBG);
            }

            else{
                dan.setX(sceneWidth - danWidth);
            }




        }



    }

    private void switchToRightScene(Background rightScene) {

        root.setBackground(rightScene);
        dan.setX(300);
        dan.setY(root.getHeight() - dan.getFitHeight());

        //updated
        if(root.getBackground() == danHomeRoomBG && !mom2Interaction){
            root.getChildren().remove(bunny);
            root.getChildren().add(mom);

            mom.setX((root.getWidth() - mom.getFitWidth()) / 2);
            mom.setY(root.getHeight() - mom.getFitHeight());

        }


        if(root.getBackground() == danFrontYardBG){
            root.getChildren().remove(mom);
            root.getChildren().addAll(julian, trevor);

            trevor.setX((root.getWidth() - trevor.getFitWidth()) / 3);
            trevor.setY(root.getHeight() - trevor.getFitHeight());
            julian.setX((root.getWidth() - julian.getFitWidth()) / 2);
            julian.setY(root.getHeight() - julian.getFitHeight());


        }

        if(root.getBackground() == hhmainRoomBG){
            root.getChildren().remove(letter1);
        }

        if(!bookRetrieved &&root.getBackground() == dungeonHallway3BG && ghost1Interaction){
            root.getChildren().add(book);
            book.setX((root.getWidth() - book.getFitWidth()) / 7);
            book.setY(root.getHeight() - book.getFitHeight());
        }

        if(root.getBackground() == dungeon5BG){
            ghostidle.setVisible(false);
        }
        if(root.getBackground() == danHomeRoomBG &&ghost2Interaction){
            root.getChildren().remove(mom);
        }

        if(root.getBackground() == danHomeRoomBG &&ghost2Interaction){
            root.getChildren().remove(mom);
        }

        if(root.getBackground() == doorDungeonBG){
            root.getChildren().remove(letter2);
        }
        if(root.getBackground() == dungeon1BG){
            root.getChildren().remove(gun);

        }
        if(root.getBackground() == hhmainRoomBG && letter1Retrieved){
            root.getChildren().removeAll(julian,trevor);
        }
        if(root.getBackground()== hhmainRoomBG && !letter1Retrieved){
            root.getChildren().addAll(julian,trevor);
        }
        if(root.getBackground() == dungeonHallway2BG && !letter3Retrieved){
            root.getChildren().remove(letter3);

        }




    }

    private void switchToLeftScene(Background leftScene) {


        root.getChildren().remove(mom);


        dan.setX(0);
        dan.setY(root.getHeight() - dan.getFitHeight());
        root.setBackground(leftScene);
        duck.layoutXProperty().bind(root.widthProperty().subtract(duck.fitWidthProperty()));
        duck.layoutYProperty().bind(root.heightProperty().subtract(duck.fitHeightProperty()));

        //updated
        if(root.getBackground() == danBedroomBG && !bunnyitemRetrieved && !onMission2 && !mom2Interaction){
            bunny.layoutXProperty().bind(root.widthProperty().subtract(bunny.fitWidthProperty()));
            bunny.layoutYProperty().bind(root.heightProperty().subtract(bunny.fitHeightProperty()));
            root.getChildren().add(bunny);
            root.getChildren().remove(duck);
        }

        if(root.getBackground() == danBathroomBG && !duckitemRetrieved && !onMission2 && !mom2Interaction){
            root.getChildren().add(duck);
        }

        if(root.getBackground() == hhHallwayBG && !letter1Retrieved){ //updated removed itemretrieved boolean
            root.getChildren().removeAll(julian,trevor);
            root.getChildren().add(letter1);
            letter1.setX((root.getWidth() - letter1.getFitWidth()) / 2);
            letter1.setY(root.getHeight() - letter1.getFitHeight());


        }

        if(root.getBackground() == hhHallway3BG && !letter2Retrieved){ // removed boolean
            root.getChildren().add(letter2);
            letter2.setX((root.getWidth() - letter2.getFitWidth()) / 1.5);
            letter2.setY(root.getHeight() - letter2.getFitHeight());


        }

        if(root.getBackground() == dungeonHallwayBG && !gunRetrieved){
            root.getChildren().add(gun);
            gun.setX((root.getWidth() - gun.getFitWidth()) /1.5);
            gun.setY(root.getHeight() - gun.getFitHeight());
        }

        if(!ghost1Interaction&& root.getBackground() == dungeon4BG && !letter3Retrieved){
            root.getChildren().add(letter3);
            letter3.setX((root.getWidth() - letter3.getFitWidth()) / 2.8);
            letter3.setY(root.getHeight() - letter3.getFitHeight());
        }
        if(root.getBackground() == dungeonHallwayBG){
            root.getChildren().remove(skull);
        }

        if(root.getBackground() == dungeon5BG){
            root.getChildren().remove(book);
        }



    }


    public static Background createBackground(String imagePath) {
        Image image = new Image(imagePath);
        BackgroundImage backgroundImg = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        return new Background(backgroundImg);
    }

    public static void main(String[] args) {
        launch();
    }
}
