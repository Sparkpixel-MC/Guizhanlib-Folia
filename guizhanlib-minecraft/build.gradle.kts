dependencies {
    api(project(":guizhanlib-common", configuration = "shadow"))
    api(project(":guizhanlib-localization", configuration = "shadow"))
    api("io.papermc:paperlib:1.0.8")
    testImplementation("com.github.seeseemelk:MockBukkit-v1.20:3.93.2")
}
