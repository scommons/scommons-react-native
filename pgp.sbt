
//see: https://www.scala-sbt.org/sbt-pgp/usage.html

pgpPublicRing := file("./travis/pubring.gpg")
pgpSecretRing := file("./travis/secring.gpg")
pgpPassphrase := sys.env.get("PGP_PASS").map(_.toArray)
