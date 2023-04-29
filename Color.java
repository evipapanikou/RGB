import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Color {
  Map<String, String> colors = new HashMap<String, String>();
  String input;

  public Color() {
    colors.put("F0F8FF", "aliceblue");
    colors.put("FAEBD7", "antiquewhite");
    colors.put("00FFFF", "aqua");
    colors.put("7FFFD4", "aquamarine");
    colors.put("F0FFFF", "azure");
    colors.put("F5F5DC", "beige");
    colors.put("FFE4C4", "bisque");
    colors.put("000000", "black");
    colors.put("FFEBCD", "blanchedalmond");
    colors.put("0000FF", "blue");
    colors.put("8A2BE2", "blueviolet");
    colors.put("A52A2A", "brown");
    colors.put("DEB887", "burlywood");
    colors.put("5F9EA0", "cadetblue");
    colors.put("7FFF00", "chartreuse");
    colors.put("D2691E", "chocolate");
    colors.put("FF7F50", "coral");
    colors.put("6495ED", "cornflowerblue");
    colors.put("FFF8DC", "cornsilk");
    colors.put("DC143C", "crimson");
    colors.put("00FFFF", "cyan");
    colors.put("00008B", "darkblue");
    colors.put("008B8B", "darkcyan");
    colors.put("B8860B", "darkgoldenrod");
    colors.put("A9A9A9", "darkgray");

    getUserInput();
  }

  private void getUserInput() {
    String hex = "0123456789ABCDEF";
    boolean repeat = false;
    Scanner sc = new Scanner(System.in);

    do {
      repeat = false;
      System.out.println("\nPlease enter a hexadecimal number: ");
      input = sc.nextLine().toUpperCase();
      if (input.length() == 6) {
        for (int i = 0; i < input.length(); i++) {
          char ch = input.charAt(i);
          String temp = Character.toString(ch);
          if (!hex.contains(temp)) {
            repeat = true;
            break;
          }
        }
      } else {
        System.out.println("Please enter exactly 6 numbers");
        repeat = true;
      }
      if (repeat) {
        System.out.println("Note: each character must be between 0 - F.");
      }
    } while (repeat);
  }

  public String getInput() {
    return input;
  }

  public boolean exactly() {
    boolean found = false;
    for (String i : colors.keySet()) {
      int compare = input.compareTo(i);
      if (compare == 0) {
        System.out.println("The color number you gave is " + colors.get(i));
        found = true;
      }
    }
    return found;
  }

  public boolean veryClose() {
    boolean found = false;
    for (String i : colors.keySet()) {
      boolean rule1 = false, rule2 = false;

      if ((i.charAt(0) == input.charAt(0)) && (i.charAt(2) == input.charAt(2)) && (i.charAt(4) == input.charAt(4))) {
        rule1 = true;
      }

      if ((i.charAt(1) != input.charAt(1)) || (i.charAt(3) != input.charAt(3)) || (i.charAt(5) != input.charAt(5))) {
        rule2 = true;
      }

      if (rule1 && rule2) {
        System.out.println("The color number you gave is very close to " + colors.get(i));
        found = true;
      }
    }
    return found;
  }

  public boolean close() {
    String myPair = "";
    boolean result = false;
    ArrayList<String> others = new ArrayList<String>();

    for (String i : colors.keySet()) {
      boolean rule1 = false, rule2 = false, rule3 = false;

      if ((i.charAt(0) == input.charAt(0)) && (i.charAt(1) == input.charAt(1))) {
        rule1 = true;
      }

      if ((i.charAt(2) == input.charAt(2)) && (i.charAt(3) == input.charAt(3))) {
        rule2 = true;
      }

      if ((i.charAt(4) == input.charAt(4)) && (i.charAt(5) == input.charAt(5))) {
        rule3 = true;
      }

      if (rule1 && rule2) {
        if ((i.charAt(4) != input.charAt(4)) && (i.charAt(5) != input.charAt(5))) {

          myPair = Character.toString(input.charAt(4))
              + Character.toString(input.charAt(5));

          others.add(Character.toString(i.charAt(4))
              + Character.toString(i.charAt(5)));

          System.out.println("The color number you gave is close to " + colors.get(i) + " with number #" + i);
          result = true;
        }
      } else if (rule1 && rule3) {
        if ((i.charAt(2) != input.charAt(2)) && (i.charAt(3) != input.charAt(3))) {

          myPair = Character.toString(input.charAt(2))
              + Character.toString(input.charAt(3));

          others.add(Character.toString(i.charAt(2))
              + Character.toString(i.charAt(3)));

          System.out.println("The color number you gave is close to " + colors.get(i) + " with number #" + i);
          result = true;
        }
      } else if (rule2 && rule3) {
        if ((i.charAt(0) != input.charAt(0)) && (i.charAt(1) != input.charAt(1))) {

          myPair = Character.toString(input.charAt(0))
              + Character.toString(input.charAt(1));

          others.add(Character.toString(i.charAt(0))
              + Character.toString(i.charAt(1)));

          System.out.println("The color number you gave is close to " + colors.get(i) + " with number #" + i);
          result = true;
        }
      }
    }
    return result;
  }

  public boolean notRelated() {
    boolean allDifferent = false, found = false;
    for (String i : colors.keySet()) {
      if (i.charAt(0) != input.charAt(0) && i.charAt(1) != input.charAt(1) && i.charAt(2) != input.charAt(2)
          && i.charAt(3) != input.charAt(3) && i.charAt(4) != input.charAt(4) && i.charAt(5) != input.charAt(5)) {
        allDifferent = true;
      }
    }
    if (allDifferent) {
      System.out.println(
          "The color number you gave #" + input + " is not related to any of the following colors in my pallete: ");
      found = true;
      for (String i : colors.keySet()) {
        System.out.println("#" + i + " : " + colors.get(i));
      }
    }
    return found;
  }

}
