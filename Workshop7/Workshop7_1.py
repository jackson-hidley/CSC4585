## bandit -r ML-CODE

## subprocess.run(["bandit", "-r", "ML-CODE", "-f", "json"])
import os
directory = 'ML-CODE'

for filename in os.listdir(directory):
    if filename.endswith(".py"):
      os.system("bandit -f json " + filename + " > " + "outputfile.txt")
