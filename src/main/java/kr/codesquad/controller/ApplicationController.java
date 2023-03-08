package kr.codesquad.controller;

import java.util.Arrays;
import kr.codesquad.model.Ladder;
import kr.codesquad.view.View;

public class ApplicationController {
    View view;
    Ladder ladder;

    public ApplicationController(View inputView, Ladder ladder) {
        this.view = inputView;
        this.ladder = ladder;
    }

    public void run() {
        view.printJoinMembers();
        String joinMembers = validateName();

        view.printMaxLadderHeight();
        String maxLadderHeight = validateNumber();

        String[][] ladderResult = ladder.make(joinMembers, maxLadderHeight);
        view.printLadderResult(ladderResult);
    }

    public String validateName() {
        boolean flag = false;
        String input = "";
        while (!flag) {
            input = view.inputUserString();
            flag = checkInputLength(input);
        }
        return input;
    }

    public String validateNumber() {
        boolean flag = false;
        String input = "";
        while (!flag) {
            input = view.inputUserString();
            flag = checkInputNumber(input);
        }
        return input;
    }

    public boolean checkInputLength(String input) {
        String[] inputArray = input.split(",");
        int userNumber = (int) Arrays.stream(inputArray)
                .filter(s -> s.length() <= 5)
                .count();
        return inputArray.length == userNumber;
    }

    public boolean checkInputNumber(String input) {
        String temp = input.replaceAll("[0-9]", "");
        return input.length() != temp.length();
    }
}
