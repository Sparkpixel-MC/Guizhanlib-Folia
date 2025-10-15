repositories {
    flatDir {
        dirs ("libs")
    }
}

dependencies {
    api(project(":guizhanlib-common", configuration = "shadow"))
    api(project(":guizhanlib-localization", configuration = "shadow"))
    api(project(":guizhanlib-minecraft", configuration = "shadow"))
    compileOnly("com.github.SlimefunGuguProject:Slimefun4:test")
    compileOnly("com.molean.folia.adapter:FoliaAdapter:test")
}
