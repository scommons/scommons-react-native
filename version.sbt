version in ThisBuild := sys.env.getOrElse("version", default = "1.0.0-SNAPSHOT").stripPrefix("v")
