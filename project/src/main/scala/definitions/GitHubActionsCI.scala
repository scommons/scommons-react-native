package definitions

import org.scoverage.coveralls.CIService

import scala.io.Source
import scala.util.parsing.json.{JSON, JSONObject}

case object GitHubActionsCI extends CIService {
  val name = ""
  val jobId: Option[String] = sys.env.get("GITHUB_RUN_ID")

  // https://github.com/coverallsapp/github-action/blob/master/src/run.ts#L31-L40
  val pullRequest: Option[String] = for {
    eventName <- sys.env.get("GITHUB_EVENT_NAME") if eventName.startsWith("pull_request")
    payloadPath <- sys.env.get("GITHUB_EVENT_PATH")
    source = Source.fromFile(payloadPath, "utf-8")
    lines = try source.mkString finally source.close()
    payload <- JSON.parseRaw(lines)
    prNumber <- payload.asInstanceOf[JSONObject].obj.get("number")
  } yield prNumber.toString.stripSuffix(".0")

  // https://docs.github.com/en/actions/learn-github-actions/environment-variables
  val currentBranch: Option[String] = pullRequest match {
    case Some(_) => sys.env.get("GITHUB_HEAD_REF")
    case None => sys.env.get("GITHUB_REF_NAME")
  }
}
