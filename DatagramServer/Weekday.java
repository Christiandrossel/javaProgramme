public class Weekday {

    private int day, month, year;
    private String strDay, strMonth, strYear;
    private boolean illegal;
    private String dateDay;

    public Weekday() {
      this.day = 1;
      this.month = 1;
      this.year = 1900;
    }

    public Weekday(int day, int month, int year) {
      if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2099) {
          illegal = true;
      }
      this.day = day;
      this.month = month;
      this.year = year;
    }

    public Weekday(String day, String month, String year) {
      this(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
      this.strDay = day;
      this.strMonth = month;
      this.strYear = year;
    }

    public Weekday(String[] date) {
      this(date[0], date[1], date[2]);
    }

    public String getWeekdayString(){
        if (illegal) {
          //
          return new String("Fehler: Der " + day + "." + month + "." + year + " ist kein gueltiges Datum!");
        }
        else {
          return new String("Der " + day + "." + month + "." + year +
                      " war/ist ein " + calculateDateDay(day, month, year));
        }
    }

    private String calculateDateDay(int d, int m, int y) {
        int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daySince = (y-1900)*365+(y-1900)/4+(d-1);
        for(int i= 0;i < m-1; i++) {
            daySince += monthLength[i];
        }
        Day wDay = new Day(daySince%7);
        this.dateDay = wDay.getDay();
        return this.dateDay;
    }

    public String getDateDay() {
      return this.dateDay;
    }

    public void setIllegal(boolean illegal) {
      this.illegal = illegal;
    }

    public boolean isIllegal() {
      return this.illegal;
    }

    public int getDay(){
      return this.day;
    }

    public int getMonth(){
      return this.month;
    }

    public int getYear(){
      return this.year;
    }
}
