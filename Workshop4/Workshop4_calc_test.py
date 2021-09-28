from Workshop4_simplecalc import *
import unittest

class TestCase(unittest.TestCase):
    def test_divide(self):
        self.assertRaises(TypeError, divide(6, 0))
        self.assertRaises(ZeroDivisionError, divide(6, 0))

#    def test_main(self):
#        self.assertIsNone(Workshop4_simplecalc.select, "Select is empty")
#        self.assertIsNone(self.number_1, "Number_1 is empty")
#        self.assertIsNotNone(self.number_2, "Number_2 is empty")
        

    def test_input_value(self):
        self.assertRaises(TypeError, divide, True)

if __name__ == '__main__':
    unittest.main(argv=[''],verbosity=2, exit=False)
    