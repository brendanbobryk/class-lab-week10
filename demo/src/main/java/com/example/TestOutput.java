package com.example;

import java.util.*;

// output data
public class TestOutput {

  int duplicate;
  int missing;

  public String toString() {
    String s = "";
    s += String.format("duplicate: %s\n", duplicate);
    s += String.format("missing: %s\n", missing);
    return s;
  }
}
