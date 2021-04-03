import de.heikoseeberger.sbtheader.{LicenseDetection, LicenseStyle}

ThisBuild / organization := "org.http4s"
ThisBuild / organizationName := "Typelevel"

ThisBuild / crossScalaVersions := Seq("2.12.13", "2.13.5", "3.0.0-RC1", "3.0.0-RC2")
ThisBuild / scalaVersion := crossScalaVersions.value.filter(_.startsWith("2.")).last
ThisBuild / baseVersion := "1.1"
ThisBuild / publishGithubUser := "rossabaker"
ThisBuild / publishFullName := "Ross A. Baker"
ThisBuild / githubWorkflowPublishTargetBranches := Seq(RefPredicate.StartsWith(Ref.Tag("v")))

val JawnVersion   = "1.1.1"
val Fs2Version    = "2.5.4"
val Specs2Version = "4.10.6"

enablePlugins(SonatypeCiReleasePlugin)

libraryDependencies ++= Seq(
  "org.typelevel"  %% "jawn-parser" % JawnVersion,
  "co.fs2"         %% "fs2-core"    % Fs2Version,
  "org.typelevel"  %% "jawn-ast"    % JawnVersion   % Test,
  "co.fs2"         %% "fs2-io"      % Fs2Version    % Test,
  "org.specs2"     %% "specs2-core" % Specs2Version % Test withDottyCompat scalaVersion.value,
)

versionIntroduced := Map(
  "3.0.0-M1" -> "1.0.1",
  "3.0.0-M2" -> "1.0.1",
  "3.0.0-M3" -> "1.0.1",
  "3.0.0-RC1" -> "1.1.0",
  "3.0.0-RC2" -> "1.1.1",
)
