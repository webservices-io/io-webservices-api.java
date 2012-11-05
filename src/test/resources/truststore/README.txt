truststore.jks is a Java truststore with just 1 entry.

To see its contents, run:

$ keytool -list -keystore truststore.jks
Password: changeit

Output:

Keystore type: JKS
Keystore provider: SUN

Your keystore contains 1 entry

api.webservices.io-1, Nov 6, 2012, trustedCertEntry,
Certificate fingerprint (MD5): AA:70:C1:D0:82:33:57:EE:74:36:B1:B2:E7:6B:59:9B



