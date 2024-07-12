package org.aes.compare.uiconsole.utility;

import org.aes.compare.customterminal.business.abstracts.TerminalCommandLayout;
import org.aes.compare.customterminal.business.concretes.TerminalCommandManager;
import org.aes.compare.customterminal.config.concrete.CMDLineSingletonBuilder;
import org.aes.compare.customterminal.model.TerminalCMD;
import org.aes.compare.orm.utility.ColorfulTextDesign;
import org.aes.compare.uiconsole.model.EnumCMDLineParserResult;

import java.util.List;
import java.util.Scanner;

public class SafeScannerInput {
    private static Scanner scanner = new Scanner(System.in);
    private static InputParserTree inputParserTree = new InputParserTree();

    public int convertInputToListIndexValue(String input, List<?> list) {
        Integer integer = getInt(input);
        if (integer != null) {
            int num = --integer;
            boolean result = isNumberSuitableListRange(num, list);
            if (result) {
                return num;
            }
        }
        return -1;

    }

    public static Integer getIntRecursive() {
        try {
            int num = Integer.parseInt(scanner.nextLine());
            return num;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Index Input. Please try again.");
            return getIntRecursive();
        }
    }


    public static Integer getInt(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Index Input. Please try again.");
            return null;
        }
    }

    private boolean isNumberSuitableListRange(int num, List<?> list) {
        if (num >= 0 && num < list.size()) {
            return true;
        }
        System.out.println("Invalid Index range. Please choose number between 0-" + (list.size() - 1));
        return false;
    }

    public static String getStringInput(String inputMsg, TerminalCommandLayout tmc) {
        System.out.println(inputMsg);
        String input = scanner.nextLine();
        EnumCMDLineParserResult result = inputParserTree.decideProcess(input);
        if (result.getId() == EnumCMDLineParserResult.RUN_FOR_CMDLINE.getId()) {
            TerminalCMD terminalCMD = inputParserTree.getTerminalCMD();
            new TerminalCommandManager().runCustomCommand(tmc, terminalCMD);
        }
        if (tmc.isCurrentProcessCanceled()) {
            return "";
        }
        if (input.contains(CMDLineSingletonBuilder.getCmdLine().getPrefix())) {
            return getStringInput(inputMsg, tmc);
        }
        if (input.trim().isEmpty()) {
            System.out.println(ColorfulTextDesign.getErrorColorText("Blank is not allowed. Please type something"));
            return getStringInput(inputMsg, tmc);
        }
        return input;
    }

    public static int getIntInput(int minRange, int maxRange, String inputMsg, TerminalCommandLayout tmc) {
        System.out.println(inputMsg);
        String input = scanner.nextLine();
        EnumCMDLineParserResult result = inputParserTree.decideProcess(input);


        if (result.getId() == EnumCMDLineParserResult.RUN_FOR_CMDLINE.getId()) {
            TerminalCMD terminalCMD = inputParserTree.getTerminalCMD();
            new TerminalCommandManager().runCustomCommand(tmc, terminalCMD);
        }

        Integer num = getInt(input);
        if (tmc.isCurrentProcessCanceled()) {
            return -1;
        }
        if (input.contains(CMDLineSingletonBuilder.getCmdLine().getPrefix())) {
            return getIntInput(inputMsg, tmc);
        }
        if (num == null) {
            return getIntInput(inputMsg, tmc);
        }
        if (num < minRange || num > maxRange) {
            System.out.println("Number must be between " + minRange + "-" + maxRange + ".");
            return getIntInput(minRange, maxRange, inputMsg, tmc);
        }
        return num;
    }

    public static int getIntInput(String inputMsg, TerminalCommandLayout tmc) {
        System.out.println(inputMsg);
        String input = scanner.nextLine();
        EnumCMDLineParserResult result = inputParserTree.decideProcess(input);


        if (result.getId() == EnumCMDLineParserResult.RUN_FOR_CMDLINE.getId()) {
            TerminalCMD terminalCMD = inputParserTree.getTerminalCMD();
            new TerminalCommandManager().runCustomCommand(tmc, terminalCMD);
        }

        Integer num = getInt(input);
        if (tmc.isCurrentProcessCanceled()) {
            return -1;
        }
        if (input.contains(CMDLineSingletonBuilder.getCmdLine().getPrefix())) {
            return getIntInput(inputMsg, tmc);
        }
        if (num == null) {
            return getIntInput(inputMsg, tmc);
        }
        return num;
    }

}
