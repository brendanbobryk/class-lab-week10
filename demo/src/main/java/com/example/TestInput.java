package com.example;

import java.util.*;

// input data
public class TestInput {

  String rocketName;
  int[] countDown;

  public String toString() {
    String s = "";
    s += String.format("rocketName: %s\n", rocketName);
    s += String.format("countDown: %s\n", Arrays.toString(countDown));
    return s;
  }
}
