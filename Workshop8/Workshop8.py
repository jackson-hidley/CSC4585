import json

fileo = open(“output.txt”,”w”) 
filei = open("scan-results.json",”r”) 

result = filei.read()

fileo.write("CVE-ID,DESCRIPTION,SEVERITY") 
while(1):

    if "CVE" in filei:
        cve = (vuln["CVE"])
        result = re.search('</i>\n<i>(.*). <',cve)
        cveResult = result.group(1)   

    if "description" in filei:
        desc = (vuln["description"])
        result = re.search('</i>\n<i>(.*). <',desc)
        descResult = result.group(1)

    if "nvdSeverity" in filei:
        serv = (vuln["nvdSeverity"])
        result = re.search('</i>\n<i>(.*). <',serv)
        servResult = result.group(1)

    fileo.write(cveResult +","+ descResult +","+ servResult )
fileo.close() 