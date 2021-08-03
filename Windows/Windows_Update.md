# Troubleshoot Windows Update
Run following commands to troubleshoot windows update:
```bash
# Stop windows update service
net stop wuauserv
# Stop windows crypto service
net stop cryptSvc
# Stop windows bits service
net stop bits
# Stop windows installer service
net stop msiserver

# Rename "SoftwareDistribution" folder to "SoftwareDistribution.old'
ren C:\Windows\SoftwareDistribution SoftwareDistribution.old

# Rename "catroot2" folder to "Catroot2.old'
ren C:\Windows\System32\catroot2 Catroot2.old

# Start windows update service
net start wuauserv
# Start windows crypto service
net start cryptSvc
# Start windows bits service
net start bits
# Start windows installer service
net start msiserver
```