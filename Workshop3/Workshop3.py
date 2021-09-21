import yaml

with open("Workshop3.values.yaml", "r") as stream:
    try:
        # print(yaml.safe_load(stream))
        content = yaml.safe_load(stream)
        for i, content in enumerate(content):
            print(i, content)
    except:
        print("exc")




   
#'''
#with open("Workshop3.values.yaml", "r") as stream:
#    lines = []
#    x = 1
#    for line in stream:
#        print(line)
#        if line.find(admin) in line:
#           print("Security weakness name: ")
#           x = x + 1
#           lines.append(line)
#    try:
#      # print(yaml.safe_load(stream))
#       content = yaml.safe_load(stream)
#       print(stream.read())
#       for k, v in content.items():
#           if "name" in content:
#               print(k, v)

#    except:
#        print("exc")

##[sat_user, sat_user = admin, hammer -u "{{ sat_user }}" -p "{{ sat_pass }}" product create --organization-id "{{ sat_orgid }}" --name "{{ content_rhel_name }}"]
#'''