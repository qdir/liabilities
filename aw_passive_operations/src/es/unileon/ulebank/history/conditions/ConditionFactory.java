/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.conditions;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.iterator.Condition;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author runix
 * @param <T>
 */
public class ConditionFactory<T extends Transaction> {

    private static ConditionFactory instance;
    private static Pattern numberPattern;

    private ConditionFactory() {
        numberPattern = Pattern.compile("^[0-9]*$");
    }

    public static ConditionFactory getInstance() {
        if (instance == null) {
            instance = new ConditionFactory();
        }
        return instance;
    }

    public Condition<T> getCondition(String condition, String[] args) throws WrongArgsException {
        Condition<T> result = null;
        boolean isNegated = false;
        if (condition.startsWith("date_")) {
            result = this.getDateCondition(condition.substring(condition.indexOf("_") + 1), args);
        } else if (condition.startsWith("amount_")) {
            result = this.getAmountCondition(condition.substring(condition.indexOf("_") + 1), args);
        } else if (condition.startsWith("subject_")) {
            result = this.getSubjectCondition(condition.substring(condition.indexOf("_") + 1), args);
        }
        return result;
    }

    private Condition<T> getDateCondition(String command, String[] args) throws WrongArgsException {
        Condition<T> result = null;
        boolean isNegated = false;
        switch (command) {
            case "include":
                isNegated = true;
            case "exclude":
                if (checkArgsNumber(args, 1) && onlyNumbers(args)) {
                    result = new ConditionOneDay<>(new Date(Long.parseLong(args[0])), isNegated);
                }
                break;
            case "between":
                isNegated = true;
            case "notBetween":
                if (checkArgsNumber(args, 2) && onlyNumbers(args)) {
                    result = new ConditionTransactionBetweenTwoDates<>(new Date(Long.parseLong(args[0])), new Date(Long.parseLong(args[1])), isNegated);
                }
                break;
            case "from":
                System.out.println(checkArgsNumber(args, 1));
                if (checkArgsNumber(args, 1) && onlyNumbers(args)) {
                    result = new ConditionTransactionBetweenTwoDates<>(new Date(Long.parseLong(args[0])), new Date(Long.MAX_VALUE), true);
                }
                break;
            case "after":
                if (checkArgsNumber(args, 1) && onlyNumbers(args)) {
                    result = new ConditionTransactionBetweenTwoDates<>(new Date(0), new Date(Long.parseLong(args[0])), true);
                }
                break;
        }
        return result;
    }

    private Condition<T> getSubjectCondition(String command, String[] args) {
        Condition<T> result = null;
        boolean isNegated = false;
        switch (command) {
            case "contains":
                isNegated = true;
            case "notContains":
                if (args.length > 0) {
                    result = new ConditionSubject<>(isNegated, args);
                }
                break;
        }
        return result;
    }

    private Condition<T> getAmountCondition(String command, String[] args) throws WrongArgsException {
        Condition<T> result = null;
        boolean isNegated = false;
        switch (command) {
            case "from":
                if (checkArgsNumber(args, 1) && onlyNumbers(args)) {
                    result = new ConditionTransactionBetweenTwoAmounts(Long.parseLong(args[0]), Long.MAX_VALUE, true);
                }
                break;
            case "until":
                if (checkArgsNumber(args, 1) && onlyNumbers(args)) {
                    result = new ConditionTransactionBetweenTwoAmounts(0, Long.parseLong(args[0]), true);
                }
                break;
            case "between":
                isNegated = true;
            case "notBetween":
                if (checkArgsNumber(args, 2) && onlyNumbers(args)) {
                    result = new ConditionTransactionBetweenTwoAmounts<>(Long.parseLong(args[0]), Long.parseLong(args[1]), isNegated);
                }
                break;
        }
        return result;
    }

    private boolean checkArgsNumber(String[] args, int expected) {
        return args.length == expected;
    }

    private boolean onlyNumbers(String[] args) {
        boolean hasLetters = false;
        int i = 0;
        while (i < args.length && !hasLetters) {
            if (!numberPattern.matcher(args[i++]).find()) {
                hasLetters = true;
            }
        }
        return !hasLetters;
    }
}
