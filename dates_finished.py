#
# Example file for working with date information
# For Python 3
# Violation #1 is Imports https://www.python.org/dev/peps/pep-0008/


from datetime import date, time, datetime

def main():
  ## DATE OBJECTS
  # Get today's date from the simple today() method from the date class
  today = date.today()
  # Violation #2 is spacing around commas https://www.python.org/dev/peps/pep-0008/
  print "Today's date is " , today
  
  # print out the date's individual components
  print "Date Components: " , today.day, today.month, today.year
  
  # retrieve today's weekday (0=Monday, 6=Sunday)
  print "Today's Weekday #: " , today.weekday()
  
  ## DATETIME OBJECTS
  # Get today's date from the datetime class
  today = datetime.now()
  print  "The current date and time is " , today
  
  # Get the current time
  t = datetime.time(datetime.now())
  print "The current time is " , t
  
  # weekday returns 0 (monday) through 6 (sunday)
  wd = date.weekday(today)  
  # Days start at 0 for Monday 
  days = ["monday","tuesday","wednesday","thursday","friday","saturday","sunday"]
  print "Today is day number %d" % wd
  print "Which is a " + days[wd]
  
  
if __name__ == "__main__":
  main();
  