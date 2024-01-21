@echo off

REM Step 1: Clone repository if folder doesn't exist
if not exist appinventor-sources-master (
    git clone https://github.com/haifrosch/appinventor-sources-master.git
)

cd appinventor-sources-master

REM Step 2: Check and install vagrant-vbguest plugin
vagrant plugin list | find "vagrant-vbguest" > nul
if %errorlevel% neq 0 (
    vagrant plugin install vagrant-vbguest
)

REM Step 3: Bring up the Vagrant environment
vagrant up

REM Step 4: SSH into the Vagrant box
vagrant ssh -c "
    REM Step 5: Update and initialize submodules
    git submodule update --init

    REM Step 6: Build with ant
    ant

    REM Step 7: Start App Inventor
    start_appinventor
"
