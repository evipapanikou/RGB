class Main {
  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  
  public static void checkColor(Color c){
    if(c.exactly()) return;
    if(c.veryClose()) return;
    if(c.close()) return;
    if(c.notRelated()) return;
  }
  
  public static void main(String[] args) {
    clear();

    Color c = new Color();
    checkColor(c);
  }
}
