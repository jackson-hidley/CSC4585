import xml.etree.ElementTree as ET
import os
import csv 

def find_all(name, path):
    result = []
    for root, dirs, files in os.walk(path):
        if name in files:
            result.append(os.path.join(root, name))
            #print(os.path.join(root, name))
    return result


name = "AndroidManifest.xml"
path = "..\FARMING_ANDROID_REPOS"

r = find_all(name, path)

len = len(r)
row_list = ['Directory','Full_Path_To_File','Lines_Of_Code,Dangerous_Permission_Name']

while len > 0:
    print(len)
    root = ET.parse(r[len-1]).getroot()
    permissions = root.findall("uses-permission")
    len = len - 1


for perm in permissions:
    for att in perm.attrib:
        print("{}\t:\t{}\n".format(att, perm.attrib[att]))
        #row_list.append()


with open('Workshop#5.Output.csv', 'w', newline='') as file:
    writer = csv.writer(file, delimiter=',')
    writer = csv.writer(file)
    writer.writerows(row_list)