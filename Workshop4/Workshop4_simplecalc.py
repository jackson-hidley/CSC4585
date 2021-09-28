#Simple calculator in Python

class Workshop4_simplecalc:
  #empty constructor
    def __init__(self):
        pass

    def add(num1, num2):
        try:
            return (num1 + num2)
        except ZeroDivisionError:
            print("Can't divide by 0")
        except TypeError:
            print("Invalid input. Please input numbers only.")
        except NameError:
            print("Invalid input")
        except ValueError:
            print("Invaild input.")
        except BaseException:
            print("Invaild input.")
  
    #Function to subtract two numbers 
    def subtract(num1, num2):
        try:
            return num1 - num2
        except ZeroDivisionError:
            print("Can't divide by 0")
        except TypeError:
            print("Invalid input. Please input numbers only.")
        except NameError:
            print("Invalid input")
        except ValueError:
            print("Invaild input.")
        except BaseException:
            print("Invaild input.")

    #Function to multiply two numbers
    def multiply(num1, num2):
        try:
            return num1 * num2
        except ZeroDivisionError:
            print("Can't divide by 0")
        except TypeError:
            print("Invalid input. Please input numbers only.")
        except NameError:
            print("Invalid input")
        except ValueError:
            print("Invaild input.")
        except BaseException:
            print("Invaild input.")

    #Function to divide two numbers
    def divide(num1, num2):
        try:
            return num1 / num2
        except ZeroDivisionError:
            print("Can't divide by 0")
        except TypeError:
            print("Invalid input. Please input numbers only.")
        except NameError:
            print("Invalid input")
        except ValueError:
            print("Invaild input.")
        except AssertionError:
                print("Invalid Input")
        except BaseException:
            print("Invaild input.")

