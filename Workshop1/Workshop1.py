from z3 import *

x = Int('x')
y = Int('y')

s = Solver()
for i in range( -100, 100):
    s.add(y == 3*x, x - y > -50, x>i)

    s.check()
    print(s.model())