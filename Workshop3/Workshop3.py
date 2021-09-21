import yaml


def check(file):
    with open(file, "r") as stream:
        try:
            # print(yaml.safe_load(stream))
            content = yaml.safe_load(stream)
            for i, content in enumerate(content):
                if content == "sat_user" or content == "sat_pass" or content == "katello_user" or content == "name" or content == "katello_password" or content == "rootpw" in content:
                    print("Security weakness name: Hard-Coded Secret")
                    print("Security weakness location: Varible '", content, "' in line# '", i, "'")
                    print("Security weakness usage: ", file) 
                if content == "sat_user" or content == "name" in content:
                    print("Security weakness name: Admin by Default")
                    print("Security weakness location: Varible '", content, "' in line# '", i, "'")
                    print("Security weakness usage: ", file) 
                if content == "epel_repo_installer" or content == "epel_release_rpm" in content:
                    print("Security weakness name: No Integrity Check")
                    print("Security weakness location: Varible '", content, "' in line# '", i, "'")
                    print("Security weakness usage: ", file) 
                if content == "foreman_repository_base" or content == "foreman_plugin_repository_base" or content == "content_rhel_url" or content == "content_sattools_url" or content == "test_sync_repositories_url_template" or content == "vms_kss_os" in content:
                    print("Security weakness name: Use of HTTP without SSL/TLS")
                    print("Security weakness location: Varible '", content, "' in line# '", i, "'")
                    print("Security weakness usage: ", file) 
                if content == "ip" in content:
                    print("Security weakness name: Unrestricted IP Address")
                    print("Security weakness location: Varible '", content, "' in line# '", i, "'")
                    print("Security weakness usage: ", file) 

        except:
            print("exc")

    stream.close()
    return 0

file1 = "Workshop3.values.yaml"
file2 = "Workshop3.play1.yaml"
file3 = "Workshop3.play2.yaml"

check(file1)
print("File 1 done")
check(file2)
print("File 2 done")
check(file3)
print("File 3 done")


   

##[sat_user, sat_user = admin, hammer -u "{{ sat_user }}" -p "{{ sat_pass }}" product create --organization-id "{{ sat_orgid }}" --name "{{ content_rhel_name }}"]