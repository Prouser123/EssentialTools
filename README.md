# EssentialTools

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/37f9d3613d6946d791e634b5f90c2c3d)](https://app.codacy.com/app/CodeNet/EssentialTools?utm_source=github.com&utm_medium=referral&utm_content=Prouser123/EssentialTools&utm_campaign=Badge_Grade_Dashboard)
[![TravisCI Build Status](https://travis-ci.com/Prouser123/EssentialTools.svg?branch=master)](https://travis-ci.com/Prouser123/EssentialTools)
![Build Type - Shields.io](https://img.shields.io/badge/type-maven-red.svg)
![Lines of Code](https://tokei.rs/b1/github/Prouser123/EssentialTools)

A Bukkit / Spigot plugin.
Work in progress.

## Manual Dependency Setup

CraftBukkit is required for this project. You need to use BuildTools to compile it, as it cannot be distributed.

1.  Download BuildTools from [here](https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar).

2.  Then run it with this command:

    `java -jar BuildTools.jar --rev 1.12`

3.  Then copy `craftbukkit-1.12.jar` into the `lib` folder.

4.  Then run `maven clean` and `maven install` to build the project.
