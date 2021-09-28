import unittest
from Workshop4_simplecalc import Workshop4_simplecalc

class TestCalc(unittest.TestCase):
#setUp method is overridden from the parent class TestCase
  def setUp(self):
    self.Workshop4_simplecalc = Workshop4_simplecalc()

  #Each test method starts with the keyword test_
  def test_add(self):
    self.assertEqual(Workshop4_simplecalc.add(4,7), 11)
    
  def test_subtract(self):
    self.assertEqual(Workshop4_simplecalc.subtract(10,5), 5)

  def test_multiply(self):
    self.assertEqual(Workshop4_simplecalc.multiply(3,7), 21)

  def test_divide(self):
      self.assertEqual(Workshop4_simplecalc.divide(10,2), 5)
      self.assertEqual(Workshop4_simplecalc.divide(10,0), None)

    
# Executing the tests in the above test case class
if __name__ == "__main__":
  unittest.main()