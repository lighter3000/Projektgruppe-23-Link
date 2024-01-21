#!/bin/bash

# Step 1: Clone repository if folder doesn't exist
if [ ! -d "appinventor-sources-master" ]; then
    git clone https://github.com/haifrosch/appinventor-sources-master.git
fi

cd appinventor-sources-master

# Step 2: Check and install vagrant-vbguest plugin
if ! vagrant plugin list | grep -q 'vagrant-vbguest'; then
    vagrant plugin install vagrant-vbguest
fi

# Step 3: Bring up the Vagrant environment
vagrant up

# Step 4: SSH into the Vagrant box
vagrant ssh <<'ENDSSH'
    # Step 5: Update and initialize submodules
    git submodule update --init

    # Step 6: Build with ant
    ant

    # Step 7: Start App Inventor
    start_appinventor
ENDSSH
