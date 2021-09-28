#Simple calculator in Python
#class calc
#Function to add two numbers 
def add(num1, num2):
    try:
        return num1 + num2
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
    except BaseException:
        print("Invaild input.")

#Used for sanitizing. Set true if there is a catch

#Print main menu
print("\nPlease select operation -\n" \
        "1. Add\n" \
        "2. Subtract\n" \
        "3. Multiply\n" \
        "4. Divide\n")
  

#Grab input from user and sanitize
try:
    select = int(input("Select operations form 1, 2, 3, 4 :"))
except ValueError:
    print("Invaild input.")
except TypeError:
    print("Invaild input.")
except NameError:
    print("Invalid input")
except BaseException:
    print("Invaild input.")

try:
    number_1 = int(input("Enter first number: "))
except ValueError:
    print("Invaild input.")
except TypeError:
    print("Invalid input. Please input numbers only.")
except BaseException:
    print("Invaild input.")

try:
    number_2 = int(input("Enter second number: "))
except ValueError:
    print("Invaild input.")
except TypeError:
    print("Invalid input. Please input numbers only.")
except NameError:
    print("Invalid input")
except BaseException:
    print("Invaild input.")

try:
    #Addition
    if select == 1:
        print(number_1, "+", number_2, "=",
                        add(number_1, number_2))
    #Subtraction  
    elif select == 2:
        print(number_1, "-", number_2, "=",
                        subtract(number_1, number_2))
    #Multiplecation
    elif select == 3:
        print(number_1, "*", number_2, "=",
                        multiply(number_1, number_2))
    #Division
    elif select == 4:
        print(number_1, "/", number_2, "=",
                    divide(number_1, number_2))
    #Invalid input
    else:
        print("Invalid input\n")
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
