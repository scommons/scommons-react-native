import java.util.Base64

//see: https://www.scala-sbt.org/sbt-pgp/usage.html
pgpPublicRing := file("./keys/pubring.gpg")
pgpSecretRing := file("./keys/secring.gpg")
pgpPassphrase := sys.env.get("PGP_PASS").map(p => new String(Base64.getDecoder.decode(p)).toArray)
