package com.example.gameproj;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DialogueClass {
    private List<String> dialogues;
    private int currentDialogueIndex;
    private Label bigDialogueLabel;
    private Label itemFoundlbl;
    private boolean dialogueDisplayed;



    public DialogueClass(String fileName) {
        dialogues = new ArrayList<>();
        loadDialoguesFromFile(fileName);
        currentDialogueIndex = 0;
    }

    public void setBigDialogueLabel(Label bigDialogueLabel) {
        this.bigDialogueLabel = bigDialogueLabel;
    }

    public void setItemFoundLabel(Label itemFoundlbl) {
        this.itemFoundlbl = itemFoundlbl;
    }
    private void loadDialoguesFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                dialogues.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNextDialogue() {
        if (currentDialogueIndex < dialogues.size()) {
            String dialogue = dialogues.get(currentDialogueIndex);
            currentDialogueIndex++;
            return dialogue;
        }
        return null;
    }

    public int getDialoguesSize() {
        return dialogues.size();
    }

    public void handleItemDialogueEvent(Label bigDialogueLabel, Label itemFoundlbl) {

            String dialogueText = getNextDialogue();
            if (dialogueText != null && !dialogueText.isEmpty()) {
                bigDialogueLabel.setText(dialogueText);
                bigDialogueLabel.setVisible(true);
            } else {
                bigDialogueLabel.setText("(Press S to Interact)");
                itemFoundlbl.setVisible(false);
                bigDialogueLabel.setVisible(false);
            }
        }


    public void handleCharacterDialogEvent(Label bigDialogueLabel) {
        String dialogue = getNextDialogue();
        if (dialogue != null && !dialogue.isEmpty()) {
            bigDialogueLabel.setText(dialogue);
            bigDialogueLabel.setVisible(true);
            dialogueDisplayed = true; // Dialogue displayed
        } else {
            bigDialogueLabel.setText("(Press S to Interact)");
            bigDialogueLabel.setVisible(false);
            dialogueDisplayed = false; // Dialogue not displayed
        }

    }

    // Method to check if dialogue was displayed
    public boolean isDialogueDisplayed() {
        return dialogueDisplayed;
    }



    }


