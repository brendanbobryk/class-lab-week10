package com.example;

import com.google.gson.Gson;
import java.util.*;

public class App {

    private static String dataFilePath = "C:/Users/Brendan/Documents/GitHub/class-lab-week10/demo/src/main/java/com/example/rocketData.json";

    public static TestOutput process(TestInput input) {
        String rocketName = input.rocketName;
        int[] countDown = input.countDown;

        TestOutput answer = new TestOutput();

        /*
         * STUDENTS NEED TO ADD/EDIT CODE STARTING HERE
         */

        int startingNumber = countDown[0];
        int expectedSum = (startingNumber * (startingNumber + 1)) / 2;
        int actualSum = 0;
        answer.duplicate = 0;
        Set<Integer> seenNumbers = new HashSet<>();

        int tempNumber = 0;
        for (int i = 0; i < startingNumber; i++) {
            tempNumber = countDown[i];
            actualSum += tempNumber;

            if (seenNumbers.contains(tempNumber)) {
                answer.duplicate = tempNumber;
            } else {
                seenNumbers.add(tempNumber);
            }
        }

        answer.missing = expectedSum - actualSum;

        /*
         * STUDENTS DO NOT NEED TO EDIT ANY CODE AFTER THIS
         */

        // return the answer
        return answer;
    }

    public static void main(String[] args) {
        LabTestData td = new LabTestData();

        // read data
        String jsonStr = td.readJSON(dataFilePath);

        // convert data to obj
        Gson gson = new Gson();
        LabTestData testData = gson.fromJson(jsonStr, LabTestData.class);

        // run each test
        int pass = 0;
        int fail = 0;
        for (int i = 0; i < testData.tests.length; i += 1) {
            TestInput input = testData.tests[i].input;

            TestOutput answer = process(input);

            // get correct answer
            TestOutput correctAnswer = testData.tests[i].output;

            System.out.printf("\n");

            // if answer is correct, report results
            if ((answer.duplicate == correctAnswer.duplicate) &&
                    (answer.missing == correctAnswer.missing)) {
                System.out.printf("--------------------------------------\n");
                System.out.printf("PASSED test %d :\n", i);
                System.out.printf("--------------------------------------\n\n");
                pass += 1;
                // if answer is incorrect, report the error
            } else {
                System.out.printf("--------------------------------------\n");
                System.out.printf("FAILED test %d\n", i);
                System.out.printf("--------------------------------------\n\n");
                fail += 1;
            }

            // print input
            System.out.printf("input:\n");
            System.out.println(input);

            // print answer and correct answer
            System.out.printf("your answer:\n");
            System.out.println(answer);
            System.out.printf("correct answer:\n");
            System.out.println(correctAnswer);

            System.out.printf("--------------------------------------\n\n");
        }
        System.out.printf("--------------------------------------\n");
        System.out.printf("PASSED %d TESTS\n", pass);
        System.out.printf("FAILED %d TESTS\n", fail);
        System.out.printf(
                "%d%% pass rate\n",
                (int) (((float) pass / (float) (pass + fail) * 100.0f)));

        System.out.printf("--------------------------------------\n\n");
    }
}
