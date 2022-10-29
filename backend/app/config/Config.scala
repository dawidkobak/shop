package config

import com.typesafe.config.ConfigFactory

object Config {
  val config = ConfigFactory.load()
  val googleApiKey = config.getString("GOOGLE_API_KEY")
  val mongodbUri = config.getString("mongodbUri")
}
