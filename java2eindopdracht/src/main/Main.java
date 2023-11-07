/*
* Naam Student: Stefan Klok
* Datum: 7-11-2023
* Opdrachtnummer: 7 Voetbalclub
* */
import exceptions.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        System.out.println("Hello and welcome!");

        FCEmmen fcEmmen = new FCEmmen();
        final boolean ietsAangemaakt = false;


        JFrame f = new JFrame("FC EMMEN");
        f.setSize(1000, 500);
        //f.setLocation(300,200);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel pane = new JPanel(new GridBagLayout());
        f.setContentPane(pane);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        // Onderdelen eerste scherm
        JLabel label = new JLabel("FC Emmen");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 0;
        c.gridheight = 1;
        pane.add(label, c);

        JButton buttonTeam = new JButton("Maak Team");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 1;
        pane.add(buttonTeam, c);

        JButton buttonSpeler = new JButton("Maak Speler");
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 1;
        pane.add(buttonSpeler, c);

        JButton buttonKaart = new JButton("Geef Kaart");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridheight = 1;
        pane.add(buttonKaart, c);

        JButton buttonBoete = new JButton("Bereken Boete");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 1;
        pane.add(buttonBoete, c);

        JButton buttonFairPlay = new JButton("Fair Play Award");
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 1;
        pane.add(buttonFairPlay, c);

        JButton buttonAllesAanmaken = new JButton("Maak alles aan");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 1;
        pane.add(buttonAllesAanmaken, c);

        JTextArea outputTextArea = new JTextArea();
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 3;
        c.gridheight = 2;
        pane.add(outputTextArea, c);
        outputTextArea.setEditable(false);

        // Onderdelen Maak Team scherm
        JLabel teamNummerLabel = new JLabel("Team nummer:");
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 2;
        pane.add(teamNummerLabel, c);
        teamNummerLabel.setVisible(false);

        JTextArea inputTeamNummerTextArea = new JTextArea();
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 4;
        c.gridheight = 2;
        pane.add(inputTeamNummerTextArea, c);
        inputTeamNummerTextArea.setVisible(false);

        JButton buttonMaakTeam = new JButton("Maak Team aan");
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 4;
        pane.add(buttonMaakTeam, c);
        buttonMaakTeam.setVisible(false);


        //Onderdelen maak speler scherm
        JLabel rugnummerLabel = new JLabel("Rugnummer Speler:");
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 2;
        pane.add(rugnummerLabel, c);
        rugnummerLabel.setVisible(false);

        JTextArea inputRugnummerTextArea = new JTextArea();
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 4;
        c.gridheight = 2;
        pane.add(inputRugnummerTextArea, c);
        inputRugnummerTextArea.setVisible(false);

        JLabel naamLabel = new JLabel("Speler naam:");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 2;
        pane.add(naamLabel, c);
        naamLabel.setVisible(false);

        JTextArea inputNaamTextArea = new JTextArea();
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 4;
        c.gridheight = 2;
        pane.add(inputNaamTextArea, c);
        inputNaamTextArea.setVisible(false);

        JButton buttonMaakSpeler = new JButton("Maak een nieuwe speler");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 6;
        c.gridheight = 2;
        pane.add(buttonMaakSpeler, c);
        buttonMaakSpeler.setVisible(false);


        //Onderdelen geef kaart scherm
        JLabel kaartKleurLabel = new JLabel("Kaart kleur:");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridheight = 1;
        pane.add(kaartKleurLabel, c);
        kaartKleurLabel.setVisible(false);

        JRadioButton radioButtonGeel = new JRadioButton("Geel");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 3;
        c.gridheight = 1;
        pane.add(radioButtonGeel, c);
        radioButtonGeel.setVisible(false);

        JRadioButton radioButtonRood = new JRadioButton("Rood");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 4;
        c.gridheight = 1;
        pane.add(radioButtonRood, c);
        radioButtonRood.setVisible(false);

        JRadioButton radioButtonZwart = new JRadioButton("Zwart");
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 5;
        c.gridheight = 1;
        pane.add(radioButtonZwart, c);
        radioButtonZwart.setVisible(false);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonGeel);
        buttonGroup.add(radioButtonRood);
        buttonGroup.add(radioButtonZwart);

        JButton buttonGeefKaart = new JButton("Geef Kaart");
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 6;
        c.gridheight = 1;
        pane.add(buttonGeefKaart, c);
        buttonGeefKaart.setVisible(false);

        // Zorg dat tekst verwijderd wordt wanneer een TextArea geselecteerd wordt
        inputTeamNummerTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputTeamNummerTextArea.setText(null);
            }
            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing
            }
        });
        inputRugnummerTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputRugnummerTextArea.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing
            }
        });
        inputNaamTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                inputNaamTextArea.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing
            }
        });


        // Acties van de buttons
        // Button om naar het Team aanmaak scherm te gaan
        buttonTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                // set alles op visible/invisible
                buttonTeam.setVisible(false);
                buttonSpeler.setVisible(false);
                buttonKaart.setVisible(false);
                buttonBoete.setVisible(false);
                buttonFairPlay.setVisible(false);
                buttonAllesAanmaken.setVisible(false);
                outputTextArea.setVisible(false);

                teamNummerLabel.setVisible(true);
                inputTeamNummerTextArea.setVisible(true);
                buttonMaakTeam.setVisible(true);
            }
        });

        // Button die een team aanmaakt en terug gaat naar het hoofdmenu
        buttonMaakTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                // add functies
                try {
                    if(inputTeamNummerTextArea.getText().equals("")){
                        throw new GeenInvoerException();
                    }
                    int teamNummer = Integer.parseInt(inputTeamNummerTextArea.getText());

                    if(fcEmmen.checkVoorTeam(teamNummer)){
                        throw new TeamBestaatAlException();
                    }

                    fcEmmen.addNewTeam(teamNummer);

                    inputTeamNummerTextArea.setText(null);

                    buttonTeam.setVisible(true);
                    buttonSpeler.setVisible(true);
                    buttonKaart.setVisible(true);
                    buttonBoete.setVisible(true);
                    buttonFairPlay.setVisible(true);
                    buttonAllesAanmaken.setVisible(true);
                    outputTextArea.setVisible(true);

                    teamNummerLabel.setVisible(false);
                    inputTeamNummerTextArea.setVisible(false);
                    buttonMaakTeam.setVisible(false);

                    outputTextArea.setText("Team is toegevoegd");

                }catch(GeenInvoerException | TeamBestaatAlException exception){
                    inputTeamNummerTextArea.setText(exception.getMessage());
                } catch(Exception exception){
                    inputTeamNummerTextArea.setText("Voer hier een getal in");
                }
            }
        });

        // Button om naar het Speler aanmaak scherm te gaan
        buttonSpeler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fcEmmen.checkVoorTeams()) {
                    buttonTeam.setVisible(false);
                    buttonSpeler.setVisible(false);
                    buttonKaart.setVisible(false);
                    buttonBoete.setVisible(false);
                    buttonFairPlay.setVisible(false);
                    buttonAllesAanmaken.setVisible(false);
                    outputTextArea.setVisible(false);

                    teamNummerLabel.setVisible(true);
                    inputTeamNummerTextArea.setVisible(true);
                    rugnummerLabel.setVisible(true);
                    inputRugnummerTextArea.setVisible(true);
                    naamLabel.setVisible(true);
                    inputNaamTextArea.setVisible(true);
                    buttonMaakSpeler.setVisible(true);
                }else{
                    outputTextArea.setText("Er zijn geen teams om een speler aan toe te voegen");
                }
            }
        });

        // Button die een speler aanmaakt en terug gaat naar het hoofdmenu
        buttonMaakSpeler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(inputTeamNummerTextArea.getText().equals("") || inputRugnummerTextArea.getText().equals("") || inputNaamTextArea.getText().equals("")){
                        throw new GeenInvoerException();
                    }
                    //TODO
                    // add functies
                    int teamNummer = Integer.parseInt(inputTeamNummerTextArea.getText());
                    int rugnummer = Integer.parseInt(inputRugnummerTextArea.getText());
                    String naam = inputNaamTextArea.getText();

                    if(fcEmmen.checkVoorSpeler(teamNummer, rugnummer)){
                        throw new SpelerBestaatAlException();
                    }

                    fcEmmen.addSpelerToTeam(teamNummer, rugnummer, naam);

                    inputTeamNummerTextArea.setText(null);
                    inputRugnummerTextArea.setText(null);
                    inputNaamTextArea.setText(null);

                    buttonTeam.setVisible(true);
                    buttonSpeler.setVisible(true);
                    buttonKaart.setVisible(true);
                    buttonBoete.setVisible(true);
                    buttonFairPlay.setVisible(true);
                    buttonAllesAanmaken.setVisible(true);
                    outputTextArea.setVisible(true);

                    teamNummerLabel.setVisible(false);
                    inputTeamNummerTextArea.setVisible(false);
                    rugnummerLabel.setVisible(false);
                    inputRugnummerTextArea.setVisible(false);
                    naamLabel.setVisible(false);
                    inputNaamTextArea.setVisible(false);
                    buttonMaakSpeler.setVisible(false);

                    outputTextArea.setText("Speler is toegevoegd");

                }catch(GeenInvoerException | SpelerBestaatAlException exception){
                    inputTeamNummerTextArea.setText(exception.getMessage());
                    inputRugnummerTextArea.setText(exception.getMessage());
                    inputNaamTextArea.setText(exception.getMessage());
                }catch(Exception exception){
                    inputTeamNummerTextArea.setText("Voer hier een getal in");
                    inputRugnummerTextArea.setText("Voer hier een getal in");
                }
            }
        });

        // Button om naar het Geef een kaart scherm te gaan
        buttonKaart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fcEmmen.checkVoorSpelers()) {
                    buttonTeam.setVisible(false);
                    buttonSpeler.setVisible(false);
                    buttonKaart.setVisible(false);
                    buttonBoete.setVisible(false);
                    buttonFairPlay.setVisible(false);
                    buttonAllesAanmaken.setVisible(false);
                    outputTextArea.setVisible(false);

                    teamNummerLabel.setVisible(true);
                    inputTeamNummerTextArea.setVisible(true);
                    rugnummerLabel.setVisible(true);
                    inputRugnummerTextArea.setVisible(true);
                    kaartKleurLabel.setVisible(true);
                    radioButtonGeel.setVisible(true);
                    radioButtonRood.setVisible(true);
                    radioButtonZwart.setVisible(true);
                    buttonGeefKaart.setVisible(true);
                    radioButtonGeel.isSelected();
                }else{
                    outputTextArea.setText("Er zijn geen spelers om kaarten aan te geven");
                }
            }
        });

        // Button die een kaart geeft aan een speler en terug gaat naar het hoofdmenu
        buttonGeefKaart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //TODO
                    // add functies
                    if(inputTeamNummerTextArea.getText().equals("") || inputRugnummerTextArea.getText().equals("")){
                        throw new GeenInvoerException();
                    }

                    int teamNummer = Integer.parseInt(inputTeamNummerTextArea.getText());
                    int rugnummer = Integer.parseInt(inputRugnummerTextArea.getText());
                    if (radioButtonGeel.isSelected()) {
                        fcEmmen.geefKaart(teamNummer, rugnummer, 1);
                    } else if (radioButtonRood.isSelected()) {
                        fcEmmen.geefKaart(teamNummer, rugnummer, 2);
                    } else if (radioButtonZwart.isSelected()) {
                        fcEmmen.geefKaart(teamNummer, rugnummer, 3);
                    }

                    if(!fcEmmen.checkVoorSpeler(teamNummer, rugnummer)){
                        throw new SpelerBestaatNietException();
                    }

                    if(!radioButtonGeel.isSelected() && !radioButtonRood.isSelected() && !radioButtonZwart.isSelected()){
                        throw new GeenKleurGeselecteerdException();
                    }

                    inputTeamNummerTextArea.setText(null);
                    inputRugnummerTextArea.setText(null);
                    kaartKleurLabel.setText("Kaart kleur");
                    buttonGroup.clearSelection();


                    buttonTeam.setVisible(true);
                    buttonSpeler.setVisible(true);
                    buttonKaart.setVisible(true);
                    buttonBoete.setVisible(true);
                    buttonFairPlay.setVisible(true);
                    buttonAllesAanmaken.setVisible(true);
                    outputTextArea.setVisible(true);

                    teamNummerLabel.setVisible(false);
                    inputTeamNummerTextArea.setVisible(false);
                    rugnummerLabel.setVisible(false);
                    inputRugnummerTextArea.setVisible(false);
                    buttonMaakSpeler.setVisible(false);
                    kaartKleurLabel.setVisible(false);
                    radioButtonGeel.setVisible(false);
                    radioButtonRood.setVisible(false);
                    radioButtonZwart.setVisible(false);
                    buttonGeefKaart.setVisible(false);

                    outputTextArea.setText("Kaart is gegeven");

                }catch(GeenInvoerException | SpelerBestaatNietException exception){
                    inputTeamNummerTextArea.setText(exception.getMessage());
                    inputRugnummerTextArea.setText(exception.getMessage());
                }catch(GeenKleurGeselecteerdException exception){
                    kaartKleurLabel.setText(kaartKleurLabel.getText() + " " + exception.getMessage());
                }
            }
        });

        // Button die het totale boetebedrag berekend en weergeeft
        buttonBoete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextArea.setText(null);
                String boeteBedrag = "Boete bedrag: " + fcEmmen.getBoeteBedrag();
                outputTextArea.setText(boeteBedrag);
            }
        });

        // Button die de spelers bepaalt die de Fair Play Award hebben gewonnen en deze weergeeft
        buttonFairPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                // add functies
                outputTextArea.setText(null);
                String fairPlayAward = "Winnaar(s) Fair Play Award: " + fcEmmen.getSpelersMinsteKaarten();
                outputTextArea.setText(fairPlayAward);
            }
        });

        // Button die meerdere teams, spelers en kaarten aanmaakt
        buttonAllesAanmaken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO
                // add functies
                if (fcEmmen.getTeams().isEmpty()) {
                    fcEmmen.addNewTeam(1);
                    fcEmmen.addNewTeam(2);
                    fcEmmen.addSpelerToTeam(1, 1, "a");
                    fcEmmen.addSpelerToTeam(1, 2, "b");
                    fcEmmen.addSpelerToTeam(1, 3, "c");
                    fcEmmen.addSpelerToTeam(1, 4, "d");
                    fcEmmen.addSpelerToTeam(1, 5, "e");
                    fcEmmen.addSpelerToTeam(1, 6, "f");
                    fcEmmen.addSpelerToTeam(1, 7, "g");
                    fcEmmen.addSpelerToTeam(1, 8, "h");
                    fcEmmen.addSpelerToTeam(1, 9, "i");
                    fcEmmen.addSpelerToTeam(1, 10, "j");
                    fcEmmen.addSpelerToTeam(1, 11, "k");
                    fcEmmen.addSpelerToTeam(2, 1, "l");
                    fcEmmen.addSpelerToTeam(2, 2, "m");
                    fcEmmen.addSpelerToTeam(2, 3, "n");
                    fcEmmen.addSpelerToTeam(2, 4, "o");
                    fcEmmen.addSpelerToTeam(2, 5, "p");
                    fcEmmen.addSpelerToTeam(2, 6, "q");
                    fcEmmen.addSpelerToTeam(2, 7, "r");
                    fcEmmen.addSpelerToTeam(2, 8, "s");
                    fcEmmen.addSpelerToTeam(2, 9, "t");
                    fcEmmen.addSpelerToTeam(2, 10, "u");
                    fcEmmen.addSpelerToTeam(2, 11, "v");
                    fcEmmen.geefKaart(1, 1, 1); //a
                    fcEmmen.geefKaart(1, 1, 2); //a
                    //fcEmmen.geefKaart(1,2, 1); //b
                    fcEmmen.geefKaart(1, 2, 3); //b
                    //fcEmmen.geefKaart(1,3, 1); //c
                    fcEmmen.geefKaart(1, 3, 3); //c
                    fcEmmen.geefKaart(1, 4, 1); //d
                    //fcEmmen.geefKaart(1,4, 2); //d
                    //fcEmmen.geefKaart(1,5, 1); //e
                    fcEmmen.geefKaart(1, 5, 2); //e
                    //fcEmmen.geefKaart(1,6, 1); //f
                    fcEmmen.geefKaart(1, 6, 2); //f
                    fcEmmen.geefKaart(1, 7, 1); //g
                    fcEmmen.geefKaart(1, 7, 2); //g
                    fcEmmen.geefKaart(1, 8, 1); //h
                    fcEmmen.geefKaart(1, 8, 2); //h
                    fcEmmen.geefKaart(1, 9, 1); //i
                    fcEmmen.geefKaart(1, 9, 2); //i
                    fcEmmen.geefKaart(1, 10, 1); //j
                    fcEmmen.geefKaart(1, 10, 1); //j
                    fcEmmen.geefKaart(1, 11, 1); //k
                    //fcEmmen.geefKaart(1,11, 2); //k
                    fcEmmen.geefKaart(2, 1, 1); //l
                    fcEmmen.geefKaart(2, 1, 2); //l
                    //fcEmmen.geefKaart(2,2, 1); //m
                    fcEmmen.geefKaart(2, 2, 2); //m
                    fcEmmen.geefKaart(2, 3, 1); //n
                    fcEmmen.geefKaart(2, 3, 2); //n
                    fcEmmen.geefKaart(2, 4, 1); //o
                    fcEmmen.geefKaart(2, 4, 2); //o
                    fcEmmen.geefKaart(2, 5, 1); //p
                    fcEmmen.geefKaart(2, 5, 2); //p
                    fcEmmen.geefKaart(2, 6, 1); //q
                    //fcEmmen.geefKaart(2,6, 2); //q
                    fcEmmen.geefKaart(2, 7, 1); //r
                    fcEmmen.geefKaart(2, 7, 2); //r
                    fcEmmen.geefKaart(2, 8, 1); //s
                    fcEmmen.geefKaart(2, 8, 2); //s
                    fcEmmen.geefKaart(2, 9, 1); //t
                    fcEmmen.geefKaart(2, 9, 2); //t
                    fcEmmen.geefKaart(2, 10, 1); //u
                    fcEmmen.geefKaart(2, 10, 1); //u
                    fcEmmen.geefKaart(2, 11, 1); //v
                    //fcEmmen.geefKaart(2,11, 2); //v

                    outputTextArea.setText("Er zijn 2 teams en 22 spelers aangemaakt en er zijn kaarten gegeven");
                } else {
                    outputTextArea.setText("Er bestaan al teams en/of spelers");
                }
            }
        });

        f.setVisible(true);
    }
}