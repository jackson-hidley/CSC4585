import json

fileo = open(“output.txt”,”w”) 
filei = open("scan-results.json",”r”) 

result = filei.read()

fileo.write("CVE-ID,DESCRIPTION,SEVERITY") 

if "CVE" in filei:

if "description" in filei:
            desc = (vuln["description"])
            result = re.search('</i>\n<i>(.*). <',desc)
            descResult = result.group(1)

if "nvdSeverity" in filei:
    serv = (vuln["nvdSeverity"])
    result = re.search('</i>\n<i>(.*). <',serv)
    servResult = result.group(1)

fileo.close() 