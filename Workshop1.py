from z3 import *

x = Int('x')
y = Int('y')

s = Solver()

s.add(y == 3*x, x - y > -50)

s.check()
print(s.model())